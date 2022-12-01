package com.rsk.simplilearn.kitchenstory.services;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsk.simplilearn.kitchenstory.dto.Purchase;
import com.rsk.simplilearn.kitchenstory.dto.PurchaseResponse;
import com.rsk.simplilearn.kitchenstory.entities.Customer;
import com.rsk.simplilearn.kitchenstory.entities.Order;
import com.rsk.simplilearn.kitchenstory.entities.OrderItem;
import com.rsk.simplilearn.kitchenstory.repositories.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {

		// Retrieve the order info from dto
		Order order = purchase.getOrder();

		// Generate Tracking Number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);

		// Populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));

		// Populate order with shippingAddress and billingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());

		// Populate customer with order
		Customer customer = purchase.getCustomer();

		// check if this is an existing customer
		String theEmail = customer.getEmail();
		Customer customerFromDB = this.customerRepository.findByEmail(theEmail);
		if (customerFromDB != null) {
			customer = customerFromDB;
		}

		customer.add(order); 

		// Save to the Database
		this.customerRepository.save(customer);

		// Return a Response
		return new PurchaseResponse(orderTrackingNumber);
	}

	// Generate a Random UUID Number
	private String generateOrderTrackingNumber() {
		return UUID.randomUUID().toString();
	}

}
