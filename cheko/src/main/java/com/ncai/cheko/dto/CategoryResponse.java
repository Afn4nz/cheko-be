package com.ncai.cheko.dto;

import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private int count;
}
