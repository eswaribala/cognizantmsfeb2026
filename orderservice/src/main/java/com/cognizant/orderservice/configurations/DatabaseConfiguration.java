package com.cognizant.orderservice.configurations;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)
public class DatabaseConfiguration {
	private final VaultConfiguration vaultConfiguration;
	
	public DatabaseConfiguration(VaultConfiguration vaultConfiguration) {
		this.vaultConfiguration = vaultConfiguration;
	}
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create(vaultConfiguration.getUri());
	}
	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "productdb");
	}
	

}
