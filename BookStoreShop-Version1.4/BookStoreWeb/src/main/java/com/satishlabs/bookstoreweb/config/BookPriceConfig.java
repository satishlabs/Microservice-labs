package com.satishlabs.bookstoreweb.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@EnableWebMvc
@SpringBootApplication
public class BookPriceConfig implements WebMvcConfigurer{
	
	/*
	 * @Bean(name = "myOrderExchange") Exchange createOrderExchange() { return
	 * ExchangeBuilder.topicExchange("myorder.exchange").build(); }
	 * 
	 * @Bean(name = "myOrderQueue") Queue createOrderQueue() { return
	 * QueueBuilder.durable("myorder.queue").build(); }
	 * 
	 * @Bean Binding orderBinding(Queue myOrderQueue, TopicExchange myOrderExchange)
	 * { return
	 * BindingBuilder.bind(myOrderExchange).to(myOrderExchange).with("myorder.key");
	 * }
	 */
	
	/*
	 * @Bean(name = "myUserRatingsExchange") Exchange createUserRatingsExchange() {
	 * return ExchangeBuilder.topicExchange("myuser.ratings.exchange").build(); }
	 * 
	 * @Bean(name = "myUserRatingsQueue") Queue createUserRatingsQueue() { return
	 * QueueBuilder.durable("myuser.ratings.queue").build(); }
	 * 
	 * @Bean Binding userRatingBinding(Queue myUserRatingsQueue, TopicExchange
	 * myUserRatingsExchange) { return
	 * BindingBuilder.bind(myUserRatingsQueue).to(myUserRatingsExchange).with(
	 * "myuser.ratings.key"); }
	 */
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/myjsps/"); 
		resolver.setSuffix(".jsp"); 
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) { 
		registry.addResourceHandler("/webjars/**") 
				.addResourceLocations("classpath:/META-INF/resources/webjars/"); 
		//registry.addResourceHandler("/mycss/**")
		//		.addResourceLocations("classpath:/META-INF/resources/mycss/"); 
	}
}
