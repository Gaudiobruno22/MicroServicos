package com.micro.oauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.micro.oauth.feign.UserFeignClient;
import com.micro.oauth.model.User;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserFeignClient feignClient;
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public User findByEmail(String email) {			
		User usuario = feignClient.findByEmail(email).getBody();
		if(usuario == null) {
			throw new IllegalArgumentException("Email not found.");
		}
		logger.info("Returning email " + email);
		return usuario;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usuario = feignClient.findByEmail(username).getBody();
		if(usuario == null) {
			throw new UsernameNotFoundException("Email not found.");
		}
		logger.info("Returning email " + username);
		return usuario;
	}
}
