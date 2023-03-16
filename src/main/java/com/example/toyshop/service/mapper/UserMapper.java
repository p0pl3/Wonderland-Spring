package com.example.toyshop.service.mapper;

import com.example.toyshop.dto.UserCreateDTO;
import com.example.toyshop.dto.UserDTO;
import com.example.toyshop.dto.UserDetailDTO;
import com.example.toyshop.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromDetailDto(UserDetailDTO userDetailDTO);

    UserDetailDTO toDetailDto(User user);

    UserDTO toDto(User user);

    User fromDto(UserDTO dto);

    User fromCreateDto(UserCreateDTO dto);
}
