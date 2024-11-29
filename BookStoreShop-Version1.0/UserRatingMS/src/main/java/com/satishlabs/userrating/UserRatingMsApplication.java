package com.satishlabs.userrating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserRatingMsApplication implements CommandLineRunner{
	static Logger logInfo = LoggerFactory.getLogger(UserRatingMsApplication.class);
	
	public static void main(String[] args) {
		logInfo.info("----UserRatingMsApplication --- begin----");
		SpringApplication.run(UserRatingMsApplication.class, args);
		logInfo.info("----UserRatingMsApplication --- end----");
	}

	@Override
	public void run(String... args) throws Exception {
		logInfo.info("----UserRatingMsApplication --- Launched----");
		// TODO Auto-generated method stub
		
	}

}
