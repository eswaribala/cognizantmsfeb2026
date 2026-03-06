package com.cognizant.app.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Person {
	protected int id;
	protected String name;
	protected String email;
	protected LocalDate dob;
	static int count;
	/*
	 * //constructor overloading private Person() { count++;
	 * 
	 * } //singleton design pattern
	 * 
	 * public static Person getInstance() { if(count>1) { throw new
	 * RuntimeException("Only one instance allowed"); } return new Person(); }
	 */
	
	public int count(int data,int... args) {
		return args.length;
	}
	
	public abstract void compute();
}
