package com.ncai.cheko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryProjection {
     private Long id;
     private String name;
     private Long itemCount;
}
