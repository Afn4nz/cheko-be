package com.ncai.cheko.mapper;

import com.ncai.cheko.dto.CategoryResponse;
import com.ncai.cheko.dto.FilterOptionResponse;
import com.ncai.cheko.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {
    CategoryResponse mapToCategoryresponse(Category category);
    @Mapping(target = "value", source = "id")
    @Mapping(target = "label", source = "name")
    FilterOptionResponse mapToFilterOptionResponse(Category category);
}
