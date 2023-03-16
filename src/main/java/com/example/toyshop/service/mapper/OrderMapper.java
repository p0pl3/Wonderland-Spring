package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.OrderCreateDTO;
import com.example.toyshop.dto.OrderListDTO;
import com.example.toyshop.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order fromCreateDto(OrderCreateDTO dto);

    OrderCreateDTO toCreateDto(Order order);

    Order fromListDto(OrderListDTO dto);

    OrderListDTO toListDto(Order order);

}
