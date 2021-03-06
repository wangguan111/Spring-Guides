package com.example.yam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.yarn.client.YarnClient;

@EnableAutoConfiguration
public class ClientApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args)
			.getBean(YarnClient.class)
                .submitApplication();
        LOGGER.warn("This is ClientApplication run...");
	}

}
