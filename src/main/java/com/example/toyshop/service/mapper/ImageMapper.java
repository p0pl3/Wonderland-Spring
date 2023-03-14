package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.ProductImageDTO;
import com.example.toyshop.entity.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ProductImage toEntity(ProductImageDTO dto);
    ProductImageDTO toDto(ProductImage Image);
}
