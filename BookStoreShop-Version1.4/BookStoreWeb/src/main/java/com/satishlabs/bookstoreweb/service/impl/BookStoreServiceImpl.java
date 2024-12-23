/**
 * 
 */
package com.satishlabs.bookstoreweb.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.satishlabs.bookstoreweb.dto.Book;
import com.satishlabs.bookstoreweb.dto.BookInfo;
import com.satishlabs.bookstoreweb.dto.Order;
import com.satishlabs.bookstoreweb.dto.UserRating;
import com.satishlabs.bookstoreweb.proxy.BookPriceProxy;
import com.satishlabs.bookstoreweb.proxy.BookSearchProxy;
import com.satishlabs.bookstoreweb.proxy.PlaceOrderProxy;
import com.satishlabs.bookstoreweb.proxy.UserRatingProcxy;
import com.satishlabs.bookstoreweb.service.BookStoreService;
import com.satishlabs.rabbitmq.OrderFullInfo;
import com.satishlabs.rabbitmq.OrderInfo;
import com.satishlabs.rabbitmq.OrderItemInfo;
import com.satishlabs.rabbitmq.UserRatingInfo;

/**
 * @author Satish
 * 
 * Jul 18, 2022
 */

@Service
public class BookStoreServiceImpl implements BookStoreService {
	static Logger logInfo = LoggerFactory.getLogger(BookStoreServiceImpl.class);

	Map<Integer, Book> booksMap = new LinkedHashMap<>();
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private BookPriceProxy bookPriceProxy;
	
	@Autowired
	private BookSearchProxy bookSearchProxy;
	
	@Autowired
	private UserRatingProcxy userRatingProcxy;
	
	@Autowired
	private PlaceOrderProxy placeOrderProxy;

	@Override
	public List<String> getAuthorsList() {
		logInfo.info("----BookStoreServiceImpl --- getAuthorsList()----");
		List<String> authorsList = new ArrayList<>();
		authorsList.add("All Authors");
		authorsList.add("Srinivas");
		authorsList.add("Vas");
		authorsList.add("Sri");
		return authorsList;

	}

	@Override
	public List<String> getCategoryList() {
		logInfo.info("----BookStoreServiceImpl --- getCategoryList()----");
		List<String> catList = new ArrayList<>();
		catList.add("All Categories");
		catList.add("Web");
		catList.add("Spring");
		return catList;

	}

	@Override
	public List<Book> getMyBooks(String author, String category) {
		logInfo.info("----BookStoreServiceImpl --- getMyBooks()----");
		if (author == null || author.length() == 0) {
			author = "All Authors";
		}
		if (category == null || category.length() == 0) {
			category = "All Categories";
		}
		// Invoke BookSearchMS Rest API with RestTemplate
		/*RestTemplate bookSearchRest = new RestTemplate();
		String endpoint = "http://localhost:8000/mybooks/" + author + "/" + category;
		List<Map> list = bookSearchRest.getForObject(endpoint, List.class);
		List<Book> bookList = new ArrayList<>();
		for (Map mymap : list) {
			Book mybook = convertMapToBook(mymap);
			bookList.add(mybook);
			booksMap.put(mybook.getBookId(), mybook);
		}*/
		
		// Invoke BookSearchMS Rest API with Feign
		List<Book> bookList = bookSearchProxy.getBooksByAuthorAndCategory(author, category);
		for(Book mybook : bookList) {
			booksMap.put(mybook.getBookId(), mybook);
		}
		return bookList;
	}

	@Override
	public Book getBookByBookId(Integer bookId) {
		logInfo.info("----BookStoreServiceImpl --- getBookByBookId()----");
		System.out.println(bookId);
		Book mybook = booksMap.get(bookId);
		return mybook;

	}

	@Override
	public BookInfo getBookInfoByBookId(Integer bookId) {
		logInfo.info("----BookStoreServiceImpl --- getBookInfoByBookId()----");
		// Invoke BookSearch Controller Rest API with RestTemplate
		/*RestTemplate bookSearchRest = new RestTemplate();
		String endpoint = "http://localhost:8000/mybook/" + bookId;
		BookInfo bookInfo = bookSearchRest.getForObject(endpoint, BookInfo.class);
		*/
		// Invoke BookPrice Controller Rest API with Feign
		BookInfo bookInfo = bookSearchProxy.getBookById(bookId);
		return bookInfo;

	}

