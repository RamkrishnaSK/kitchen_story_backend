package com.rsk.simplilearn.kitchenstory.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rsk.simplilearn.kitchenstory.entities.Order;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource 
public interface OrderRepository extends JpaRepository<Order, Integer> {
	public Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);
}
  