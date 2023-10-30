package com.example.TutoSpring.service.impl;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.dto.kpis.SkillsDto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;import java.util.Set;
import java.util.UUID;

public interface SkillsService {

    SkillsDto save(SkillsDto skillsDto);

    SkillsDto findById(UUID idSki);

    SkillsDto findByNomSkills(String nomSkills );

    void Delete(UUID idSki);


    SkillsDto update(SkillsDto skillsDto, UUID idSki);

    Set<SkillsDto> findAll(Pageable pageable);
}
