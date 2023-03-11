package com.example.toyshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private Date date_create;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User buyer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

}
