package com.yanmark.orderMicroservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private String orderNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItems> orderLineItems;
}

