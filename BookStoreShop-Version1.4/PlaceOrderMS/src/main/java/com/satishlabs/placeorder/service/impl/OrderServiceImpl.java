/**
 * 
 */
package com.satishlabs.placeorder.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.satishlabs.placeorder.config.PlaceOrderConfig;
import com.satishlabs.placeorder.dao.BookInventoryDAO;
import com.satishlabs.placeorder.dao.OrderDAO;
import com.satishlabs.placeorder.dao.OrderItemDAO;
import com.satishlabs.placeorder.entity.BookInventory;
import com.satishlabs.placeorder.entity.Order;
import com.satishlabs.placeorder.entity.OrderItem;
import com.satishlabs.placeorder.service.OrderService;
import com.satishlabs.rabbitmq.BookInventoryInfo;
import com.satishlabs.rabbitmq.OrderFullInfo;
import com.satishlabs.rabbitmq.OrderInfo;
import com.satishlabs.rabbitmq.OrderItemInfo;
import com.satishlabs.rabbitmq.OrderInfo;

/**
 * @author Satish

 * Jul 18, 2022
 */

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	static Logger logInfo = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private OrderItemDAO orderItemDAO;

	@Autowired
	private BookInventoryDAO bookInventoryDAO;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RabbitListener(queues = "myorder.queue")
	public void placeOrder(OrderFullInfo orderFullInfo) {
		logInfo.info("--- 3. OrderServiceImpl --- placeOrder() ----");

		//Task1 - Insert records -1
		OrderInfo orderInfo = orderFullInfo.getOrder();
		Order myorder = new Order(orderInfo.getOrderDate(), orderInfo.getUserId(), orderInfo.getTotalQty(), orderInfo.getTotalCost(), orderInfo.getStatus());
		
		myorder = orderDAO.save(myorder);
		int orderId = myorder.getOrderId();

		//Task2 - Insert orderItems
		List<OrderItemInfo> itemsListInfo = orderFullInfo.getItemsList();
		for(OrderItemInfo orderItemInfo : itemsListInfo) {
			OrderItem myOrderItem = new OrderItem(orderId, orderItemInfo.getBookId(), orderItemInfo.getQty(), orderItemInfo.getCost());
			orderItemDAO.save(myOrderItem);
		}

		//Task3 - Update Local BookInventory
		//Task4 - Update BookSearch BookInventory

		for(OrderItemInfo orderItemInfo: itemsListInfo) {
			Integer bookId = orderItemInfo.getBookId();
			BookInventory bookInventory = bookInventoryDAO.findById(bookId).get();
			Integer currentStock = bookInventory.getBooksAvailable();
			currentStock = currentStock - orderItemInfo.getQty();
			bookInventory.setBooksAvailable(currentStock);

			//Local Inventory
			bookInventoryDAO.save(bookInventory);

			//Update Inventory of BookSearchMS by sending Message
			BookInventoryInfo bookInventoryInfo = new BookInventoryInfo();
			bookInventoryInfo.setBookId(bookInventory.getBookId());
			bookInventoryInfo.setBooksAvailable(bookInventory.getBooksAvailable());
			rabbitTemplate.convertAndSend("mybook.search.exchange","myinventory.key", bookInventoryInfo);
		}

	}

	@Override
	public List<Order> getOrdersByUserId(String userId) {
		logInfo.info("--- OrderServiceImpl --- placeOrder() ----");
		List<Order> orderList = orderDAO.getOrderByUserId(userId);
		return orderList;
	}

	@Override
	public Order getOrderByOrderId(Integer orderId) {
		Order myorder = orderDAO.findById(orderId).get();
		return myorder;
	}



}
