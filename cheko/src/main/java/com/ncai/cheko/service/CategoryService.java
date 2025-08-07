package com.ncai.cheko.service;

import com.ncai.cheko.dto.CategoryResponse;
import com.ncai.cheko.mapper.CategoryMapper;
import com.ncai.cheko.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::mapToCategoryresponse)
                .toList(); //TODO: map count
    }
}
