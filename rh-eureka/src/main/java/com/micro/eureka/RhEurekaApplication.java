package com.micro.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RhEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhEurekaApplication.class, args);
	}

}
