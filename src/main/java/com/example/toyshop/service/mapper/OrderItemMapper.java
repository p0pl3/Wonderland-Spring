package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.OrderItemDTO;
import com.example.toyshop.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItem toEntity(OrderItemDTO orderItemDTO);

    OrderItemDTO toDto(OrderItem orderItem);
}
