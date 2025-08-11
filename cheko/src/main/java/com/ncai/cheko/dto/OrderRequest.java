package com.ncai.cheko.dto;

import com.ncai.cheko.validator.NoDuplicateItemIds;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    @NotNull
    @NoDuplicateItemIds
    private List<@Valid ItemRequest> items;
}
