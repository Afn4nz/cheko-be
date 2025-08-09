package com.ncai.cheko.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemResponse { //TODO: add the best sale field
    private Long id;
    private String name;
    private int calories;
    private BigDecimal price;
}
