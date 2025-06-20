package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class EurekaClientDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientDemo1Application.class, args);
		System.out.println("Eureka Client is running..");
	}

}
