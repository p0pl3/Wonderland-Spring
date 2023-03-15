package com.example.toyshop.repository;

import com.example.toyshop.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindProductByFilters {
    List<Product> findByFilters(String title, Long id);
}
