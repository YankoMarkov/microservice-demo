package com.yanmark.inventoryMicroservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "inventories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private String skuCode;
	private Integer quantity;
}

