package com.example.TutoSpring.dto.kpis;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSki")
public class SkillsDto {


    private UUID id;


    private String nomSkills;



    private UUID categoryId ;


    //private PersSkillsDto persSkills;










    }



