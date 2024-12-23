package com.satishlabs.booksearch.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.satishlabs.booksearch.dto.BookPriceInfo;



@FeignClient(name="BookPriceMS", url = "http://localhost:9000")
public interface BookPriceProxy {
	@GetMapping("/bookprice/{bookId}")
	public BookPriceInfo getBookPrice(@PathVariable Integer bookId);
}
