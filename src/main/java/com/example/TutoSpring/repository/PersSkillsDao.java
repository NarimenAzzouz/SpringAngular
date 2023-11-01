package com.example.TutoSpring.repository;

import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.PersSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersSkillsDao  extends JpaRepository<PersSkills, UUID> {
}
