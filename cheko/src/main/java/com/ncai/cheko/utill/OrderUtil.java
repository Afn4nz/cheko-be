package com.ncai.cheko.utill;

import com.ncai.cheko.dto.OrderRequest;
import com.ncai.cheko.entity.Item;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderUtil {
    private static final double TAX = 0.15;

    public static double calculateTotalPrice(List<Item> items, OrderRequest orderRequest) {
        Map<Long, Double> priceById =
                items.stream().collect(Collectors.toMap(Item::getId, Item::getPrice));

        double subtotal =
                orderRequest.getItems().stream()
                        .mapToDouble(
                                itemRequest ->
                                        priceById.get(
                                                itemRequest.getItemId()) * itemRequest.getAmount())
                        .sum();

        return subtotal + (subtotal * TAX);
    }
}
