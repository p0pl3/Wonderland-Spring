package com.example.toyshop.dto.feed_comment;

import com.example.toyshop.dto.user.UserDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FeedCommentListDTO {
    private Long id;
    private String comment;
    private LocalDate dateCreation;
    private UserDTO author;
}
