package com.example.toyshop.dto;

import com.example.toyshop.entity.FeedCategory;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FeedListDTO {
    private Long id;
    private String title;
    private String description;
    private Date dateCreate;
    private Date dateUpdate;
    private UserDTO author;
    private FeedCategoryDTO category;
    private List<FeedCommentListDTO> feedComments;
}
