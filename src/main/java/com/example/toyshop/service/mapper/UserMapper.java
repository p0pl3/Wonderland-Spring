package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.UserDTO;
import com.example.toyshop.dto.UserInOrderDTO;
import com.example.toyshop.entity.User_shop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User_shop toDto(UserDTO userDTO);

    UserDTO toEntity(User_shop user);

    UserInOrderDTO toUserInOrderDto(User_shop user);

    User_shop fromUserInOrderDto(UserInOrderDTO user);
}
