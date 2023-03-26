package com.example.toyshop.dto;

import lombok.Data;

@Data
public class FeedCommentDetailDTO {
    private Long id;
    private String comment;
    private UserDTO author;
    private FeedDTO feed;
}
