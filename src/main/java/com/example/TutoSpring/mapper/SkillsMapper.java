package com.example.TutoSpring.mapper;


import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.model.Skills;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface SkillsMapper {

    @Mapping(target = "categoryId",source = "category.id")
    SkillsDto toDto(Skills skill);

    Skills toEntity(SkillsDto skillDTO);

}
