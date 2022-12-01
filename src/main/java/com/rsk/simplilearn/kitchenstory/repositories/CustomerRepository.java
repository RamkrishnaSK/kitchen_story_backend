package com.rsk.simplilearn.kitchenstory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsk.simplilearn.kitchenstory.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByEmail(String theEmail);
}  
