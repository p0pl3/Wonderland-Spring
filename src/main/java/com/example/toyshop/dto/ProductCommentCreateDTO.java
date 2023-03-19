package com.example.toyshop.dto;

import lombok.Data;

@Data
public class ProductCommentCreateDTO {
    private String comment;
    private Float rating;
    private Long authorId;
}
