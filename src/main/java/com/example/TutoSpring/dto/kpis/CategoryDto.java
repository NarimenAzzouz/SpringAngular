package com.example.TutoSpring.dto.kpis;

import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.Skills;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDto {

    private UUID idCategory;


    private String nomCategory;


    private String description;


    @JsonIgnore
    private Skills skills;
}
