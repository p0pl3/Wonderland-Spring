package com.example.toyshop.repository.product;

import com.example.toyshop.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindProductByFilters {
    List<Product> findByFilters(String title, Long id, Long min_price, Long max_price);
}
