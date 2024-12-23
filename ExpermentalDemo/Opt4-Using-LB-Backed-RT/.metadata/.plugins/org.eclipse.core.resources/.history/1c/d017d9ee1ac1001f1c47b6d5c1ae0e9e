package com.satishlabs.booksearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BookSearchApplication implements CommandLineRunner{
	static Logger logInfo = LoggerFactory.getLogger(BookSearchApplication.class);
	

	public static void main(String[] args) {
		logInfo.info("--- BookSearchApplication -- begin----");
		SpringApplication.run(BookSearchApplication.class, args);
		logInfo.info("--- BookSearchApplication -- end----");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logInfo.info("--- BookSearchApplication -- Launched----");
	}

}
