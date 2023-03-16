package com.example.toyshop.controller;

import com.example.toyshop.dto.ProductCreateDTO;
import com.example.toyshop.dto.ProductDetailDTO;
import com.example.toyshop.dto.ProductListDTO;
import com.example.toyshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/")
    public ResponseEntity<ProductDetailDTO> create(@RequestBody ProductCreateDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByIdDto(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductListDTO>> getProductList(@RequestParam(name = "title", required = false) String title,
                                                               @RequestParam(name = "category", required = false) Long category) {
        return ResponseEntity.ok(service.findAll(title, category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> update(@PathVariable Long id,@RequestBody ProductCreateDTO product) {
        return ResponseEntity.ok(service.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
