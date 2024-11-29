package com.satishlabs.bookprice.service;

import com.satishlabs.bookprice.entity.BookPrice;

public interface BookPriceService {
	public BookPrice getBookPrice(Integer bookId);
	public double getOfferPrice(Integer bookId);
}
