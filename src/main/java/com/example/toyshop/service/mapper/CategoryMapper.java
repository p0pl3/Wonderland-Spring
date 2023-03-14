package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.CategoryDTO;
import com.example.toyshop.dto.CategoryDetailDTO;
import com.example.toyshop.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDto(Category category);

    CategoryDetailDTO toDetailDTO(Category category);
}
