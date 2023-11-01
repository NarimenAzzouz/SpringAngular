package com.example.TutoSpring.dto.kpis;

import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.PersSkills;
import com.example.TutoSpring.model.Skills;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SkillsDto {


    private UUID idSki;


    private String nomSkills;



    @JsonIgnore
    private Set<Category> category;

    @JsonIgnore
    private PersSkills persSkills;
}
