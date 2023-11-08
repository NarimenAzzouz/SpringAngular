package com.example.TutoSpring.service.impl.Implementation;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.Skills;
import com.example.TutoSpring.repository.CategoryDao;
import com.example.TutoSpring.service.impl.CategoryService;
import com.example.TutoSpring.service.impl.SkillsService;
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



    }

