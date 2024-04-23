package com.yanmark.orderMicroservice.services;


import com.yanmark.orderMicroservice.dto.OrderRequest;

public interface OrderService {
	
	String createOrder(OrderRequest orderRequest);
}
