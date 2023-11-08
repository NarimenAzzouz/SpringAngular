package com.example.TutoSpring.controller;

import com.example.TutoSpring.controller.Api.SkillsApi;
import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.service.impl.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
public class SkillsController implements SkillsApi {

    @Autowired
    private SkillsService skillsService;


    @Override
    public SkillsDto save(SkillsDto skillsDto){
        return skillsService.save(skillsDto);
    }
    @Override
    public SkillsDto findById(UUID idSki){
        return skillsService.findById(idSki);
    }

    @Override
    public void Delete(UUID idSki){
        skillsService.Delete(idSki);
    }

    @Override
    public SkillsDto findByNomSkills(String nomSkills){
        return skillsService.findByNomSkills(nomSkills);
    }

    /*@Override
    public SkillsDto update(SkillsDto skillsDto, UUID idSki){
        return skillsService.update(skillsDto,idSki);
    }*/
    @Override
    public Set<SkillsDto> findAll(Pageable pageable){
        return skillsService.findAll(pageable);
    }


}
