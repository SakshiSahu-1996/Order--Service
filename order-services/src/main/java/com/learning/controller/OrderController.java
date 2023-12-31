package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.client.ProductClient;
import com.learning.entity.OrderEntity;
import com.learning.enums.Status;
import com.learning.service.OrderService;
import com.learning.shared.PaymentEntity;
import com.learning.shared.Product;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductClient productClient;

	@PostMapping
	public Long createOrder(@RequestBody OrderEntity orderEntity) {
		return orderService.create(orderEntity);
	}

	@GetMapping("/{id}")
	public OrderEntity findById(@PathVariable Long id) {
		return orderService.findById(id);
	}
	
	@GetMapping
	public List<OrderEntity> getAll(@PathVariable OrderEntity orderEntity){
		return orderService.getAll(orderEntity);
		
	}

	@PutMapping("/{id}")
	public Status updateById(@PathVariable Long id,@RequestBody OrderEntity orderEntity) {
		return orderService.updateById(id, orderEntity);
	}

	@DeleteMapping("/{id}")
	public Status deleteById(@PathVariable Long id) {
		return orderService.deleteById(id);
	}

	@GetMapping("/products/{orderId}")
	public Product findProductByOrderId(@PathVariable Long orderId) {
		//OrderEntity orderEntity= orderService.findProductByOrderId(orderId);
		return orderService.findProductByOrderId(orderId);
	}
	
	@GetMapping("/payments/{orderId}")
	public PaymentEntity findPaymentByOrderId(@PathVariable Long orderId) {
		//OrderEntity orderEntity= orderService.findProductByOrderId(orderId);
		return orderService.findPaymentByOrderId(orderId);
	}

}
