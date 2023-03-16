package com.example.toyshop.dto;

import lombok.Data;

@Data
public class FeedCommentListDTO {
    private Long id;
    private String comment;
    private UserDTO author;
}
