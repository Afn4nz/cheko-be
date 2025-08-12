package com.ncai.cheko.mapper;

import com.ncai.cheko.dto.ItemDetailsResponse;
import com.ncai.cheko.dto.ItemResponse;
import com.ncai.cheko.entity.Item;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ItemMapper {

    @Named("itemToItemResponse")
    @Mapping(target = "bestSale", expression = "java(ids.contains(item.getId()))")
    ItemResponse toItemResponse(Item item, @Context Set<Long> ids);

    List<ItemResponse> toItemResponseList(List<Item> items, @Context Set<Long> ids);

    @Named("itemToItemDetailsResponse")
    @Mapping(target = "bestSale", expression = "java(ids.contains(item.getId()))")
    ItemDetailsResponse mapToItemDetailsResponse(Item item, @Context Set<Long> ids);
}
