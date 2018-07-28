package com.example.yam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class AppmasterApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppmasterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppmasterApplication.class, args);

        LOGGER.warn("This is AppmasterApplication run...");
	}

}
