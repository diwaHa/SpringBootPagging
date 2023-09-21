package com.demo.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.pagination.model.Person;

public interface PersonRespository extends JpaRepository<Person, Integer>{

}
