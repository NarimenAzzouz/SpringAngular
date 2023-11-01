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
    private Integer rate;

    @Column(name = "remarque")
    private String remarque;

    @Column(name = "certified")
    private boolean certified;

    @Column(name = "preferance")
    private Integer preferance;


    @OneToMany(cascade=CascadeType.ALL,mappedBy ="evaluation")
    private Set<PersSkills> persSkills;





}
