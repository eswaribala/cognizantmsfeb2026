package com.cognizant.resillience.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.resillience.dtos.GenericResponse;
import com.cognizant.resillience.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CBController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/products/v1.0", produces = "application/json")
	public ResponseEntity<String> getProducts()throws JsonProcessingException {
		
			String data = productService.getProducts();
			return ResponseEntity.status(HttpStatus.OK)
					.body(data);	
		
	}

}
