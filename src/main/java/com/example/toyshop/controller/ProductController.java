package com.example.toyshop.controller;

import com.example.toyshop.dto.CategoryDTO;
import com.example.toyshop.dto.ProductDetailDTO;
import com.example.toyshop.dto.ProductListDTO;
import com.example.toyshop.entity.Product;
import com.example.toyshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService service;

    @PostMapping("/new")
    public ResponseEntity<ProductDetailDTO> create(@RequestBody ProductDetailDTO productDetailDTO) {
        return ResponseEntity.ok(service.create(productDetailDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductListDTO>> getProductList() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/filter/category")
    public ResponseEntity<List<ProductListDTO>> categoryFilter(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(service.findByCategory(category));
    }

    @GetMapping("/filter/title")
    public ResponseEntity<List<ProductListDTO>> titleFilter(@RequestParam String title) {
        return ResponseEntity.ok(service.findByTitle(title));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> update(@RequestBody Product product) {
        return ResponseEntity.ok(service.update(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Product> mappingResponseProduct(Product product) {
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    private ResponseEntity<List<Product>> mappingResponseListProduct(List<Product> products) {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
