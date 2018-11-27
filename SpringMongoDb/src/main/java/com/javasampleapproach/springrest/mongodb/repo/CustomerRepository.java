package com.javasampleapproach.springrest.mongodb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javasampleapproach.springrest.mongodb.model.Customer;
import com.javasampleapproach.springrest.mongodb.model.PubMessage;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	List<Customer> findByAge(int age); 
}
