package com.yanmark.orderMicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
}
