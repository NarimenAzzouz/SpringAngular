package com.example.TutoSpring.controller.Api;

import com.example.TutoSpring.dto.kpis.EvaluationDto;
import com.example.TutoSpring.dto.kpis.SkillsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@Api("/evaluation")
public interface EvaluationApi {
    @PostMapping(value = "/evaluation/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un evaluataion",notes = "cette methode permet d'enregistrer ou modifier un evaluataion" , response = EvaluationDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "l'object evaluataion crier / modifier"),
            @ApiResponse(code=400,message = "l'object evaluataion n'est pas valid")
    })
    EvaluationDto save(@RequestBody EvaluationDto evaluationDto);

    @GetMapping(value = "/evaluation/{idEval}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un evaluataion par ID",notes = "cette methode permet de chercher un evaluataion par son ID " , response = EvaluationDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le evaluataion a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun evaluataion n'a ete trouve dans la BDD avec l'ID fournit")

    })
    EvaluationDto findById(@PathVariable("idEval") UUID idEval);

    @GetMapping(value = "/evaluation/{Rate}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un evaluataion par Rate",notes = "cette methode permet de chercher un evaluataion par son rate " , response = EvaluationDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le evaluataion a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun evaluataion n'a ete trouve dans la BDD avec le rate fournit")

    })
    EvaluationDto findByRate(@PathVariable("rate") Integer rate);

    @DeleteMapping(value = "/evaluation/{idEval}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer un evaluataion",notes = "cette methode permet de supprimer un evaluataion par ID " )
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le evaluataion a ete trouve supprimer")
    })
    void Delete(@PathVariable("idEval") UUID idEval);

    @GetMapping(value = "/evaluation/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvoi la liste de evaluataion",notes = "cette methode permet de chercher et revoyer la liste de evaluataion qui existe dans la BDD " , responseContainer = "Set<EvaluationDto>")
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "la liste de evaluataion / une liste vide"),

    })
    Set<EvaluationDto> findAll(Pageable pageable);
}
