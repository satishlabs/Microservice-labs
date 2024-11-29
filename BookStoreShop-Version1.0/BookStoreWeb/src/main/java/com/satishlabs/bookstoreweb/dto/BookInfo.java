/**
 * 
 */
package com.satishlabs.bookstoreweb.dto;

/**
 * @author Satish

 * Jul 18, 2022
 */
public class BookInfo {
	private Integer bookId;
	private String bookName;
	private String author;
	private String category;
	private String publications;
	private double price;
	private int offer;
	private double avgRating;
	private int numberOfSearches;
	
	public BookInfo() {}
	
	public BookInfo(String bookName, String author, String category, String publications, double price,
			int offer, double avgRating, int numberOfSearches) {
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.publications = publications;
		this.price = price;
		this.offer = offer;
		this.avgRating = avgRating;
		this.numberOfSearches = numberOfSearches;
	}
	public BookInfo(Integer bookId, String bookName, String author, String category, String publications, double price,
			int offer, double avgRating, int numberOfSearches) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.publications = publications;
		this.price = price;
		this.offer = offer;
		this.avgRating = avgRating;
		this.numberOfSearches = numberOfSearches;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public int getNumberOfSearches() {
		return numberOfSearches;
	}

	public void setNumberOfSearches(int numberOfSearches) {
		this.numberOfSearches = numberOfSearches;
	}
	
	
	
}
