package com.example.TutoSpring.repository;

import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.model.Skills;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillsDao extends JpaRepository<Skills, UUID> {

    SkillsDto findByNomSkills(String nomSkills );




}
