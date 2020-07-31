package com.fca.dev.springboot.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductServiceApplication.class, args);
	}

}
