package com.example.routingfiltering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class RoutingFilteringApplication {

  @Bean
  public SimpleFilter simpleFilter() {
    return new SimpleFilter();
  }

    public static void main(String[] args) {
        SpringApplication.run(RoutingFilteringApplication.class, args);
    }
}
