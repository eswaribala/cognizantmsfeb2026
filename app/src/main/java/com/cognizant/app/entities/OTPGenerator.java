package com.cognizant.app.entities;
import java.util.Random;
@FunctionalInterface
public interface OTPGenerator {
	
	int generateOTP(int min, int max);
	boolean equals(Object obj);
	
	static int count(int min, int max) {
	    return new Random().nextInt((max - min) + 1) + min;
	}
}
