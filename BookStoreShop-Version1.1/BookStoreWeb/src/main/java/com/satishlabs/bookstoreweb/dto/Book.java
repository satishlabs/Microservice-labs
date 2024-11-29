/**
 * 
 */
package com.satishlabs.bookstoreweb.dto;

/**
 * @author Satish

 * Jul 18, 2022
 */
public class Book {
	private Integer bookId;
	private String bookName;
	private String author;
	private String category;
	private String publications;
	
	public Book() {}
	
	public Book(String bookName, String author, String category, String publications) {
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.publications = publications;
	}
	public Book(Integer bookId, String bookName, String author, String category, String publications) {
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
	
	
}
