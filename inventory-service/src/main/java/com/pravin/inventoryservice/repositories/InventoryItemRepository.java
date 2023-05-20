package com.pravin.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravin.inventoryservice.entities.InventoryItem;

import java.util.Optional;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByProductCode(String productCode);
}
