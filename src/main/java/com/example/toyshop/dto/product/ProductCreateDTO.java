package com.example.toyshop.dto.product;


import com.example.toyshop.dto.product_comment.ProductCommentDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductCreateDTO {
    private String title;
    private Float price;
    private Integer amount;
    private String description;
    private Float rating;
    private Long categoryId;
    private Short discount;
    private Short delivery_period;
}
