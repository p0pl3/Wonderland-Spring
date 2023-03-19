package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.OrderItemCreateDTO;
import com.example.toyshop.dto.OrderItemListDTO;
import com.example.toyshop.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItem toEntity(OrderItemCreateDTO dto);

    OrderItemCreateDTO toDto(OrderItem orderItem);

    OrderItemListDTO toListDto(OrderItem orderItem);
}
