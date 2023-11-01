package com.example.TutoSpring.dto.kpis;

import com.example.TutoSpring.model.PersSkills;
import com.example.TutoSpring.model.TypeEmploy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonneDto {

    private UUID idPers;


    private String nom;


    private String prenom;

    private TypeEmploy typeEmploy;

    @JsonIgnore
    private PersSkills persSkills;
}
