package com.cognizant.orderservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cognizant.orderservice.entities.Product;

public interface ProductRepository extends MongoRepository<Product, Long> {

}
