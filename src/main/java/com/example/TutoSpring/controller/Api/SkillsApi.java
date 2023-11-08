package com.example.TutoSpring.controller.Api;

import com.example.TutoSpring.dto.kpis.SkillsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Set;
import java.util.UUID;

@Api("/skills")
public interface SkillsApi {
    @PostMapping(value = "/skills/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un skill",notes = "cette methode permet d'enregistrer ou modifier un skill" , response = SkillsDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "l'object skill crier / modifier"),
            @ApiResponse(code=400,message = "l'object skill n'est pas valid")
    })
    SkillsDto save(@RequestBody SkillsDto skillsDto);

    @GetMapping(value = "/skills/{idSki}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un skill par ID",notes = "cette methode permet de chercher un skill par son ID " , response = SkillsDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le skill a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun skill n'a ete trouve dans la BDD avec l'ID fournit")

    })
    SkillsDto findById(@PathVariable("idSki") UUID idSki);

    @DeleteMapping(value = "/skills/{idSki}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer un Skill",notes = "cette methode permet de supprimer un Skill par ID " )
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le skill a ete trouve supprimer")
    })
    void Delete(@PathVariable("idSki") UUID idSki);


    @GetMapping(value = "/skills/{nomSkills}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un skill par Nom",notes = "cette methode permet de chercher un skill par son nom " , response = SkillsDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le skill a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun skill n'a ete trouve dans la BDD avec le Nom fournit")

    })
    SkillsDto findByNomSkills(@PathVariable("nomSkills") String nomSkills);




    @GetMapping(value = "/skills/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvoi la liste de Skills",notes = "cette methode permet de chercher et revoyer la liste de Skills qui existe dans la BDD " , responseContainer = "Set<SkillsDto>")
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "la liste de Skills / une liste vide"),

    })
    Set<SkillsDto> findAll(Pageable pageable);
}
