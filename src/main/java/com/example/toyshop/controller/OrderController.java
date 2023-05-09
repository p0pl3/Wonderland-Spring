package com.example.toyshop.controller;

import com.example.toyshop.dto.order.OrderCreateDTO;
import com.example.toyshop.dto.order.OrderItemListDTO;
import com.example.toyshop.dto.order.OrderListDTO;
import com.example.toyshop.entity.User;
import com.example.toyshop.security.AuthenticatedUserService;
import com.example.toyshop.service.OrderItemService;
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
    private final OrderItemService orderItemService;
    private final AuthenticatedUserService authenticatedUserService;

    @PostMapping("/")
    public ResponseEntity<OrderListDTO> create(@RequestBody OrderCreateDTO order) {
        User user = authenticatedUserService.getAuthenticatedPerson();
        return ResponseEntity.ok(service.create(order, user));
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderListDTO>> getAllOrders() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderListDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderListDTO>> getAllUserOrdersById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }

    @GetMapping("/user")
    public ResponseEntity<List<OrderListDTO>> getAllUserOrders() {
        User user = authenticatedUserService.getAuthenticatedPerson();
        return ResponseEntity.ok(service.findAllByUserId(user.getId()));
    }

    @GetMapping("/{oid}/items/list")
    public ResponseEntity<List<OrderItemListDTO>> getAllOrderItems(@PathVariable Long oid) {
        return ResponseEntity.ok(orderItemService.findAllByOrderId(oid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
