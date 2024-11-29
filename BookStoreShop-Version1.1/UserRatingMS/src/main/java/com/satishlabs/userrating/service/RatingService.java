/**
 * 
 */
package com.satishlabs.userrating.service;

import java.util.List;

import com.satishlabs.userrating.entity.BookRating;
import com.satishlabs.userrating.entity.UserRating;

/**
 * @author Satish

 * Jul 18, 2022
 */
public interface RatingService {
	public void addUserRating(UserRating userRating);
	public List<UserRating> getUserRatingByUserId(String userId);
	public void updateBookRating(BookRating bookRating);
	public BookRating getBookRatingByBookId(Integer bookId);
}
