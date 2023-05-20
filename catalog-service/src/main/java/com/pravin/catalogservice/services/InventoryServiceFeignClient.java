package com.pravin.catalogservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.pravin.catalogservice.web.models.ProductInventoryResponse;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryServiceFeignClient {

    @GetMapping("/api/inventory")
    List<ProductInventoryResponse> getInventoryLevels();

    @GetMapping("/api/inventory/{productCode}")
    List<ProductInventoryResponse> getInventoryByProductCode(String productCode);

}
