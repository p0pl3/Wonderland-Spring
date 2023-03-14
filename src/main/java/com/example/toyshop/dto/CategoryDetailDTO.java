package com.example.toyshop.dto;

import com.example.toyshop.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDetailDTO {
    private Long id;
    private String title;
    private String slug;
    private List<ProductCategoryDTO> products;
}
