package com.ncai.cheko.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "orders_items")
@Getter
public class OrderItem extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(nullable = false)
    private int amount;
}
