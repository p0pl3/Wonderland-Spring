package com.example.toyshop.dto;

import lombok.Data;

@Data
public class OrderItemListDTO {
    private Long id;
    private Short quantity;
    private ProductCategoryDTO product;
}
