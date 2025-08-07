package com.ncai.cheko.entity;

import jakarta.persistence.*;

import java.util.Set;

@Table
@Entity
public class Order extends AuditEntity {
    private int amount;
    private double total;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "orders_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items;
}
