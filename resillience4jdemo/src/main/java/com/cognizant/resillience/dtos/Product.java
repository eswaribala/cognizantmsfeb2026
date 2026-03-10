package com.cognizant.resillience.dtos;
//immutability is a design principle that ensures that once an object is created, its state cannot be modified.
public record Product(long productId, String productName, 
		String description, double price, String purchaseDate, String expiryDate,Catalog catalog) {

}
