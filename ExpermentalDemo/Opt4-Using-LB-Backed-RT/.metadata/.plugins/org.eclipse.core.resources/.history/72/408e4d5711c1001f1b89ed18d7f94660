package com.satishlabs.booksearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.satishlabs.booksearch.dto.BookInfo;
import com.satishlabs.booksearch.dto.BookPriceInfo;



@CrossOrigin
@RestController
public class BookSearchController {
	static Logger logInfo=LoggerFactory.getLogger(BookSearchController.class);
	
	
	@GetMapping("/mybook/{bookId}")
	public BookInfo getBookById(@PathVariable Integer bookId) {
		logInfo.info("---- BookSearchController --- getBookById() ----");
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookId(bookId);
		bookInfo.setBookName("Master Spring Microservices");
		bookInfo.setAuthor("Satish Prasad");
		bookInfo.setCategory("Java");
		bookInfo.setPublications("SatishLabs");
		
		//Need to invoke BookPriceMS
		
		RestTemplate restTemplate = new RestTemplate();
		String baseURL = "http://localhost:9000";
		String apiURL = "/bookprice/"+bookId;
		String endpoint = baseURL+apiURL;
		ResponseEntity<BookPriceInfo> responseEntity =  restTemplate.getForEntity(endpoint, BookPriceInfo.class);
		
		BookPriceInfo bookPriceInfo = responseEntity.getBody();
		bookInfo.setPrice(bookPriceInfo.getPrice());
		bookInfo.setOffer(bookPriceInfo.getOffer());
		bookInfo.setServerPort(bookPriceInfo.getServerPort());
		//End Here
		
		return bookInfo;
	}

}
