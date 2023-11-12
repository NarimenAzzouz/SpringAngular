package com.example.TutoSpring.mapper;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDTO);

}

