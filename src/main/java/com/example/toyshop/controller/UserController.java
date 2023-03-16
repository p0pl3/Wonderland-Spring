package com.example.toyshop.controller;

import com.example.toyshop.dto.*;
import com.example.toyshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/")
    public ResponseEntity<UserDetailDTO> create(@RequestBody UserCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> geUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByIdDto(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> getProductList() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
