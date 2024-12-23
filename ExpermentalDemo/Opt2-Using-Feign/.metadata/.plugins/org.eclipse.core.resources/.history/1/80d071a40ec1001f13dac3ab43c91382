package com.satishlabs.bookprice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.bookprice.info.BookPriceInfo;

@CrossOrigin
@RestController
public class BookPriceController {
	static Logger logInfo=LoggerFactory.getLogger(BookPriceController.class);
	
	@Value(value="${server.port}")
	String serverPort;
	
	@GetMapping("/bookprice/{bookId}")
	public BookPriceInfo getBookPrice(@PathVariable Integer bookId) {
		logInfo.info("----- BookPriceController --- getBookPrice()---");
		BookPriceInfo bookPriceInfo = new BookPriceInfo(bookId, 5000, 10, serverPort);
		return bookPriceInfo;
	}
	
}
