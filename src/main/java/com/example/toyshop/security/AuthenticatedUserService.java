package com.example.toyshop.security;

import com.example.toyshop.entity.User;
import com.example.toyshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticatedUserService {
    private final UserService userService;
    public User getAuthenticatedPerson() {
        UserDetailsCustom userDetailsCustom = (UserDetailsCustom) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userService.getByEmail(userDetailsCustom.getEmail());
    }
}
