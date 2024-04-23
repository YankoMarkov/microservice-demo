package com.yanmark.inventoryMicroservice;

import com.yanmark.inventoryMicroservice.models.Inventory;
import com.yanmark.inventoryMicroservice.repositories.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceInventoryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceInventoryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("samsung_s24");
			inventory.setQuantity(10);
			
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("samsung_a54");
			inventory1.setQuantity(10);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
	
}
