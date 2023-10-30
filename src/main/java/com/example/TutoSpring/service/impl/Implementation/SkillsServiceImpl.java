package com.example.TutoSpring.service.impl.Implementation;

import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.model.Skills;
import com.example.TutoSpring.repository.SkillsDao;
import com.example.TutoSpring.service.impl.CategoryService;
import com.example.TutoSpring.service.impl.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SkillsServiceImpl implements SkillsService {



    @Autowired
    private SkillsDao skillsDao;

    @Autowired
    private ModelMapper modelMapper;





    @Override
    public SkillsDto save(SkillsDto skillsDto) {

        Skills skills = modelMapper.map(skillsDto,Skills.class);
        Skills saved = skillsDao.save(skills);
        return modelMapper.map(saved,SkillsDto.class);

    }


    @Override
    public SkillsDto findById(UUID idSki)
    {
        Skills skills = skillsDao.findById(idSki).orElseThrow(()-> new RuntimeException("Skills not Found"));
        return modelMapper.map(skills,SkillsDto.class);
    }

    @Override
    public SkillsDto findByNomSkills(String nomSkills) {

        SkillsDto skills = skillsDao.findByNomSkills(nomSkills);
        return modelMapper.map(skills,SkillsDto.class);

    }

    @Override
    public void Delete(UUID idSki) {

        skillsDao.deleteById(idSki);
    }

    @Override
    public SkillsDto update(SkillsDto skillsDto, UUID idSki) {

        Optional<Skills> skillsOptional = skillsDao.findById(idSki);
        if(skillsOptional.isPresent()){
            Skills skills = skillsOptional.get(); // Récupérer l'objet Certification existant
            // Mettre à jour les champs de l'objet Certification avec les valeurs de certificationDto
            skills.setNomSkills(skillsDto.getNomSkills()); // Remplacez "champ1" par le nom de vos champs
            skills.setCategory(skillsDto.getCategory()); // Remplacez "champ2" par le nom de vos champs



            Skills updated = skillsDao.save(skills);
            return modelMapper.map(updated, SkillsDto.class);
        } else {
            throw new NoSuchElementException("Skills non trouvée avec l'ID: " + idSki);
        }
    }

    @Override
    public Set<SkillsDto> findAll(Pageable pageable) {


        return skillsDao.findAll(PageRequest.of(0, 10)).stream().map(el ->modelMapper.map(el,SkillsDto.class))
                .collect(Collectors.toSet());
    }
    }

