package com.cognizant.customerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.customerservice.dtos.GenericMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<GenericMessage<String>> handleCustomerNotFoundException
	(CustomerNotFoundException ex) {
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new GenericMessage<>(ex.getMessage()));
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<GenericMessage<String>> handleRuntimeException
	(RuntimeException ex) {
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new GenericMessage<>(ex.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericMessage<String>> handleException
	(Exception ex) {
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new GenericMessage<>(ex.getMessage()));
	}
	
}
