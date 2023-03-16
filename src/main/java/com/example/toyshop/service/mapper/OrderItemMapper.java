package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.OrderItemCreateDTO;
import com.example.toyshop.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItem toEntity(OrderItemCreateDTO orderItemCreateDTO);

    OrderItemCreateDTO toDto(OrderItem orderItem);
}
