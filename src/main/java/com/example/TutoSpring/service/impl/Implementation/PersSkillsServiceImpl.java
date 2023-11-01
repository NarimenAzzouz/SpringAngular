package com.example.TutoSpring.service.impl.Implementation;

import com.example.TutoSpring.dto.kpis.PersSkillsDto;
import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.model.PersSkills;
import com.example.TutoSpring.model.Skills;
import com.example.TutoSpring.repository.PersSkillsDao;
import com.example.TutoSpring.service.impl.PersSkillsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersSkillsServiceImpl implements PersSkillsService {

    @Autowired
    private PersSkillsDao persSkillsDao;


    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PersSkillsDto findById(UUID idPers_Skill) {
        PersSkills persSkills = persSkillsDao.findById(idPers_Skill).orElseThrow(()-> new RuntimeException("persSkills not Found"));
        return modelMapper.map(persSkills, PersSkillsDto.class);
    }

    @Override
    public Set<PersSkillsDto> findAll(Pageable pageable) {
        return persSkillsDao.findAll(PageRequest.of(0, 10)).stream().map(el ->modelMapper.map(el,PersSkillsDto.class))
                .collect(Collectors.toSet());
    }
    }

