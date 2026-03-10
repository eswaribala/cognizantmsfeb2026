package com.cognizant.resillience.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.cognizant.resillience.dtos.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	private RestClient restClient;
	@Value("${serviceUrl}")
	private String serviceUrl;
	@Value("${alternativeServiceUrl}")
	private String alternativeUrl;
	@Value("${gatewayUrl}")
	private String tokenUrl;

	@Override
	@CircuitBreaker(name="gatewayCircuitBreaker",fallbackMethod = "getProductsFallback")
	@Retry(name="gatewayRetry")
	@RateLimiter(name="gatewayRateLimiter")
	public String  getProducts() throws JsonProcessingException {
		log.info("Calling getProducts method in ProductServiceImpl");
		// TODO Auto-generated method stub
		//Get the token from the gateway		
		String token =restClient.get().uri(tokenUrl)
		.retrieve().body(String.class);		
		log.info("Received token: " + token);
		//Set the token in the header and call the service		
		 String products = restClient.get().uri(serviceUrl)
				.headers(header -> header.setBearerAuth(token))
				.retrieve()
				.body(String.class);	
		 log.info("Received products: " + products);
		return products;
		 }
	
	public String getProductsFallback(Exception e) throws JsonProcessingException {		
		log.info("Fallback method called due to: " + e.getMessage());
		// Return an empty list or a default response
		String fallbackResponse = restClient.get().uri(alternativeUrl)
				.retrieve()
				.body(new ParameterizedTypeReference<String>() {});
		return fallbackResponse;
	}
}
