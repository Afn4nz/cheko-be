package com.ncai.cheko.utill;

import com.ncai.cheko.dto.OrderRequest;

import java.math.BigDecimal;
import java.util.Map;

public class OrderUtil {
    private static final double TAX = 0.15;

    public static BigDecimal calculateTotalPrice(
            Map<Long, BigDecimal> priceById, OrderRequest orderRequest) {

        BigDecimal subtotal =
                orderRequest.getItems().stream()
                        .map(
                                item ->
                                        priceById
                                                .get(item.getItemId())
                                                .multiply(BigDecimal.valueOf(item.getQuantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        return subtotal.multiply(BigDecimal.valueOf(1).add(BigDecimal.valueOf(TAX)));
    }
}
