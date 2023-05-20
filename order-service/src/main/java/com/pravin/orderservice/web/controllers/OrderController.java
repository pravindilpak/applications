package com.pravin.orderservice.web.controllers;

import com.pravin.orderservice.entities.Order;
import com.pravin.orderservice.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {

    private OrderRepository repo;

    @Autowired
    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/api/orders")
    public Order createOrder(@RequestBody Order order) {
        return repo.save(order);
    }

    @GetMapping("/api/orders/{id}")
    public Optional<Order> findOrderById(@PathVariable Long id) {
        return repo.findById(id);
    }

}
