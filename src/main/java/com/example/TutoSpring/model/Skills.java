package com.example.TutoSpring.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "skills")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Skills extends TracedEntity{


    @Id
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID idSki;

    @Column(name = "nomskills")
    private String nomSkills;


    @OneToMany(mappedBy = "skills")
    private Set<Category> category;




}
