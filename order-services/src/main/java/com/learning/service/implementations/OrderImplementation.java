package com.learning.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.client.PaymentClient;
import com.learning.client.ProductClient;
import com.learning.entity.OrderEntity;
import com.learning.enums.Status;
import com.learning.repostiory.OrderRepository;
import com.learning.service.OrderService;
import com.learning.shared.PaymentEntity;
import com.learning.shared.Product;

@Service
public class OrderImplementation implements OrderService {

	@Autowired 
	private OrderRepository orderRepository;

	@Autowired
	private ProductClient productClient;
	
	@Autowired
	private PaymentClient paymentClient;

	@Override
	public Long create(OrderEntity orderEntity) {
		OrderEntity entity = orderRepository.save(orderEntity);
		return entity.getId();
	}

	@Override
	public OrderEntity findById(Long id) {
		Optional<OrderEntity> orderEntity = orderRepository.findById(id);
		boolean present = orderEntity.isPresent();
		if (present) {
			OrderEntity getOrder = orderEntity.get();
			return getOrder;
		} else {
			return null;
		}
	}

	@Override
	public Status updateById(Long id, OrderEntity orderEntity) {
		try {
			OrderEntity savedOrder = findById(id);
			if (savedOrder != null) {
				savedOrder.setName(orderEntity.getName());
				savedOrder.setDate(orderEntity.getDate());
				orderRepository.save(savedOrder);
				return Status.SUCCESS;
			}
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return Status.FAIL;
	}

	@Override
	public Status deleteById(Long id) {
		orderRepository.deleteById(id);
		return Status.SUCCESS;
	}

	@Override
	public Product findProductByOrderId(Long orderId) {
		try {
			Optional<OrderEntity> entity = orderRepository.findById(orderId);
			
			OrderEntity getOrder = entity.get();
			Product product = productClient.getProduct(getOrder.getProductId());
			return product;
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return null;
	}

	@Override
	public List<OrderEntity> getAll(OrderEntity orderEntity) {
		return orderRepository.findAll();
	}

	@Override
	public PaymentEntity findPaymentByOrderId(Long orderId) {
		try {
			Optional<OrderEntity> orderEntity= orderRepository.findById(orderId);
			OrderEntity getOrders = orderEntity.get();
			System.err.println(getOrders);
			PaymentEntity payment =paymentClient.getPayment(getOrders.getPaymentId());
					return payment;
		}catch (Exception exception) {
			System.out.println(exception);
			
		}

		return null;
	}
}
