package com.satishlabs.bookstoreweb.config;

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
