package com.example.toyshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryListDTO {
    private Long id;
    private String title;
    private String slug;
    private List<ProductCategoryDTO> products;
}
