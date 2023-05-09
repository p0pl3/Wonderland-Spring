package com.example.toyshop.dto.product_comment;

import com.example.toyshop.dto.user.UserDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductCommentDTO {
    private Long id;
    private String comment;
    private Float rating;
    private LocalDate dateCreation;
    private UserDTO author;
}
