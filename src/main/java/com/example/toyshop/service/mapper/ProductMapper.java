package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.ProductCategoryDTO;
import com.example.toyshop.dto.ProductDetailDTO;
import com.example.toyshop.dto.ProductListDTO;
import com.example.toyshop.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntityFromDetailDto(ProductDetailDTO dto);

    ProductDetailDTO toDetailDto(Product product);

    ProductCategoryDTO toCategoryDto(Product product);

    ProductListDTO toListDto(Product product);

}
