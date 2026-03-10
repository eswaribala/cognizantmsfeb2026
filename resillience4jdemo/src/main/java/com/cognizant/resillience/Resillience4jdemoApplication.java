package com.cognizant.resillience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Resillience4jdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Resillience4jdemoApplication.class, args);
	}
    //API to API call using RestClient
	//Alternatives to RestClient are WebClient,FeignClient and RestTemplate
	@Bean
	public RestClient restClient() {
		return RestClient.create();
	}
}
