package com.example.toyshop.service;

import com.example.toyshop.dto.CategoryDTO;
import com.example.toyshop.dto.CategoryDetailDTO;
import com.example.toyshop.entity.Category;
import com.example.toyshop.repository.CategoryRepository;
import com.example.toyshop.service.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private CategoryMapper mapper;


    public CategoryDTO create(CategoryDTO CategoryDTO) {
        return mapper.toDto(categoryRepository.save(mapper.toEntity(CategoryDTO)));
    }

    public List<CategoryDetailDTO> findAll() {
        return categoryRepository.findAll().stream().map(mapper::toDetailDTO).collect(Collectors.toList());
    }

    public List<CategoryDTO> findByTitle(String title) {
        return categoryRepository.findByTitle(title).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public CategoryDTO findById(Long id){
        return mapper.toDto(categoryRepository.findById(id).orElse(null));
    }

    public Category update(Category Category) {
        return categoryRepository.save(Category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category readById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found - " + id));
    }
}
