package com.example.toyshop.dto;

import lombok.Data;

@Data
public class OrderItemCreateDTO {
    private Short quantity;
    private Long productId;
}
