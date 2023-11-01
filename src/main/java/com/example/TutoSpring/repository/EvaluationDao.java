package com.example.TutoSpring.repository;

import com.example.TutoSpring.dto.kpis.EvaluationDto;
import com.example.TutoSpring.model.Category;
import com.example.TutoSpring.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EvaluationDao  extends JpaRepository<Evaluation, UUID> {

    EvaluationDto findByRate(Integer rate);

}
