package com.example.toyshop.dto;

import lombok.Data;

@Data
public class FeedCommentCreateDTO {
    private String comment;
    private Long authorId;
    private Long feedId;
}
