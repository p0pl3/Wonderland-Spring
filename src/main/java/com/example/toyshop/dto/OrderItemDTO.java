package com.example.toyshop.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private Short quantity;
    private ProductListDTO product;
}
