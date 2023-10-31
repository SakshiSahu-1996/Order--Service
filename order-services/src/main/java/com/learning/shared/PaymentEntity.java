package com.learning.shared;

import java.time.LocalDate;

public class PaymentEntity {

	private Long id;
	private String name;
	private LocalDate date;
	private Double totalPrice;
	private Long orderId;
	
	public PaymentEntity() {
		
	}

	public PaymentEntity(Long id, String name, LocalDate date, Double totalPrice, Long orderId) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", name=" + name + ", date=" + date + ", totalPrice=" + totalPrice
				+ ", productId=" + orderId  + "]";
	}
}
