package com.satishlabs.booksearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mybooks",schema = "booksdb")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_Id")
	private Integer bookId;
	
	@Column(name = "book_Name")
	private String bookName;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "publications")
	private String publications;

	public Book() {}
	
	public Book(Integer bookId, String bookName, String author, String category, String publications) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.publications = publications;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", category=" + category
				+ ", publications=" + publications + "]";
	}
	
	
}
