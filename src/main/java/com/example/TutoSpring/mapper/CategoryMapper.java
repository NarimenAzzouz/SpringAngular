package com.example.TutoSpring.mapper;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    CategoryDto categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDto categoryDto);

}

