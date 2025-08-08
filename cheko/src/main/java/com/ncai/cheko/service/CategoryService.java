package com.ncai.cheko.service;

import com.ncai.cheko.dto.CategoryProjection;
import com.ncai.cheko.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    // TODO: cache categories
    public List<CategoryProjection> getAllCategories() {
        return categoryRepository.findCategoryList();
    }
}
