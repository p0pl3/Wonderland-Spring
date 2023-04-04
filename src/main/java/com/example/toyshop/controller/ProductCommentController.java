package com.example.toyshop.controller;

import com.example.toyshop.dto.product_comment.ProductCommentCreateDTO;
import com.example.toyshop.dto.product_comment.ProductCommentDTO;
import com.example.toyshop.dto.product_comment.ProductCommentDetailDTO;
import com.example.toyshop.service.ProductCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/{pid}/comments")
@AllArgsConstructor
public class ProductCommentController {
    private final ProductCommentService service;

    @PostMapping("/")
    public ResponseEntity<ProductCommentDetailDTO> create(@RequestBody ProductCommentCreateDTO dto, @PathVariable Long pid) {
        return ResponseEntity.ok(service.create(dto, pid));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductCommentDTO>> getAllProductComments(@PathVariable Long pid) {
        return ResponseEntity.ok(service.findAllByProductId(pid));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
