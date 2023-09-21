package com.demo.pagination.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pagination.model.Person;
import com.demo.pagination.repository.PersonRespository;

@RestController
@RequestMapping("api/people")
public class PersonController {

	private final PersonRespository personRespository;
	
	public PersonController(PersonRespository respository) {
		
		this.personRespository=respository;
	}
	
	@GetMapping
	public Page<Person> findAll(@RequestParam int page , @RequestParam int size){
		PageRequest pr = PageRequest.of(page, size);
		return personRespository.findAll(pr);
		
		
	}
}
