package com.example.TutoSpring.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "perskills")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersSkills extends TracedEntity {

    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idpersskill")
    private UUID idPers_Skill;


    @OneToMany(cascade=CascadeType.ALL,mappedBy ="persSkills")
    private Set<Personne> personne;

    @OneToMany(cascade=CascadeType.ALL,mappedBy ="persSkills")
    private Set<Skills> skills;

    @ManyToOne
    private Evaluation evaluation;








}
