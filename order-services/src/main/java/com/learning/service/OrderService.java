package com.learning.service;

import java.util.List;

import com.learning.entity.OrderEntity;
import com.learning.enums.Status;
import com.learning.shared.PaymentEntity;
import com.learning.shared.Product;

public interface OrderService {

	Long create(OrderEntity orderEntity);
	OrderEntity findById(Long id);
	Status updateById(Long id, OrderEntity orderEntity);
	Status deleteById(Long id);
	Product findProductByOrderId(Long orderId);
	PaymentEntity findPaymentByOrderId(Long orderId);
	List<OrderEntity> getAll(OrderEntity orderEntity);
	
}
