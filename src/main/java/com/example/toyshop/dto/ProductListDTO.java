package com.example.toyshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductListDTO {
    private Long id;
    private String title;
    private Float price;
    private Float rating;
    private CategoryDTO category;
    private List<ProductImageDTO> images;
}
