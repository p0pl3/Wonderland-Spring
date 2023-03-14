package com.example.toyshop.dto;


import lombok.Data;

import java.util.List;

@Data
public class ProductCreateDTO {
    private String title;
    private Float price;
    private Short amount;
    private String description;
    private Float rating;
    private Long categoryId;
    private List<ProductImageDTO> images;
    private List<ProductCommentDTO> comments;
}
