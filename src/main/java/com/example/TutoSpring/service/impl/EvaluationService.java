package com.example.TutoSpring.service.impl;

import com.example.TutoSpring.dto.kpis.EvaluationDto;
import com.example.TutoSpring.dto.kpis.PersonneDto;
import com.example.TutoSpring.model.TypeEmploy;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.UUID;

public interface EvaluationService {

    EvaluationDto save(EvaluationDto evaluationDto);

    EvaluationDto findById(UUID idEval);

    EvaluationDto findByRate(Integer rate);

    void Delete(UUID idEval);


    EvaluationDto update(EvaluationDto evaluationDto, UUID idEval);

    Set<EvaluationDto> findAll(Pageable pageable);
}
