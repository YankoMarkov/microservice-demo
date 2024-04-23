package com.yanmark.productService.services;


import com.yanmark.productService.dto.ProductRequest;
import com.yanmark.productService.dto.ProductResponse;

import java.util.List;

public interface ProductService {
	
	void createProduct(ProductRequest productRequest);
	
	List<ProductResponse> getAllProducts();
}
