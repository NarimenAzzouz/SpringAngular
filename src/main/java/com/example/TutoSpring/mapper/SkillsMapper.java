package com.example.TutoSpring.mapper;


import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.model.Skills;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SkillsMapper {



    @Mapping(target = "category", source = "category")
    @Mapping(target = "persSkills", source = "persSkills")
    SkillsDto fromSkillsToSkillsDto(Skills skills);


    @Mapping(target = "category", ignore = true)
    @Mapping(target = "persSkills", ignore = true)
    Skills fromSkillsDtoToSkills(SkillsDto skillsDto);
}
