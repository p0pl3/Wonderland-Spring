package com.example.toyshop.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String title;
    private Short amount;
    private Long categoryId;
}
