package com.yanmark.productService.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.yanmark.productService.dto.ProductRequest;
import com.yanmark.productService.dto.ProductResponse;
import com.yanmark.productService.models.Product;
import com.yanmark.productService.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public void createProduct(ProductRequest productRequest) {
		Product product = modelMapper.map(productRequest, Product.class);
		
		try {
			productRepository.save(product);
			log.info("Product {} is saved", product.getId());
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	@Override
	public List<ProductResponse> getAllProducts() {
		List<Product> products = productRepository.findAll();
		
		return products.stream()
				.map(product -> modelMapper.map(product, ProductResponse.class))
				.toList();
	}
}
