package com.example.TutoSpring.service.impl.Implementation;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.dto.kpis.PersonneDto;
import com.example.TutoSpring.model.Personne;
import com.example.TutoSpring.model.TypeEmploy;
import com.example.TutoSpring.repository.PersonneDao;
import com.example.TutoSpring.service.impl.PersonneService;
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
public class PersonneServiceImpl implements PersonneService {


    @Autowired
    private PersonneDao personneDao;


    }

