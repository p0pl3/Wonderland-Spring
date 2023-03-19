package com.example.toyshop.dto;

import lombok.Data;

@Data
public class ProductCommentDetailDTO {
    private Long id;
    private String comment;
    private Float rating;
    private UserDTO author;
    private ProductCategoryDTO product;
}
