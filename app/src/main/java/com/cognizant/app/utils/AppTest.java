package com.cognizant.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.cognizant.app.entities.Employee;
import com.cognizant.app.entities.OTPGenerator;
import com.cognizant.app.entities.Person;
import com.github.javafaker.Faker;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Person p1 = Person.getInstance();
		//p1.count(1,2,3,4);
		
		
		  OTPGenerator otp = (min,max) -> { int randomNum = (int)(Math.random() * (max
		  - min + 1) + min); return randomNum; };
		 
		
		System.out.println(otp.generateOTP(1000, 9999));
		
		OTPGenerator ref = OTPGenerator::count;  
		System.out.println(ref.generateOTP(1000, 9999));
		
		
		//Built in functional interfaces
		
		Function<Employee,Boolean> f =
				(e)-> e.getDob().isBefore(LocalDate.now());
		Faker faker=new Faker();		
		Employee emp = new Employee();
		emp.setId(faker.number().randomDigit());
		emp.setName(faker.name().fullName());
		emp.setEmail(faker.internet().emailAddress());
		emp.setDob(faker.date().birthday().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
		
		System.out.println(f.apply(emp));
		
		
		Supplier<Employee> supplier=Employee::new;
		Employee emp1 = supplier.get();
		
		Consumer<Employee> consumer = (e)-> {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getEmail());
			System.out.println(e.getDob());
		};
		
		consumer.accept(emp);
		
		Predicate<Employee> predicate = (e)-> e.getDob().isBefore(LocalDate.now());
		System.out.println(predicate.test(emp));
		
		List<Employee> list = new ArrayList<>();
		
		for(int i=0;i<5;i++) {
			Employee emp2 = new Employee();
			emp2.setId(faker.number().numberBetween(1000, 100000));
			emp2.setName(faker.name().fullName());
			emp2.setEmail(faker.internet().emailAddress());
			emp2.setDob(faker.date().birthday().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
			list.add(emp2);
		}
		list.stream().sorted((x,y)->x.getDob().compareTo(y.getDob())).forEach(System.out::println);
		
		//convert list to map with id as key and name as value
		
		list.stream().collect(Collectors.toMap(Employee::getId, Employee::getName))
		      .forEach((k,v)->System.out.println(k+" "+v));
		
		List<Integer> ids = List.of(1000,2000,3000,4000,5000);
		//sum,average,min,max
	   IntSummaryStatistics intSummaryStatistics=ids.stream().mapToInt(Integer::intValue).summaryStatistics();
	   
		System.out.println("Sum: "+intSummaryStatistics.getSum());
		System.out.println("Average: "+intSummaryStatistics.getAverage());
		System.out.println("Min: "+intSummaryStatistics.getMin());
		System.out.println("Max: "+intSummaryStatistics.getMax());
		
		ids.stream().mapToInt(Integer::intValue).sum();
		
		
	}

}
