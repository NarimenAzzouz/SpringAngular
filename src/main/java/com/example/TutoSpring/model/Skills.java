package com.example.TutoSpring.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "skills")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Skills extends TracedEntity {


    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idSki;

    @Column(name = "nomskills")
    private String nomSkills;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    private PersSkills persSkills ;
}
