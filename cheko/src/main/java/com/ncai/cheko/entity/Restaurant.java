package com.ncai.cheko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table
@Getter
public class Restaurant extends BaseEntity {
    private double lat, lon;
}
