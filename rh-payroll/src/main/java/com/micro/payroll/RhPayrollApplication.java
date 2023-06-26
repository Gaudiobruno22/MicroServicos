package com.micro.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@RibbonClient(name = "rh-worker")
@SpringBootApplication
@EnableFeignClients
public class RhPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhPayrollApplication.class, args);
	}

}
