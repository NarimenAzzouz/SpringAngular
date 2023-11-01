package com.example.TutoSpring.service.impl.Implementation;

import com.example.TutoSpring.dto.kpis.EvaluationDto;
import com.example.TutoSpring.dto.kpis.PersonneDto;
import com.example.TutoSpring.dto.kpis.SkillsDto;
import com.example.TutoSpring.model.Evaluation;
import com.example.TutoSpring.model.Skills;
import com.example.TutoSpring.repository.EvaluationDao;
import com.example.TutoSpring.service.impl.EvaluationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService {


   @Autowired
    private EvaluationDao evaluationDao;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EvaluationDto save(EvaluationDto evaluationDto) {
        Evaluation evaluation = modelMapper.map(evaluationDto,Evaluation.class);
        Evaluation saved = evaluationDao.save(evaluation);
        return modelMapper.map(saved, EvaluationDto.class);
    }

    @Override
    public EvaluationDto findById(UUID idEval) {
        Evaluation evaluation = evaluationDao.findById(idEval).orElseThrow(()-> new RuntimeException("Evaluation not Found"));
        return modelMapper.map(evaluation,EvaluationDto.class);
    }

    @Override
    public EvaluationDto findByRate(Integer rate) {
        EvaluationDto evaluations = evaluationDao.findByRate(rate);
        return modelMapper.map(evaluations,EvaluationDto.class);
    }

    @Override
    public void Delete(UUID idEval) {

        evaluationDao.deleteById(idEval);

    }

    @Override
    public EvaluationDto update(EvaluationDto evaluationDto, UUID idEval) {
        Optional<Evaluation> EvaluatioOptional = evaluationDao.findById(idEval);
        if(EvaluatioOptional.isPresent()){
            Evaluation evaluation = EvaluatioOptional.get(); // Récupérer l'objet Certification existant
            // Mettre à jour les champs de l'objet Certification avec les valeurs de certificationDto
            evaluation.setRate(evaluationDto.getRate()); // Remplacez "champ1" par le nom de vos champs
            evaluation.setRemarque(evaluationDto.getRemarque()); // Remplacez "champ2" par le nom de vos champs
            evaluation.setCertified(evaluationDto.isCertified()); // Remplacez "champ2" par le nom de vos champs
            evaluation.setPreferance(evaluationDto.getPreferance()); // Remplacez "champ2" par le nom de vos champs
            evaluation.setPersSkills(evaluationDto.getPersSkills()); // Remplacez "champ2" par le nom de vos champs






            Evaluation updated = evaluationDao.save(evaluation);
            return modelMapper.map(updated, EvaluationDto.class);
        } else {
            throw new NoSuchElementException("Evaluation non trouvée avec l'ID: " + idEval);
        }
    }

    @Override
    public Set<EvaluationDto> findAll(Pageable pageable) {
        return evaluationDao.findAll(PageRequest.of(0, 10)).stream().map(el ->modelMapper.map(el, EvaluationDto.class))
                .collect(Collectors.toSet());
    }
    }

