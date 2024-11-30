package com.satishlabs.placeorder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.placeorder.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{
	public List<Order> getOrderByUserId(String userId);
}
