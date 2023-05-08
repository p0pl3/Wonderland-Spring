package com.example.toyshop.security;

import com.example.toyshop.dto.user.UserCreateDTO;
import com.example.toyshop.mapper.UserMapper;
import com.example.toyshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper mapper;


    public AuthResponse register(UserCreateDTO userRegistryDTO) {
        var user = userService.save(userRegistryDTO);
        return new AuthResponse(new Token(jwtService.generateToken(user)), mapper.toDto(user));
    }

    public AuthResponse authenticate(UserCreateDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword(),
                        new ArrayList<>()
                )
        );
        var user = userService.getByEmail(request.getEmail());
        return new AuthResponse(new Token(jwtService.generateToken(user)), mapper.toDto(user));
    }
}
