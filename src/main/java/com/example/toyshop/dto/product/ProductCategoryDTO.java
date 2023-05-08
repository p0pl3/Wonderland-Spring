package com.example.toyshop.dto.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductCategoryDTO {
    private Long id;
    private String title;
    private Float price;
    private Float new_price;
    private List<ProductImageDTO> images;
}
