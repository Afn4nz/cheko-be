package com.ncai.cheko.mapper;

import com.ncai.cheko.dto.ItemRequest;
import com.ncai.cheko.entity.Item;
import com.ncai.cheko.entity.OrderItem;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    List<OrderItem> toEntities(List<ItemRequest> itemRequests, @Context Map<Long, Item> itemById);

    @Mapping(target = "item", expression = "java(itemById.get(itemRequest.getItemId()))")
    OrderItem toEntity(ItemRequest itemRequest, @Context Map<Long, Item> itemById);
}
