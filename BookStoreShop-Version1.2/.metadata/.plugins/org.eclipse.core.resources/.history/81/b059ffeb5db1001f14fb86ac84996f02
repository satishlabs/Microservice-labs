/**
 * 
 */
package com.satishlabs.userrating.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Satish
 * 
 *         Jul 18, 2022
 */

@SpringBootApplication
public class UserRatingConfig {
	@Bean(name = "myBookRatingsExchange")
	Exchange createBookRatingsExchange() {
		return ExchangeBuilder.topicExchange("mybook.ratings.exchange").build();
	}

	@Bean(name = "myBookRatingsQueue")
	Queue createBookRatingsQueue() {
		return QueueBuilder.durable("mybook.ratings.queue").build();
	}

	@Bean
	Binding bookRatingBinding(Queue myBookRatingsQueue, TopicExchange myBookRatingsExchange) {
		return BindingBuilder.bind(myBookRatingsQueue).to(myBookRatingsExchange).with("mybook.ratings.key");
	}

	@Bean(name = "myUserRatingsExchange")
	Exchange createUserRatingsExchange() {
		return ExchangeBuilder.topicExchange("myuser.ratings.exchange").build();
	}

	@Bean(name = "myUserRatingsQueue")
	Queue createUserRatingsQueue() {
		return QueueBuilder.durable("myuser.ratings.queue").build();
	}

	@Bean
	Binding userRatingBinding(Queue myUserRatingsQueue, TopicExchange myUserRatingsExchange) {
		return BindingBuilder.bind(myUserRatingsQueue).to(myUserRatingsExchange).with("myuser.ratings.key");
	}
}
