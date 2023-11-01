package com.example.TutoSpring.controller;

import com.example.TutoSpring.controller.Api.PersonneApi;
import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.dto.kpis.PersonneDto;
import com.example.TutoSpring.model.TypeEmploy;
import com.example.TutoSpring.service.impl.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
public class PersonneController implements PersonneApi {

    @Autowired
    private PersonneService personneService;

    @Override
    public PersonneDto save(PersonneDto personneDto){
        return personneService.save(personneDto);
    }

    @Override
    public PersonneDto findById(UUID idPers){
        return personneService.findById(idPers);
    }

    @Override
    public PersonneDto findByTypeEmploy(TypeEmploy typeEmploy){
        return personneService.findByTypeEmploy(typeEmploy);
    }

    @Override
    public void Delete(UUID idPers){
        personneService.Delete(idPers);
    }

    @Override
    public Set<PersonneDto> findAll(Pageable pageable){
        return personneService.findAll(pageable);

    }
}
