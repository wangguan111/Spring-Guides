package com.example.gemfire_rest;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
@EnableEntityDefinedRegions(basePackageClasses = Person.class,
        clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
public class GemfireRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GemfireRestApplication.class, args);
    }
}
