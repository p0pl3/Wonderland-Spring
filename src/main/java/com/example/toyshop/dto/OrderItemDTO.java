package com.example.toyshop.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Short quantity;
    private ProductListDTO product;
}
