package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.FeedCreateDTO;
import com.example.toyshop.dto.FeedListDTO;
import com.example.toyshop.entity.Feed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedMapper {
    Feed fromCreateDto(FeedCreateDTO dto);
    FeedListDTO toListDto(Feed feed);
}
