package com.satishlabs.booksearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.booksearch.dto.BookInfo;
import com.satishlabs.booksearch.dto.BookPriceInfo;
import com.satishlabs.booksearch.proxy.BookPriceProxy;



@CrossOrigin
@RestController
public class BookSearchController {
	static Logger logInfo=LoggerFactory.getLogger(BookSearchController.class);
	
	@Autowired
	private BookPriceProxy bookPriceProxy;
	
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
		
		BookPriceInfo bookPriceInfo = bookPriceProxy.getBookPrice(bookId);
		bookInfo.setPrice(bookPriceInfo.getPrice());
		bookInfo.setOffer(bookPriceInfo.getOffer());
		bookInfo.setServerPort(bookPriceInfo.getServerPort());
		//End Here
		
		return bookInfo;
	}

}
