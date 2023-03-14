package com.example.toyshop.controller;

import com.example.toyshop.dto.CategoryDTO;
import com.example.toyshop.dto.CategoryDetailDTO;
import com.example.toyshop.entity.Category;
import com.example.toyshop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/new")
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO category){
        return ResponseEntity.ok(service.create(category));
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDetailDTO>> getCategoryList() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}