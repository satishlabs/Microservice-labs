package com.satishlabs.booksearch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.booksearch.dto.BookInfo;
import com.satishlabs.booksearch.entity.Book;
import com.satishlabs.booksearch.service.BookSearchService;



@CrossOrigin
@RestController
public class BookSearchController {
	static Logger logInfo=LoggerFactory.getLogger(BookSearchController.class);
	
	@Autowired
	private BookSearchService bookSearchService;
	
	@GetMapping("/mybooks/{author}/{category}")
	public List<Book> getBooksByAuthorAndCategory(@PathVariable String author,@PathVariable String category){
		logInfo.info("---- BookSearchController --- getBooksByAuthorAndCategory() ----");
		System.out.println(author+" And "+category);
		return bookSearchService.getBooks(author, category);
		
	}
	
	@GetMapping("/mybook/{bookId}")
	public BookInfo getBookById(@PathVariable Integer bookId) {
		logInfo.info("---- BookSearchController --- getBookById() ----");
		return bookSearchService.getBookInfo(bookId);
	}
	
	/*
	@PutMapping("/updateBookRating")
	public void updateBookRating(@RequestBody BookRating bookRating) {
		logInfo.info("---- BookSearchController --- updateBookRating() ----");
		bookSearchService.updateBookRating(bookRating);
	}
	
	@PutMapping("/updateBookInventory")
	public void updateBookInventory(@RequestBody BookInventory bookInventory) {
		logInfo.info("---- BookSearchController --- updateBookInventory() ----");
		bookSearchService.updateBookInventory(bookInventory);
	}
	*/
}
