package com.cognizant.product.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.product.dtos.CatalogResponse;
import com.cognizant.product.entities.Catalog;
import com.cognizant.product.mappers.CatalogMapper;
import com.cognizant.product.services.CatalogService;
import com.github.javafaker.Faker;
import org.mockito.Mockito;
@WebMvcTest(CatalogController.class)
public class CatalogControllerTest {
	@MockitoBean
	private CatalogService catalogService;
	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private CatalogMapper catalogMapper;
	@Test
	public void getAllCatalogsTest() throws Exception {
		List<Catalog> catalogList = getCatalogList();
		List<CatalogResponse> catalogResponseList = new ArrayList<>();
		for(int i=0;i<catalogList.size();i++) {			
			catalogResponseList.add(Mockito.mock(CatalogResponse.class));	
		
		}		
		Mockito.when(catalogService.getAllCatalogs()).thenReturn(catalogList);
		Mockito.when(catalogMapper.toCatalogResponseList(catalogList))
		        .thenReturn(catalogResponseList);
		//endpoint testing -- ABC --Address,Binding and Contract testing
		mockMvc.perform(get("/catalogs/v1.0")
	            .with(jwt().authorities(() -> "SCOPE_sre")))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.length()").value(10))
	        .andDo(print());	      
	
		       
	}
	
	
	 private List<Catalog> getCatalogList() {
	    	List<Catalog> catalogList = new ArrayList<>();
	    	Faker faker = new Faker();
	    	for(int i=0;i<10;i++) {
				Catalog catalog = new Catalog();
				catalog.setCatalogId(faker.number().numberBetween(1, 100));
				catalog.setCatalogName(faker.commerce().productName());
				catalogList.add(catalog);		}
			return catalogList;		    	
	    }
	

}
