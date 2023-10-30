package com.example.TutoSpring.service.impl.Implementation;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.Skills;
import com.example.TutoSpring.repository.CategoryDao;
import com.example.TutoSpring.service.impl.CategoryService;
import com.example.TutoSpring.service.impl.SkillsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto,Category.class);
        Category saved = categoryDao.save(category);
        return modelMapper.map(saved, CategoryDto.class);
    }

    @Override
    public CategoryDto findById(UUID idCategory) {
        Category category = categoryDao.findById(idCategory).orElseThrow(()-> new RuntimeException("Category not Found"));
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public CategoryDto findByDescription(String description) {
        CategoryDto category = categoryDao.findByDescription(description);
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public void Delete(UUID idCategory) {
        categoryDao.deleteById(idCategory);

    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, UUID idCategory) {
        Optional<Category> categoryOptional = categoryDao.findById(idCategory);
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get(); // Récupérer l'objet Certification existant
            // Mettre à jour les champs de l'objet Certification avec les valeurs de certificationDto
            category.setNomCategory(categoryDto.getNomCategory()); // Remplacez "champ1" par le nom de vos champs
            category.setDescription(categoryDto.getDescription()); // Remplacez "champ2" par le nom de vos champs
            category.setSkills(categoryDto.getSkills()); // Remplacez "champ2" par le nom de vos champs




            Category updated = categoryDao.save(category);
            return modelMapper.map(updated, CategoryDto.class);
        } else {
            throw new NoSuchElementException("Category non trouvée avec l'ID: " + idCategory);
        }
    }

    @Override
    public Set<CategoryDto> findAll(Pageable pageable) {
        return categoryDao.findAll(PageRequest.of(0, 10)).stream().map(el ->modelMapper.map(el,CategoryDto.class))
                .collect(Collectors.toSet());
    }
    }

