package com.example.toyshop.dto.user;

import com.example.toyshop.dto.order.OrderCreateDTO;
import com.example.toyshop.dto.product_comment.ProductCommentDTO;
import com.example.toyshop.security.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDetailDTO {
    private Long id;
    private String email;
    private Role role;
    private List<OrderCreateDTO> orders;
    private List<ProductCommentDTO> productComments;
}
