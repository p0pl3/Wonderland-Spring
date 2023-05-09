package com.example.toyshop.dto.feed;

import lombok.Data;

import java.util.Date;

@Data
public class FeedCreateDTO {
    private String title;
    private String description;
    private Long categoryId;
}
