package com.fca.dev.springboot.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.fca.dev.springboot.app.commons.models.entity"})
public class SpringBootProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductServiceApplication.class, args);
	}

}
