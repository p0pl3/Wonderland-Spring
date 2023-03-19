package com.example.toyshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class FeedCategoryListDTO {
    private Long id;
    private String title;
    private String slug;
    private List<FeedDTO> feeds;
}
