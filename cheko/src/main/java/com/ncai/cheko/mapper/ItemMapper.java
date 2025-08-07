package com.ncai.cheko.mapper;

import com.ncai.cheko.dto.ItemDetailsResponse;
import com.ncai.cheko.dto.ItemResponse;
import com.ncai.cheko.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ItemMapper {
    ItemResponse mapToItemResponse(Item item);
    ItemDetailsResponse mapToItemDetailsResponse(Item item);

}
