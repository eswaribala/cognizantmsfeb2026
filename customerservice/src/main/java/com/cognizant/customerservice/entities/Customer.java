package com.cognizant.customerservice.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	private long accountNo;
	@Embedded
	private FullName fullName;
	private long contactNo;
	private String email;
	private String password;
	


}
