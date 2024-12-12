/**
 * 
 */
package com.satishlabs.userrating.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.satishlabs.rabbitmq.BookRatingInfo;
import com.satishlabs.rabbitmq.UserRatingInfo;
import com.satishlabs.userrating.dao.BookRatingDAO;
import com.satishlabs.userrating.dao.UserRatingDAO;
import com.satishlabs.userrating.entity.BookRating;
import com.satishlabs.userrating.entity.UserRating;
import com.satishlabs.userrating.service.RatingService;

/**
 * @author Satish

 * Jul 18, 2022
 */
@Service
@Transactional
public class RatingServiceImpl implements RatingService{
	static Logger logInfo = LoggerFactory.getLogger(RatingServiceImpl.class);
	@Autowired
	private UserRatingDAO userRatingDAO;
	
	@Autowired
	private BookRatingDAO bookRatingDAO;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@RabbitListener(queues = "myuser.ratings.queue")
	public void addUserRating(UserRatingInfo userRatingInfo) {
		logInfo.info("---- 3. RatingServiceImpl --- addUserRating() ----");
		UserRating userRating = new UserRating(userRatingInfo.getBookId(), userRatingInfo.getUserId(), userRatingInfo.getRating(), userRatingInfo.getReview());
		//1. add the UserRating
		userRatingDAO.save(userRating);
		
		//2. Calculate the Avg Rating for BookId
		int bookId = userRating.getBookId();
		List<UserRating> ratingList = userRatingDAO.getUserRatingByBookId(bookId);
		
		double sumRating = 0.0;
		for(UserRating ur : ratingList) {
			sumRating = sumRating+ur.getRating();
		}
		
		double avgRating = sumRating/ratingList.size();
		
		//3. Update BookRating in UserRatingMS(Local)
		BookRating bookRating = bookRatingDAO.findById(bookId).get();
		bookRating.setAvgRating(avgRating);
		bookRatingDAO.save(bookRating);
		
		//4. Update BookRating in BookSearchMS
		//By Sending Message to RabbitMQ
		BookRatingInfo bookRatingInfo = new BookRatingInfo();
		bookRatingInfo.setBookId(bookRating.getBookId());
		bookRatingInfo.setAvgRating(bookRating.getAvgRating());
		bookRatingInfo.setNumberOfSearches(bookRating.getNumberOfSearches());
		
		rabbitTemplate.convertAndSend("mybook.search.exchange","mybook.ratings.key", bookRatingInfo);
		//bookSearchRest.postForObject(endpoint, bookRating, Void.class);
		
	}


	@Override
	public List<UserRating> getUserRatingByUserId(String userId) {
		logInfo.info("---- RatingServiceImpl --- getUserRatingByUserId() ----");
		return userRatingDAO.getUserRatingByUserId(userId);
	}

	@Override
	public void updateBookRating(BookRating bookRating) {
		logInfo.info("---- RatingServiceImpl --- updateBookRating() ----");
		bookRatingDAO.save(bookRating);
	}

	@Override
	public BookRating getBookRatingByBookId(Integer bookId) {
		logInfo.info("---- RatingServiceImpl --- getBookRatingByBookId() ----");
		BookRating bookRating = bookRatingDAO.findById(bookId).get();
		return bookRating;
	}

}
