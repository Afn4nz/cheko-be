package com.ncai.cheko.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Item extends BaseEntity {
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private double price;
    private double calories;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private Set<Order> orders;
}
