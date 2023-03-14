package com.example.toyshop.controller;

import com.example.toyshop.entity.OrderItem;
import com.example.toyshop.service.OrderItemService;
import com.example.toyshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/{oid}/items")
@AllArgsConstructor
public class OrderItemController {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
}
