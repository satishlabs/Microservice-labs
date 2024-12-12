package com.satishlabs.bookstoreweb.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.satishlabs.bookstoreweb.dto.Order;


@FeignClient(value = "PlaceOrderMS", url = "http://localhost:7000")
public interface PlaceOrderProxy {
	
	@GetMapping("/myorders/{userId}")
	public List<Order> getOrdersByUserId(@PathVariable String userId);
	
	@GetMapping("/myorder/{orderId}")
	public Order getOrderByOrder(@PathVariable Integer orderId);
}
