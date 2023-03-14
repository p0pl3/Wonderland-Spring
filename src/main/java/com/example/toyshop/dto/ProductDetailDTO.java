package com.example.toyshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDetailDTO {
    private String title;
    private Float price;
    private Short amount;
    private String description;
    private Float rating;
    private CategoryDTO category;
    private List<ProductImageDTO> images;
    private List<ProductCommentDTO> comments;
}
