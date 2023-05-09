package com.example.toyshop.security;

import com.example.toyshop.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    Token token;
    UserDTO user;
}
