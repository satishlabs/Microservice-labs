package com.satishlabs.bookstoreweb.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.satishlabs.bookstoreweb.dto.BookPriceInfo;



//@FeignClient(value = "BookPriceMS", url = "http://localhost:9000")
@FeignClient(name = "BookPriceMS")
public interface BookPriceProxy {
	
	@GetMapping("/bookprice/{bookId}")
	public BookPriceInfo getBookPrice(@PathVariable Integer bookId);
	
	@GetMapping("/offerprice/{bookId}")
	public double getOfferPrice(@PathVariable Integer bookId);
}
