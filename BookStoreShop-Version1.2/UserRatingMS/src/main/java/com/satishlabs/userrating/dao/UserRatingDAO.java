/**
 * 
 */
package com.satishlabs.userrating.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.userrating.entity.UserRating;

/**
 * @author Satish

 * Jul 18, 2022
 */
public interface UserRatingDAO extends JpaRepository<UserRating, Integer>{
	public List<UserRating> getUserRatingByBookId(Integer bookId);
	public List<UserRating> getUserRatingByUserId(String userId);
}
