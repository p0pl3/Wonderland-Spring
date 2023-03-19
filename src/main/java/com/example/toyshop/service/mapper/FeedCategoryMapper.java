package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.FeedCategoryCreateDTO;
import com.example.toyshop.dto.FeedCategoryListDTO;
import com.example.toyshop.entity.FeedCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedCategoryMapper {
    FeedCategory fromCreateDto(FeedCategoryCreateDTO dto);

    FeedCategoryCreateDTO toCreateDto(FeedCategory category);

    FeedCategoryListDTO toListDto(FeedCategory category);
}
