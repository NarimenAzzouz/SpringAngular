package com.example.TutoSpring.dto.kpis;

import com.example.TutoSpring.model.Evaluation;
import com.example.TutoSpring.model.PersSkills;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EvaluationDto {

    private UUID idEval;

   @JsonIgnore
   private Set<PersSkills> persSkills;


    private Integer Rate;


    private String Remarque;


    private boolean Certified;


    private Integer Preferance;
}
