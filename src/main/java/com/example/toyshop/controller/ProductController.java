package com.example.toyshop.controller;

import com.example.toyshop.dto.ProductDTO;
import com.example.toyshop.entity.Product;
import com.example.toyshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        return mappingResponseProduct(productService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProductList() {
        return mappingResponseListProduct(productService.getProductList());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductsById(@PathVariable Long id) {
        return mappingResponseListProduct(productService.getByCategoryId(id));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return mappingResponseProduct(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        productService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Product> mappingResponseProduct(Product product) {
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    private ResponseEntity<List<Product>> mappingResponseListProduct(List<Product> products) {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
