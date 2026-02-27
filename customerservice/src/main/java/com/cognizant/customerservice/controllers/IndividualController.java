package com.cognizant.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.customerservice.dtos.GenericMessage;
import com.cognizant.customerservice.dtos.IndividualRequest;
import com.cognizant.customerservice.dtos.IndividualResponse;
import com.cognizant.customerservice.entities.Individual;
import com.cognizant.customerservice.mappers.IndividualMapper;
import com.cognizant.customerservice.services.IndividualService;

@RestController
@RequestMapping("/individuals")
public class IndividualController {
	@Autowired
	private IndividualService individualService;
	@Autowired
	private IndividualMapper individualMapper;
	@PostMapping("/v1.0")
	public ResponseEntity<GenericMessage> createIndividual(@RequestBody IndividualRequest individualRequest) {
		//dto to entity
		Individual individual = individualMapper.toEntity(individualRequest);
		Individual savedIndividual = individualService.addIndividual(individual);
		//entity to dto
		IndividualResponse individualResponse = 
				individualMapper.toRequest(savedIndividual);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new GenericMessage<IndividualResponse>(individualResponse));
	}
	

}
