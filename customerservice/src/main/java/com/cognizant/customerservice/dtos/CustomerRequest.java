package com.cognizant.customerservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
	
	private FullNameRequest fullNameRequest;
	private String email;
	private long contactNo;
	private String password;
	

}
