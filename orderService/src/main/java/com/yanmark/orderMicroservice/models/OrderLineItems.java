package com.yanmark.orderMicroservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_line_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
}
