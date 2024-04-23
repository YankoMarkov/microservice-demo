package com.yanmark.orderMicroservice.repositories;

import com.yanmark.orderMicroservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
