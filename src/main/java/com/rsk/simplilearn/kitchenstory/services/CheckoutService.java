package com.rsk.simplilearn.kitchenstory.services;

import com.rsk.simplilearn.kitchenstory.dto.Purchase;
import com.rsk.simplilearn.kitchenstory.dto.PurchaseResponse;

public interface CheckoutService {
	public PurchaseResponse placeOrder(Purchase purchase);
}
