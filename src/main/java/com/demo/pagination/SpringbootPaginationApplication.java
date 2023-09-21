package com.demo.pagination;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;


@SpringBootApplication
public class SpringbootPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPaginationApplication.class, args);}

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args ->{
//			System.out.println("Command Line Runner");
//		};
//	}
	
	@Bean
	Faker faker() {
		return new Faker();
	}
}