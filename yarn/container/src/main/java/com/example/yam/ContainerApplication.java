package com.example.yam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class ContainerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ContainerApplication.class, args);

        LOGGER.warn("This is ContainerApplication run...");
	}

}
