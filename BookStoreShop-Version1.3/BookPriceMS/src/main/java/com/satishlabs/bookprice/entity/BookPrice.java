package com.satishlabs.bookprice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "mybookprice",schema = "bookpricedb")
public class BookPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookId_generator")
	@SequenceGenerator(name = "bookId_generator",sequenceName = "mybookId_gen", initialValue = 110,allocationSize = 1)
	@Column(name = "book_id")
	private Integer bookId;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "offer")
	private double offer;

	public BookPrice() {}
	public BookPrice(Integer bookId, Integer price, double offer) {
		super();
		this.bookId = bookId;
		this.price = price;
		this.offer = offer;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	
	
	
}