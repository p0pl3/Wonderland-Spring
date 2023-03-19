package com.example.toyshop.service;

import com.example.toyshop.dto.CategoryCreateDTO;
import com.example.toyshop.dto.CategoryListDTO;
import com.example.toyshop.dto.FeedCategoryCreateDTO;
import com.example.toyshop.dto.FeedCategoryListDTO;
import com.example.toyshop.entity.FeedCategory;
import com.example.toyshop.entity.User;
import com.example.toyshop.repository.FeedCategoryRepository;
import com.example.toyshop.service.mapper.FeedCategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FeedCategoryService {

    private final FeedCategoryRepository repository;
    private FeedCategoryMapper mapper;

    public FeedCategoryListDTO create(FeedCategoryCreateDTO dto) {
        return mapper.toListDto(repository.save(mapper.fromCreateDto(dto)));
    }

    public List<FeedCategoryListDTO> findAll() {
        return repository.findAll().stream().map(mapper::toListDto).collect(Collectors.toList());
    }

    public FeedCategory findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
