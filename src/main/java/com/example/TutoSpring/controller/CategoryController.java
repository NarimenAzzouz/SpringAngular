package com.example.TutoSpring.controller;

import com.example.TutoSpring.controller.Api.CategoryApi;
import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;


@RestController
public class CategoryController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    public CategoryDto save(CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }
    @Override
    public CategoryDto findById(UUID idCategory){
        return categoryService.findById(idCategory);
    }

    @Override
    public void Delete(UUID idCategory){
        categoryService.Delete(idCategory);
    }

    @Override
    public CategoryDto findByDescription(String description){
        return categoryService.findByDescription(description);
    }

    /*@Override
    public SkillsDto update(SkillsDto skillsDto, UUID idSki){
        return skillsService.update(skillsDto,idSki);
    }*/
    @Override
    public Set<CategoryDto> findAll(Pageable pageable){
        return categoryService.findAll(pageable);
    }
}
