package com.cognizant.customerservice.dtos;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestCustomerRequest {
	private static CustomerRequest customerRequest;
	private static FullNameRequest fullNameRequest;
	
	@BeforeAll
	public static void getCustomerRequest() {
		customerRequest = new CustomerRequest();
		fullNameRequest = new FullNameRequest();
	}

	@Test
	public void testCustomerRequestNotNull() {
		assertNotNull(customerRequest);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/customerdata.csv", numLinesToSkip = 1)
	public void testCustomerRequestProperties(String firstName, String lastName, String email, long contactNo, String password) {
		fullNameRequest.setFirstName(firstName);
		fullNameRequest.setLastName(lastName);
		customerRequest.setFullNameRequest(fullNameRequest);
		customerRequest.setEmail(email);
		customerRequest.setContactNo(contactNo);
		customerRequest.setPassword(password);
		assertTrue(customerRequest.getFullNameRequest()
				.getFirstName().equals(firstName));	
	}
	
}
