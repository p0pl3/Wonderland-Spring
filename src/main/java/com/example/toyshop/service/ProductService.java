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

    public Product create(ProductDTO dto) {
        Product product = Product.builder()
                .title(dto.getTitle())
                .amount(dto.getAmount())
                .build();
        return productRepository.save(product);
    }

    public List<Product> readAll(){
        return productRepository.findAll();
    }

    public Product update(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
