package com.example.toyshop.controller;

import com.example.toyshop.dto.OrderItemListDTO;
import com.example.toyshop.dto.ProductCommentDTO;
import com.example.toyshop.service.OrderItemService;
import com.example.toyshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders/{oid}/items")
@AllArgsConstructor
public class OrderItemController {
    private final OrderItemService service;
    private final OrderService orderService;

    @GetMapping("/list")
    public ResponseEntity<List<OrderItemListDTO>> getAllOrderItems(@PathVariable Long oid) {
        return ResponseEntity.ok(service.findAllByOrderId(oid));
    }



}
