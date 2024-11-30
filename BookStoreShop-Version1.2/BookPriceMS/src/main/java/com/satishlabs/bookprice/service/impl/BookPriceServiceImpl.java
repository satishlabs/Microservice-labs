package com.satishlabs.bookprice.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.bookprice.dao.BookPriceDAO;
import com.satishlabs.bookprice.entity.BookPrice;
import com.satishlabs.bookprice.service.BookPriceService;

@Service
@Transactional
public class BookPriceServiceImpl implements BookPriceService{
	static Logger logInfo=LoggerFactory.getLogger(BookPriceServiceImpl.class);
	
	@Autowired
	private BookPriceDAO bookDao;

	@Override
	public BookPrice getBookPrice(Integer bookId) {
		logInfo.info("----- BookPriceServiceImpl --- getBookPrice()-----");
		BookPrice bookPrice = null;
		Optional<BookPrice> findById = bookDao.findById(bookId);
		if(findById.isPresent()) {
			bookPrice = findById.get();
		}
		return bookPrice;
	}

	@Override
	public double getOfferPrice(Integer bookId) {
		logInfo.info("----- BookPriceServiceImpl --- getOfferPrice()-----");

		double offerPrice = 0.0;
		Optional<BookPrice> findById = bookDao.findById(bookId);
		if(findById.isPresent()) {
			BookPrice bookPrice = findById.get();
			double price = bookPrice.getPrice();
			double offer = bookPrice.getOffer();
			
			if(offer <= 0) {
				return price;
			}
			offerPrice = price-price*offer/100;
		}
		return offerPrice;
	}
	
	
}
