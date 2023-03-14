package com.example.toyshop.dto;

import lombok.Data;

@Data
public class ProductCommentDTO {
    private Long id;
    private String comment;
    private Float rating;
}
