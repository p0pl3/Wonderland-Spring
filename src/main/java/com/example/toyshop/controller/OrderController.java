package com.example.toyshop.controller;

import com.example.toyshop.dto.OrderCreateDTO;
import com.example.toyshop.dto.OrderListDTO;
import com.example.toyshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping("/")
    public ResponseEntity<OrderCreateDTO> create(@RequestBody OrderCreateDTO order) {
        return ResponseEntity.ok(service.create(order));
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderListDTO>> getAllOrders() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderCreateDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderListDTO>> getAllUserOrders(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
