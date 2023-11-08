package com.example.TutoSpring.dto.kpis;

import com.example.TutoSpring.model.Evaluation;
import com.example.TutoSpring.model.PersSkills;
import com.example.TutoSpring.model.Personne;
import com.example.TutoSpring.model.Skills;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersSkillsDto {

    private UUID idPers_Skill;


    private Set<Personne> personne;

    private Set<SkillsDto> skills;

    private Evaluation evaluation;

    private Date lastUpadte;
}
