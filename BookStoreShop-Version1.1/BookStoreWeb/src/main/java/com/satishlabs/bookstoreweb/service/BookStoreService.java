/**
 * 
 */
package com.satishlabs.bookstoreweb.service;

import java.util.List;
import java.util.Map;

import com.satishlabs.bookstoreweb.dto.Book;
import com.satishlabs.bookstoreweb.dto.BookInfo;
import com.satishlabs.bookstoreweb.dto.UserRating;

/**
 * @author Satish

 * Jul 18, 2022
 */
public interface BookStoreService {
	public List<Book> getMyBooks(String author,String category);
	public Book getBookByBookId(Integer bookId);
	public BookInfo getBookInfoByBookId(Integer bookId);
	
	public void placeOrder(Map<Integer, Book> mycartMap);
	
	public void addUserRating(UserRating userRating);
	public List<UserRating> getMyRatings(String userId);
	
	public List<String> getAuthorsList();
	public List<String> getCategoryList();
}
