package com.cognizant.orderservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProductConsumerService {
	
	void consumeProductDetails(String productDetails) throws JsonProcessingException;

}
