package com.yanmark.productService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yanmark.productService.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
