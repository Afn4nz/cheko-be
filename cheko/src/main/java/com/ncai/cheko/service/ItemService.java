package com.ncai.cheko.service;

import com.ncai.cheko.Spesifications.ItemSpecification;
import com.ncai.cheko.dto.*;
import com.ncai.cheko.dto.FilterOptionResponse;
import com.ncai.cheko.dto.ItemDetailsResponse;
import com.ncai.cheko.dto.ItemResponse;
import com.ncai.cheko.dto.common.PaginatedResponse;
import com.ncai.cheko.entity.Item;
import com.ncai.cheko.mapper.CategoryMapper;
import com.ncai.cheko.mapper.ItemMapper;
import com.ncai.cheko.repository.CategoryRepository;
import com.ncai.cheko.repository.ItemRepository;
import org.springframework.cache.annotation.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public PaginatedResponse<ItemResponse> getAllItems(
            ItemSpecification specification, Pageable pageable) {
        Page<Item> itemsPage = itemRepository.findAll(specification, pageable);
        return new PaginatedResponse<>(
                itemsPage.getContent().stream()
                        .map(itemMapper::mapToItemResponse)
                        .collect(Collectors.toList()),
                itemsPage.getNumber(),
                itemsPage.getSize(),
                itemsPage.getTotalElements(),
                itemsPage.getTotalPages());
    }

    public ItemDetailsResponse getItemDetails(Long id) {
        return itemMapper.mapToItemDetailsResponse(itemRepository.findById(id).get());
    }

    public List<FilterOptionResponse> getCategoriesFilter() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::mapToFilterOptionResponse)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "itemPrice:all")
    public Map<Long, BigDecimal> getPriceMap() {
        return itemRepository.findAllPrices().stream()
                .collect(
                        Collectors.toMap(
                                ItemPriceProjection::getId, ItemPriceProjection::getPrice));
    }
}
