package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.shared.PaymentEntity;
import com.learning.shared.Product;

@FeignClient(value = "payment-service", url = "http://localhost:9091/payment")
public interface PaymentClient {

	@GetMapping("/{id}")
	 PaymentEntity getPayment(@PathVariable Long id);
	
}


