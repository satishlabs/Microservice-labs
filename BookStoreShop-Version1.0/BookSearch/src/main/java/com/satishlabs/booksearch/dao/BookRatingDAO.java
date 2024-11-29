package com.satishlabs.booksearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.booksearch.entity.BookRating;

public interface BookRatingDAO extends JpaRepository<BookRating, Integer> {
	//public BookRating getBookRatingByBookId(Integer bookId);
}
