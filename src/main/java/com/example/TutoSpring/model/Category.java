package com.example.TutoSpring.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@SuppressWarnings("ALL")
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category extends TracedEntity{


    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idCategory;

    @Column(name = "nomcategory")
    private String nomCategory;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Skills skills;
}
