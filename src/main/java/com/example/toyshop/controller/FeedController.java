package com.example.toyshop.controller;

import com.example.toyshop.dto.*;
import com.example.toyshop.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService service;

    @PostMapping("/")
    public ResponseEntity<FeedListDTO> create(@RequestBody FeedCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<FeedListDTO>> getAllFeeds() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedListDTO> getFeedById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<FeedListDTO>> getAllUserFeeds(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllByUserId(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
