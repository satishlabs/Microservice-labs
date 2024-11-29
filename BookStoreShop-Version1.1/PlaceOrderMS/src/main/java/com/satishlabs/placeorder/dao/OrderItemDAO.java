package com.satishlabs.placeorder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.placeorder.entity.OrderItem;

public interface OrderItemDAO extends JpaRepository<OrderItem, Integer>{
	public List<OrderItem> getOrderItemsByOrderId(Integer orderId);
}
