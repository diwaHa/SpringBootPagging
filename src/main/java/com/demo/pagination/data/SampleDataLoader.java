package com.demo.pagination.data;


import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.pagination.model.Address;
import com.demo.pagination.model.Person;
import com.demo.pagination.repository.PersonRespository;
import com.github.javafaker.Faker;




@Component
public class SampleDataLoader implements CommandLineRunner{

	private Logger logger =LoggerFactory.getLogger(SampleDataLoader.class);
	
	private final PersonRespository personRespository;
	
	private final Faker faker;
	
	public SampleDataLoader(PersonRespository respository, Faker faker) {
		this.personRespository = respository;
		this.faker = new Faker();
	}
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("Loading Sample Data....");
		
		// create 100 row of people in database
		
		List<Person> persons =IntStream.rangeClosed(1, 100)
		.mapToObj(i -> new Person(
				faker.name().firstName(),
				faker.name().lastName(),
				faker.phoneNumber().cellPhone(),
				faker.internet().emailAddress(),
				new Address(
						faker.address().streetAddress(),
						faker.address().city(),
						faker.address().state(),
						faker.address().zipCode()
						)
				
				))
		.toList();
		
		personRespository.saveAll(persons);
		
//		Person person = new Person("diwa", "har", 236541789, "diwahar@gmail.com", 
//				new Address("Street", "City", "State", "ZIP"));
//		personRespository.save(person);
		
	}

}
