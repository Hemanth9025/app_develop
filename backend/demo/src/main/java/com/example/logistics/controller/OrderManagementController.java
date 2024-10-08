package com.example.logistics.controller;

import com.example.logistics.model.OrderManagement;
import com.example.logistics.repository.OrderManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordermanagement")
public class OrderManagementController {

    @Autowired
    private OrderManagementRepository orderManagementRepository;

    @PostMapping
    public OrderManagement createOrder(@RequestBody OrderManagement orderManagement) {
        return orderManagementRepository.save(orderManagement);
    }

    @GetMapping
    public List<OrderManagement> getAllOrders() {
        return orderManagementRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrderManagement getOrderById(@PathVariable Long id) {
        return orderManagementRepository.findById(id).orElse(null);
    }
}
