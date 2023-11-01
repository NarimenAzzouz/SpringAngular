package com.example.TutoSpring.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "evaluation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Evaluation extends TracedEntity{

    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ideval")
    private UUID idEval;



    @Column(name = "rate")
    private Integer Rate;

    @Column(name = "remarque")
    private String Remarque;

    @Column(name = "certified")
    private boolean Certified;

    @Column(name = "preferance")
    private Integer Preferance;


    @OneToMany(cascade=CascadeType.ALL,mappedBy ="evaluation")
    private Set<PersSkills> persSkills;





}
