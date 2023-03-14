package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.OrderDTO;
import com.example.toyshop.dto.UserInOrderDTO;
import com.example.toyshop.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderDTO orderDTO);

    OrderDTO toDto(Order order);




}
