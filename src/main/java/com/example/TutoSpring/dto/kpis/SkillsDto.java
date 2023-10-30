package com.example.TutoSpring.dto.kpis;

import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.Skills;
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



    private Set<Category> category;
}
