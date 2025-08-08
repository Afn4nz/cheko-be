package com.ncai.cheko.dto;

import com.ncai.cheko.entity.Item;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import com.ncai.cheko.validator.ValidId;

@Getter
@Setter
public class ItemRequest {
    @ValidId(entity = Item.class)
    private Long itemId;

    @Min(1)
    private int amount;
}
