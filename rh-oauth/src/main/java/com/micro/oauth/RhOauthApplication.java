package com.micro.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableAuthorizationServer
public class RhOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhOauthApplication.class, args);
	}

}
