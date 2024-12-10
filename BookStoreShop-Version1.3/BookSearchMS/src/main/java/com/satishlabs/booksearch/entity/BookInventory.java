package com.satishlabs.booksearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mybookinventory",schema = "booksdb")
public class BookInventory {
	@Id
	@Column(name = "book_Id")
	private Integer bookId;
	
	@Column(name = "books_available")
	private int booksAvailable;
	
	public BookInventory() {}
	
	public BookInventory(Integer bookId, int booksAvailable) {
		super();
		this.bookId = bookId;
		this.booksAvailable = booksAvailable;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getBooksAvailable() {
		return booksAvailable;
	}

	public void setBooksAvailable(int booksAvailable) {
		this.booksAvailable = booksAvailable;
	}

	@Override
	public String toString() {
		return "BookInventory [bookId=" + bookId + ", booksAvailable=" + booksAvailable + "]";
	}
	
	

}
