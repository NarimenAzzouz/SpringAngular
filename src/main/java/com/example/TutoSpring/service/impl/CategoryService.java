package com.example.TutoSpring.service.impl;

import com.example.TutoSpring.dto.kpis.CategoryDto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(UUID idCategory);

    CategoryDto findByDescription(String description );

    void Delete(UUID idCategory);


    CategoryDto update(CategoryDto categoryDto, UUID idCategory);

    Set<CategoryDto> findAll(Pageable pageable);
}
