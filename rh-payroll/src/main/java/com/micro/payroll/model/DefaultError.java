package com.micro.payroll.model;

import java.io.Serializable;
import java.time.LocalDate;

public class DefaultError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private LocalDate timestamp;
	private String message;
	
	
	public DefaultError() {
		
	}
	
	public DefaultError(LocalDate timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}

	
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
