package com.example.toyshop.controller;

import com.example.toyshop.dto.OrderDTO;
import com.example.toyshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping("/new")
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO order) {
        return ResponseEntity.ok(service.create(order));
    }
}
