package com.micro.payroll.service;

import org.springframework.stereotype.Service;

import com.micro.payroll.model.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Bruno Gaudio", 200.0, days);
	}
}
