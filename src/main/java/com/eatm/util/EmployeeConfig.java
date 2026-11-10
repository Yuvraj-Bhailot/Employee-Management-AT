package com.eatm.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.eatm.entity.Attendance;

@Configuration
@ComponentScan(basePackages = "com.eatm")
public class EmployeeConfig {

	@Bean
	public EntityManager entityManager() {
		return Persistence.createEntityManagerFactory("dbInfo").createEntityManager();
	}
	
	@Bean
	EntityTransaction entityTransaction() {
		return entityManager().getTransaction();
	}
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	@Scope(value = "prototype")
	Attendance attendance() {
		return new Attendance();
	}
}
