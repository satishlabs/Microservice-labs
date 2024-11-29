package com.satishlabs.booksearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mybookratings",schema = "booksdb")
public class BookRating {
	@Id
	@Column(name = "book_Id")
	private Integer bookId;
	
	@Column(name = "avg_rating")
	private double avgRating;
	
	@Column(name = "number_of_searches")
	private int numberOfSearches;
	
	public BookRating() {}
	
	public BookRating(Integer bookId, double avgRating, int numberOfSearches) {
		super();
		this.bookId = bookId;
		this.avgRating = avgRating;
		this.numberOfSearches = numberOfSearches;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public int getNumberOfSeaches() {
		return numberOfSearches;
	}

	public void setNumberOfSeaches(int numberOfSearches) {
		this.numberOfSearches = numberOfSearches;
	}
	
	
}
