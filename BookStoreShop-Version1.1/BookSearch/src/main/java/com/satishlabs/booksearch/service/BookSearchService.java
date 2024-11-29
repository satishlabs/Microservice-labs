package com.satishlabs.booksearch.service;

import java.util.List;

import com.satishlabs.booksearch.dto.BookInfo;
import com.satishlabs.booksearch.entity.Book;
import com.satishlabs.booksearch.entity.BookInventory;
import com.satishlabs.booksearch.entity.BookRating;

public interface BookSearchService {
	public List<Book> getBooks(String author,String category);
	public BookInfo getBookInfo(Integer bookId);
	public void updateBookRating(BookRating bookRating);
	public void updateBookInventory(BookInventory bookInventory);
}
