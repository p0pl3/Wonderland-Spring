package com.example.toyshop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private Float price;
    private Short amount;
    private String description;
    private Float rating;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

}
