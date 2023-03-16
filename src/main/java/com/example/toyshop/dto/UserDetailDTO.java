package com.example.toyshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailDTO {
    private Long id;
    private String email;
    private List<OrderCreateDTO> orders;
    private List<ProductCommentDTO> productComments;
}
