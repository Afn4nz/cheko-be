package com.ncai.cheko.controller;

import com.ncai.cheko.dto.ApiResponse;
import com.ncai.cheko.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<?> getAllLocations() {
        return ApiResponse.getSuccessResponse(restaurantService.getAllLocations());
    }
}
