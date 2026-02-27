package com.cognizant.customerservice.dtos;

import java.time.LocalDate;

import com.cognizant.customerservice.entities.Gender;

public record IndividualResponse(FullNameResponse fullName, String email, 
		long contactNo,Gender gender,LocalDate dateOfBirth) {

}
