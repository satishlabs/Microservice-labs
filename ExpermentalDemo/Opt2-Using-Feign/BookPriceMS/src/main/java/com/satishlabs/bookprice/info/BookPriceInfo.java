package com.satishlabs.bookprice.info;

public class BookPriceInfo {
	private Integer bookId;
	private double price;
	private double offer;
	private String serverPort;
	
	public BookPriceInfo() {}
	
	public BookPriceInfo(Integer bookId, double price, double offer, String serverPort) {
		this.bookId = bookId;
		this.price = price;
		this.offer = offer;
		this.serverPort = serverPort;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	
	
}
