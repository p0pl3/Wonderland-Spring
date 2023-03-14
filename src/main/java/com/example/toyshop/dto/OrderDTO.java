package com.example.toyshop.dto;

import com.example.toyshop.entity.OrderStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private String address;
    private Date creationDate;
    private String phone;
    private UserInOrderDTO buyer;
    private List<OrderItemDTO> orderItems;
    private OrderStatus status;
    private Float total;
}
