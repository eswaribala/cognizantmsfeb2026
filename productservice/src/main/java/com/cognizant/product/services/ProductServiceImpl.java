package com.cognizant.product.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.product.dtos.ProductCatalogResponse;
import com.cognizant.product.entities.Product;
import com.cognizant.product.exceptions.CatalogNotFoundException;
import com.cognizant.product.exceptions.ProductNotFoundException;
import com.cognizant.product.repositories.CatalogRepository;
import com.cognizant.product.repositories.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CatalogRepository catalogRepository;

	@Override
	public Product addProduct(long catalogId, Product product) throws CatalogNotFoundException {
		// TODO Auto-generated method stub
		if(catalogRepository.existsById(catalogId)) {
			product.setCatalog(catalogRepository.findById(catalogId).get());
			return productRepository.save(product);
		}else {
			throw new CatalogNotFoundException("Catalog with id " + catalogId + " not found.");
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found."));
	}

	@Override
	public Product updateProduct(long productId, long price) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found."));
		product.setPrice(price);
		return productRepository.save(product);
	}

	@Override
	public boolean deleteProduct(long productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		if(productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
	  			return true;
		}else {
			throw new ProductNotFoundException("Product with id " + productId + " not found.");
		}
	}

	@Override
	public List<ProductCatalogResponse> getProductsAndCatalogs() {
		// TODO Auto-generated method stub
		List<Object[]> objects=productRepository.findProductAndCatalog();
		return objects.stream()
				.map(obj -> new ProductCatalogResponse((String) obj[0], (String) obj[1]))
				.toList();
	}

}
