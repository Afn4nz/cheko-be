package com.ncai.cheko.dto;

import com.ncai.cheko.entity.Item;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import com.ncai.cheko.validator.ValidId;

@Getter
@Setter
public class ItemRequest {
    @NotNull
    @ValidId(entity = Item.class)
    private Long itemId;

    @NotNull
    @Min(value = 1, message = "AMOUNT_MIN_VALUE")
    private int amount;
}
