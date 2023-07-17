package com.micro.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.user.model.User;
import com.micro.user.repository.UserRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserController {
		
	@Autowired
	private UserRepository repository; 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findPorId(@PathVariable Long id){
		
		User user = repository.findById(id).get();
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		
		User user = repository.findByEmail(email);
		return ResponseEntity.ok(user);
	}
 }	
