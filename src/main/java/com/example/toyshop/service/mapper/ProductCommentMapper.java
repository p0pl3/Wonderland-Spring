package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.ProductCommentCreateDTO;
import com.example.toyshop.dto.ProductCommentDTO;
import com.example.toyshop.dto.ProductCommentDetailDTO;
import com.example.toyshop.entity.ProductComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCommentMapper {
    ProductComment toEntity(ProductCommentDTO dto);

    ProductCommentDTO toDto(ProductComment comment);

    ProductComment fromCreateDto(ProductCommentCreateDTO dto);

    ProductCommentDetailDTO toDetailDto(ProductComment comment);
}
