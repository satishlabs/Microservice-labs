/**
 * 
 */
package com.satishlabs.userrating.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.userrating.entity.BookRating;

/**
 * @author Satish

 * Jul 18, 2022
 */
public interface BookRatingDAO extends JpaRepository<BookRating, Integer>{

}
