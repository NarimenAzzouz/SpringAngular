package com.example.TutoSpring.controller;

import com.example.TutoSpring.controller.Api.PersSkillsApi;
import com.example.TutoSpring.dto.kpis.PersSkillsDto;
import com.example.TutoSpring.service.impl.PersSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
public class PersSkillsController implements PersSkillsApi {

    @Autowired
    private PersSkillsService persSkillsService;


    @Override
    public PersSkillsDto findById(UUID idPers_Skill){
        return persSkillsService.findById(idPers_Skill);
    }

    @Override
    public Set<PersSkillsDto> findAll(Pageable pageable){
        return persSkillsService.findAll(pageable);
    }
}