package com.cognizant.gatewayrouting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayroutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayroutingApplication.class, args);
	}

}
