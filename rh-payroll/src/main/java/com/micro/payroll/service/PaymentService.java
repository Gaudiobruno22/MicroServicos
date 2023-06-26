package com.micro.payroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.payroll.feignclients.WorkerFeignClient;
import com.micro.payroll.model.Payment;
import com.micro.payroll.model.Worker;

@Service
public class PaymentService {

	
	/****** Estou comentando abaixo a Utilização do RestTemplate para Implementar o Feign Client. ******/
	
//	@Value("${rh-worker.host}")
//	private String workerHost;
//	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient feignClient;

//	public Payment getPayment(Long workerId, Integer days) {
//		Map<String, String> variavelCarga = new HashMap<>();
//		variavelCarga.put("id", workerId.toString());
//		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, variavelCarga);
//		
//		return new Payment(worker.getName(), worker.getDailyIncome(), days);
//	}
	
	public Payment getPayment(Long workerId, Integer days) {

		Worker worker = feignClient.findPorId(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
