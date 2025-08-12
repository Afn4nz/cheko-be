package com.ncai.cheko.controller;

import com.ncai.cheko.Spesifications.ItemSpecification;
import com.ncai.cheko.dto.common.ApiResponse;
import com.ncai.cheko.entity.Item;
import com.ncai.cheko.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ncai.cheko.validator.ValidId;

@Validated
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemDetails(@PathVariable @ValidId(entity = Item.class) Long id) {
        return ApiResponse.getSuccessResponse(itemService.getItemDetails(id));
    }

   @GetMapping("/filter")
    public ResponseEntity<?> getCategoryFilter() {
        return ApiResponse.getSuccessResponse(itemService.getCategoriesFilter());
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTopNCalories(@RequestParam(value = "topN", defaultValue = "2") int topN) {
        return ApiResponse.getSuccessResponse(itemService.findTopNItemsPerCategoryByCalories(topN));
    }
}
