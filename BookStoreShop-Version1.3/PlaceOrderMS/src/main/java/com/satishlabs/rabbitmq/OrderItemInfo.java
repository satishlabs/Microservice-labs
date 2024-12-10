package com.satishlabs.rabbitmq;

import java.io.Serializable;

public class OrderItemInfo implements Serializable{
	private Integer orderItemId;
	private Integer orderId;
	private Integer bookId;
	private int qty;
	private double cost;
	
	public OrderItemInfo() {}
	
	public OrderItemInfo(Integer orderId, Integer bookId, int qty, double cost) {
		this.orderId = orderId;
		this.bookId = bookId;
		this.qty = qty;
		this.cost = cost;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

}
