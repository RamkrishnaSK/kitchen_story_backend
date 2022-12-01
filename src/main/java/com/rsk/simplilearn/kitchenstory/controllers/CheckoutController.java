package com.rsk.simplilearn.kitchenstory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsk.simplilearn.kitchenstory.dto.Purchase;
import com.rsk.simplilearn.kitchenstory.dto.PurchaseResponse;
import com.rsk.simplilearn.kitchenstory.services.CheckoutService;

@CrossOrigin("http://localhost:4200")  
@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;  

	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		PurchaseResponse response = this.checkoutService.placeOrder(purchase);
		return response;
	}

}
