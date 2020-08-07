package com.example.springfirstapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
@SpringBootApplication
public class SpringFirstApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringFirstApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("I m in Main Class");
        SpringApplication.run(SpringFirstApplication.class, args);
    }
}
