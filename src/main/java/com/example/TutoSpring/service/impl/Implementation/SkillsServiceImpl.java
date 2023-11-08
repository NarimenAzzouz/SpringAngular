package com.example.TutoSpring.service.impl.Implementation;

import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.mapper.SkillsMapper;
import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.Skills;
import com.example.TutoSpring.repository.CategoryDao;
import com.example.TutoSpring.repository.SkillsDao;
import com.example.TutoSpring.service.impl.CategoryService;
import com.example.TutoSpring.service.impl.SkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillsServiceImpl implements SkillsService {



    @Autowired
    private final SkillsDao skillsDao;

    @Autowired
    private final CategoryDao categoryDao;

    @Autowired
    private final SkillsMapper skillsMapper;






    @Override
    public SkillsDto save(SkillsDto skillsDto) {

        Skills skills = skillsMapper.fromSkillsDtoToSkills(skillsDto);
        skills = skillsDao.save(skills);
        return skillsMapper.fromSkillsToSkillsDto(skills);

    }

    @Override
    public SkillsDto findById(UUID idSki) {
        Skills skills = skillsDao.findById(idSki).orElse(null);
        return skillsMapper.fromSkillsToSkillsDto(skills);
    }

    @Override
    public SkillsDto findByNomSkills(String nomSkills) {
        return null;
    }

    @Override
    public void Delete(UUID idSki) {
        skillsDao.deleteById(idSki);

    }

    @Override
    public SkillsDto update(SkillsDto skillsDto, UUID idSki) {
        Skills existingSkills = skillsDao.findById(idSki).orElse(null);
        if (existingSkills != null) {
            skillsDto.setIdSki(idSki);
            Skills updatedSkills = skillsMapper.fromSkillsDtoToSkills(skillsDto);
            updatedSkills = skillsDao.save(updatedSkills);
            return skillsMapper.fromSkillsToSkillsDto(updatedSkills);
        }
        return null;
    }

    @Override
    public Set<SkillsDto> findAll(Pageable pageable) {

        return skillsDao.findAll(PageRequest.of(0, 10)).stream()
                .map(skillsMapper::fromSkillsToSkillsDto)
                .collect(Collectors.toSet());
    }

    }



