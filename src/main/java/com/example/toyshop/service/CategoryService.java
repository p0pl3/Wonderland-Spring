package com.example.toyshop.service;

import com.example.toyshop.entity.Category;
import com.example.toyshop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found" + id));
    }
}
