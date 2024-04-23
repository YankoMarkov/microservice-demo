package com.yanmark.inventoryMicroservice.services;


import com.yanmark.inventoryMicroservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
	
	List<InventoryResponse> isInStock(List<String> skuCode);
}
