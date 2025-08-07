package com.ncai.cheko.controller;

import com.ncai.cheko.Spesifications.ItemSpecification;
import com.ncai.cheko.dto.ApiResponse;
import com.ncai.cheko.entity.Item;
import com.ncai.cheko.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import validator.ValidId;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping()
    public ResponseEntity<?> getAllItems(
            @PageableDefault Pageable pageable, ItemSpecification specification) {
        return ApiResponse.getSuccessResponse(itemService.getAllItems(specification, pageable));
    }

    @GetMapping("/{id}") //TODO: Handle the exception
    public ResponseEntity<?> getItemDetails(@PathVariable @ValidId(entity = Item.class) Long id) {
        return ApiResponse.getSuccessResponse(itemService.getItemDetails(id));
    }

   @GetMapping("/filter")
    public ResponseEntity<?> getCategoryFilter() {
        return ApiResponse.getSuccessResponse(itemService.getCategoriesFilter());
    }
}
