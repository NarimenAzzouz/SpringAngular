package com.example.TutoSpring.controller;

import com.example.TutoSpring.controller.Api.EvaluationApi;
import com.example.TutoSpring.dto.kpis.EvaluationDto;
import com.example.TutoSpring.service.impl.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
public class EvaluationController implements EvaluationApi {


    @Autowired
    private EvaluationService evaluationService;

    @Override
    public EvaluationDto save(EvaluationDto evaluationDto){
        return evaluationService.save(evaluationDto);
    }
    @Override
    public EvaluationDto findById(UUID idEval){
        return evaluationService.findById(idEval);
    }

    @Override
    public EvaluationDto findByRate(Integer rate){
        return evaluationService.findByRate(rate);
    }

    @Override
    public void Delete(UUID idEval){
        evaluationService.Delete(idEval);
    }

    @Override
    public Set<EvaluationDto> findAll(Pageable pageable){
        return evaluationService.findAll(pageable);

    }

}
