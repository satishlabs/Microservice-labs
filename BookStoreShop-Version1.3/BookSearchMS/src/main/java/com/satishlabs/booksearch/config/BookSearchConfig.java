package com.satishlabs.booksearch.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookSearchConfig {
	
	//BookSearch Exchange
	@Bean(name = "myBookSearchExchange")
	Exchange createBookSearchExchange() {
		return ExchangeBuilder.topicExchange("mybook.search.exchange").build();
	}

	@Bean(name = "myBookRatingsQueue")
	Queue createBookRatingsQueue() {
		return QueueBuilder.durable("mybook.ratings.queue").build();
	}

	@Bean
	Binding bookRatingBinding(Queue myBookRatingsQueue, TopicExchange myBookSearchExchange) {
		return BindingBuilder.bind(myBookRatingsQueue).to(myBookSearchExchange).with("mybook.ratings.key");
	}
	

	@Bean(name = "myInventoryQueue")
	Queue createInventoryQueue() {
		return QueueBuilder.durable("myinventory.queue").build();
	}

	@Bean
	Binding InventoryBinding(Queue myInventoryQueue, TopicExchange myBookSearchExchange) {
		return BindingBuilder.bind(myInventoryQueue).to(myBookSearchExchange).with("myinventory.key");
	}
}
