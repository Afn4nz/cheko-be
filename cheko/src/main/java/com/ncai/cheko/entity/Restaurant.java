package com.ncai.cheko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Restaurant extends BaseEntity {
    private double lat, lon;
}
