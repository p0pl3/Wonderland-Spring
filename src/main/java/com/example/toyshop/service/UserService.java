package com.example.toyshop.service;

import com.example.toyshop.dto.UserCreateDTO;
import com.example.toyshop.dto.UserDTO;
import com.example.toyshop.dto.UserDetailDTO;
import com.example.toyshop.entity.User;
import com.example.toyshop.repository.UserRepository;
import com.example.toyshop.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private UserMapper mapper;

    public UserDetailDTO create(UserCreateDTO dto){
        return mapper.toDetailDto(repository.save(mapper.fromCreateDto(dto)));
    }

    public List<UserDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public User findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public UserDetailDTO findByIdDto(Long id){
        return mapper.toDetailDto(repository.findById(id).orElse(null));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
