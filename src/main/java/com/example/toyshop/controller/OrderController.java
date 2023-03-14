package com.example.toyshop.controller;

import com.example.toyshop.dto.OrderDTO;
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

    @PostMapping("/new")
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO order) {
        return ResponseEntity.ok(service.create(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDTO>> getAllUserOrders(@RequestParam Long id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
