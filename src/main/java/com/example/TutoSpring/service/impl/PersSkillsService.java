package com.example.TutoSpring.service.impl;

import com.example.TutoSpring.dto.kpis.PersSkillsDto;
import com.example.TutoSpring.dto.kpis.SkillsDto;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.UUID;

public interface PersSkillsService {


    PersSkillsDto findById(UUID idPers_Skill);


    Set<PersSkillsDto> findAll(Pageable pageable);
}
