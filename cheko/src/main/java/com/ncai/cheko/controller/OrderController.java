package com.ncai.cheko.controller;

import com.ncai.cheko.dto.common.ApiResponse;
import com.ncai.cheko.dto.OrderRequest;
import com.ncai.cheko.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody @Valid OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return ApiResponse.getSuccessResponse("Ordered Successfully");
    }

    @GetMapping("/total")
    public ResponseEntity<?> getOrdersTotals() {
        return ApiResponse.getSuccessResponse(orderService.getOrdersTotal());
    }
}
