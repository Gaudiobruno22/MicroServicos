package com.micro.worker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.worker.model.Worker;
import com.micro.worker.repository.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerController.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository; 

	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfig(){
		logger.info("CONFIG " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findPorId(@PathVariable Long id){
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("PORTA = " + env.getProperty("local.server.port"));
		Worker worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
