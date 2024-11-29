package com.satishlabs.placeorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlaceOrderMsApplication implements CommandLineRunner{
	static Logger logInfo = LoggerFactory.getLogger(PlaceOrderMsApplication.class);

	public static void main(String[] args) {
		logInfo.info("-----PlaceOrderMsApplication --- begin ----");
		SpringApplication.run(PlaceOrderMsApplication.class, args);
		logInfo.info("-----PlaceOrderMsApplication --- end ----");
	}

	@Override
	public void run(String... args) throws Exception {
		logInfo.info("-----PlaceOrderMsApplication --- Launched ----");
		// TODO Auto-generated method stub
		
	}

}
