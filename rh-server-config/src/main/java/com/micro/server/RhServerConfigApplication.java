package com.micro.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class RhServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhServerConfigApplication.class, args);
	}

}
