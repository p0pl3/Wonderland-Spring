package com.example.toyshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private List<OrderDTO> orders;
    private List<ProductCommentDTO> productComments;
}
