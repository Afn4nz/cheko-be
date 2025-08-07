package com.ncai.cheko.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse { //TODO: add the best sale field
    private Long id;
    private String name;
    private int calories;
    private double price;
}
