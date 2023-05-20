package com.pravin.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pravin.orderservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
