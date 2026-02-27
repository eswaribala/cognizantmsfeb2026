package com.cognizant.customerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.customerservice.dtos.GenericMessage;
import com.cognizant.customerservice.dtos.IndividualRequest;
import com.cognizant.customerservice.services.IndividualService;

@RestController
@RequestMapping("/individuals")
public class IndividualController {
	@Autowired
	private IndividualService individualService;
	
	public ResponseEntity<GenericMessage> addIndividual(@RequestBody IndividualRequest individualRequest) {
		//automapper
		
	}

}
