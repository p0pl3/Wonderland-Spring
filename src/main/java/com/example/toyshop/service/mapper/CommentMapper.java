package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.ProductCommentDTO;
import com.example.toyshop.entity.ProductComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    ProductComment toEntity(ProductCommentDTO dto);
    ProductCommentDTO toDto(ProductComment comment);
}
