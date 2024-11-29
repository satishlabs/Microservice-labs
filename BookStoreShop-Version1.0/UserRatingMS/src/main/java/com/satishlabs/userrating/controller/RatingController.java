/**
 * 
 */
package com.satishlabs.userrating.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.userrating.entity.BookRating;
import com.satishlabs.userrating.entity.UserRating;
import com.satishlabs.userrating.service.RatingService;

/**
 * @author Satish

 * Jul 18, 2022
 */
@CrossOrigin
@RestController
public class RatingController {
	static Logger logInfo = LoggerFactory.getLogger(RatingController.class);
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/addusrrating")
	public void addUserRating(@RequestBody UserRating userRating) {
		logInfo.info("----RatingController ---addUserRating()----");
		ratingService.addUserRating(userRating);
	}
	
	@GetMapping("/userrating/{userId}")
	public List<UserRating> getUserRatingByUserId(@PathVariable String userId){
		logInfo.info("----RatingController ---getUserRatingByUserId()----");
		return ratingService.getUserRatingByUserId(userId);
	}
	
	@GetMapping("/bookrating/{bookId}")
	public BookRating getBookRatingByBookId(@PathVariable Integer bookId) {
		logInfo.info("----RatingController ---getBookRatingByBookId()----");
		return ratingService.getBookRatingByBookId(bookId);
	}
}
