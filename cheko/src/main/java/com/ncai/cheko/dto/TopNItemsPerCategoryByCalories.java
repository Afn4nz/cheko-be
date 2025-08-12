package com.ncai.cheko.dto;

import java.math.BigDecimal;

public interface TopNItemsPerCategoryByCalories {
    Long getId();
    String getName();
    String getCategoryName();
    Integer getCalories();
    BigDecimal getPrice();
}
