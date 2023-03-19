package com.example.toyshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDetailDTO {
    private Long id;
    private String title;
    private Float price;
    private Short amount;
    private String description;
    private Float rating;
    private CategoryProductDTO category;
    private List<ProductImageDTO> images;
    private List<ProductCommentDTO> comments;
    private Float new_price;
    private Float discount;
    private Float delivery_period;
}
