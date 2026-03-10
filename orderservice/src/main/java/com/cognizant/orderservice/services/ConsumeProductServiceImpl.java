package com.cognizant.orderservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cognizant.orderservice.entities.Product;
import com.cognizant.orderservice.repositories.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@KafkaListener(topics = "products", groupId = "product-group")
public class ConsumeProductServiceImpl implements ProductConsumerService {
    @Autowired
	private ProductRepository productRepository;
	@Override
	@KafkaHandler(isDefault = true)
	public void consumeProductDetails(String productDetails) throws JsonMappingException, JsonProcessingException {
		log.info("Received product details: {}", productDetails);	
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		Product product = objectMapper.readValue(productDetails, Product.class);
		productRepository.save(product);
	}

}
