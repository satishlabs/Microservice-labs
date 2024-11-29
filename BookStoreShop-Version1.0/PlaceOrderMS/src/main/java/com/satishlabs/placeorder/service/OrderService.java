/**
 * 
 */
package com.satishlabs.placeorder.service;

import java.util.List;

import com.satishlabs.placeorder.dto.OrderInfo;
import com.satishlabs.placeorder.entity.Order;

/**
 * @author Satish

 * Jul 18, 2022
 */
public interface OrderService {
	public void placeOrder(OrderInfo orderInfo);
	public List<Order> getOrdersByUserId(String userId);
	public Order getOrderByOrderId(Integer orderId);
	
}