	@Override
	public void placeOrder(Map<Integer, Book> mycartMap) {
		logInfo.info("----2. BookStoreServiceImpl --- placeOrder()----");
		
		List<OrderItemInfo> itemList = new ArrayList<>();
		double totalPrice = 0.0;
		int totalQuantity = 0;
		
		for (Book mybook : mycartMap.values()) {
			Integer bookId = mybook.getBookId();
			// Invoke BookPrice Controller Rest API with RestTemplate
			/*RestTemplate bookPriceRest = new RestTemplate();
			String priceEndpoint = "http://localhost:9000/offerprice/" + bookId;
			double offerPrice = bookPriceRest.getForObject(priceEndpoint, Double.class);
			*/
			// Invoke BookPrice Controller Rest API with Feign
			double offerPrice = bookPriceProxy.getOfferPrice(bookId);
			OrderItemInfo item = new OrderItemInfo(0, bookId, 1, offerPrice);
			itemList.add(item);
			
			totalPrice = totalPrice + offerPrice;
			totalQuantity = totalQuantity + 1;
		}
		
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		String orderDate = formatter.format(today);
		System.out.println(orderDate);
		
		OrderInfo orderInfo = new OrderInfo(orderDate, "U-12", totalQuantity, totalPrice, "New");
		OrderFullInfo orderFullInfo = new OrderFullInfo();
		orderFullInfo.setOrder(orderInfo);
		orderFullInfo.setItemsList(itemList);
		// Invoke PlaceOrder MS
		//Order Sending Message to RabbitMQ
		rabbitTemplate.convertAndSend("myorder.exchange","myorder.key", orderFullInfo);
		System.out.println("Order Placed");
		System.out.println("Order Placed");
	}
	
	@Override
	public List<Order> getMyOrders(String userId) {
		//Invoke PlaceOrderMS Rest API with RestTeamplate
		/*String orderEndpoint = "http://localhost:7000/myorders/U-12";
		RestTemplate orderRest = new RestTemplate();
		List<Order> myorders = orderRest.getForObject(orderEndpoint, List.class);
		*/
		//Invoke PlaceOrderMS Rest API with Feign
		List<Order> myorders = placeOrderProxy.getOrdersByUserId(userId);
		return myorders;
	}
	
	@Override
	public void addUserRating(UserRating userRating) {
		logInfo.info("----2. BookStoreServiceImpl --- addUserRating()----");
		// Invoke UserRating MS
		UserRatingInfo userRatingInfo = new UserRatingInfo(userRating.getUserId(), userRating.getBookId(), userRating.getRating(), userRating.getReview());
		rabbitTemplate.convertAndSend("myuser.ratings.exchange","myuser.ratings.key", userRatingInfo);
		System.out.println("Rating Added...");
	}
	

	@Override
	public List<UserRating> getMyRatings(String userId) {
		logInfo.info("----BookStoreServiceImpl --- getMyRatings()----");
		List<UserRating> ratingsList = new ArrayList<>();
		// Invoke UserRating MS Rest API with RestTemplate
		/*String ratingEndpoint = "http://localhost:6500/userrating/" + userId;
		RestTemplate ratingRest = new RestTemplate();
		List<Map> mymap = ratingRest.getForObject(ratingEndpoint, List.class);
		for (Map map : mymap) {
			UserRating urtaing = convertMapToUserRating(map);
			ratingsList.add(urtaing);
			System.out.println(map);
		}*/
		// Invoke UserRating MS Rest API with Feign
		ratingsList = userRatingProcxy.getUserRatingByUserId(userId);
		System.out.println("ratingsList===>"+ratingsList);
		return ratingsList;
	}

	private UserRating convertMapToUserRating(Map map) {
		UserRating rating = new UserRating();
		rating.setRatingId(new Integer(map.get("ratingId").toString()));
		rating.setUserId(map.get("userId").toString());
		rating.setBookId(new Integer(map.get("bookId").toString()));
		rating.setRating(new Double(map.get("rating").toString()));
		rating.setReview(map.get("review").toString());
		return rating;
	}

	private Book convertMapToBook(Map map) {
		Book mybook = new Book();
		mybook.setBookId(Integer.parseInt(map.get("bookId").toString()));
		mybook.setBookName((map.get("bookName").toString()));
		mybook.setAuthor((map.get("author").toString()));
		mybook.setPublications(map.get("publications").toString());
		mybook.setCategory(map.get("category").toString());
		return mybook;
	}

}
