package com.example.TutoSpring.repository;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryDao extends JpaRepository<Category, UUID> {

    CategoryDto findByDescription(String description );
}
