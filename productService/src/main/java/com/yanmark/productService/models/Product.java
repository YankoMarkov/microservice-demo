package com.yanmark.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private String name;
	private String description;
	private BigDecimal price;
}

