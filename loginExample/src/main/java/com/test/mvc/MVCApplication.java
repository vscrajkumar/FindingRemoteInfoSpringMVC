package com.test.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MVCApplication {
	private static Logger LOG = LoggerFactory.getLogger(MVCApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MVCApplication.class, args);
	}
	
}
