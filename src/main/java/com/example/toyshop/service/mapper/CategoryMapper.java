package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.CategoryCreateDTO;
import com.example.toyshop.dto.CategoryListDTO;
import com.example.toyshop.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryCreateDTO categoryCreateDTO);

    CategoryCreateDTO toDto(Category category);

    CategoryListDTO toListDto(Category category);
}
