package com.example.TutoSpring.mapper;

import com.example.TutoSpring.dto.kpis.PersSkillsDto;
import com.example.TutoSpring.model.PersSkills;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersSkillsMapper {

    PersSkillsDto persSkillsToPersSkillsDto(PersSkills persSkills);
    PersSkills persSkillsDtoToPersSkills(PersSkillsDto persSkillsDto);

}
