package com.yanmark.orderMicroservice.services;

import com.yanmark.orderMicroservice.dto.InventoryResponse;
import com.yanmark.orderMicroservice.dto.OrderRequest;
import com.yanmark.orderMicroservice.models.Order;
import com.yanmark.orderMicroservice.models.OrderLineItems;
import com.yanmark.orderMicroservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	private final ModelMapper modelMapper;
	private final WebClient.Builder webClientBuilder;
	
	@Override
	public String createOrder(OrderRequest orderRequest) {
		Order order = modelMapper.map(orderRequest, Order.class);
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtos().stream()
				.map(orderLineItemsDto -> modelMapper.map(orderLineItemsDto, OrderLineItems.class))
				.toList();
		
		order.setOrderLineItems(orderLineItems);
		
		List<String> skuCodes = order.getOrderLineItems().stream()
				.map(OrderLineItems::getSkuCode)
				.toList();
		
		// Call Inventory Service and place order if product is in stock
		InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
				.uri("http://inventory-service/api/inventory",
						uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();
		
		boolean allProductInStock = inventoryResponseArray != null && Arrays.stream(inventoryResponseArray)
				.allMatch(InventoryResponse::isInStock);
		
		if (allProductInStock) {
			try {
				orderRepository.save(order);
				return "Order Placed Successfully";
			} catch (Exception e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		} else {
			throw new IllegalArgumentException("Product is not in stock");
		}
	}
}
