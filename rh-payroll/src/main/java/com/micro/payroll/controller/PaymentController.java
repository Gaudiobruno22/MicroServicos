package com.micro.payroll.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.payroll.model.DefaultError;
import com.micro.payroll.model.Payment;
import com.micro.payroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	
	@HystrixCommand(fallbackMethod = "throwErrorRequest")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayments(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> throwErrorRequest(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = new Payment("Error Name", 100.00, days);
		return ResponseEntity.ok(payment);
	}
}
