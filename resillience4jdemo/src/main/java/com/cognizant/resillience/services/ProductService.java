package com.cognizant.resillience.services;

import java.util.List;

import com.cognizant.resillience.dtos.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProductService {
	
	String getProducts() throws JsonProcessingException ;

}
