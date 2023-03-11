package com.example.toyshop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductImage> productImages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductComment> productComments;
}
