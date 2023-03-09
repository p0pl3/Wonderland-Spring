package com.example.toyshop.service;

import com.example.toyshop.dto.ProductDTO;
import com.example.toyshop.entity.Product;
import com.example.toyshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    public Product create(ProductDTO dto) {
        Product product = Product.builder()
                .title(dto.getTitle())
                .amount(dto.getAmount())
                .category(categoryService.getById(dto.getCategoryId()))
                .build();
        return productRepository.save(product);
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public List<Product> getByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
