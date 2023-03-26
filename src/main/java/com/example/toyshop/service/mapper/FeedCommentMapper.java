package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.FeedCommentCreateDTO;
import com.example.toyshop.dto.FeedCommentDetailDTO;
import com.example.toyshop.dto.FeedCommentListDTO;
import com.example.toyshop.entity.FeedComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedCommentMapper {
    FeedComment fromCreateDto(FeedCommentCreateDTO dto);
    FeedCommentDetailDTO toDetailDto(FeedComment dto);
    FeedCommentListDTO toListDto(FeedComment dto);
}
