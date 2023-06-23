package com.micro.payroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.payroll.model.Payment;
import com.micro.payroll.model.Worker;

@Service
public class PaymentService {
	
	@Value("${rh-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(Long workerId, Integer days) {
		Map<String, String> variavelCarga = new HashMap<>();
		variavelCarga.put("id", workerId.toString());
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, variavelCarga);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
