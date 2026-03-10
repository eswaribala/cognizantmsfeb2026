package com.cognizant.orderservice.entities;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
	@BsonId
	private long productId;
	private String productName;	
	private String description;    
	private double price;
	private LocalDate purchaseDate;
	private LocalDate expiryDate;
	private Catalog catalog;
	
}
