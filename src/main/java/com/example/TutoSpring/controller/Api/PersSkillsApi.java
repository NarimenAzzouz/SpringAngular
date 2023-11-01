package com.example.TutoSpring.controller.Api;

import com.example.TutoSpring.dto.kpis.PersSkillsDto;
import com.example.TutoSpring.dto.kpis.SkillsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;
import java.util.UUID;

@Api("/persSkills")
public interface PersSkillsApi {
    @GetMapping(value = "/persSkills/{idPers_Skill}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un persSkills par ID",notes = "cette methode permet de chercher un persSkills par son ID " , response = PersSkillsDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le persSkills a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun persSkills n'a ete trouve dans la BDD avec l'ID fournit")

    })
    PersSkillsDto findById(UUID idPers_Skill);

    @GetMapping(value = "/persSkills/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvoi la liste de persSkills",notes = "cette methode permet de chercher et revoyer la liste de persSkills qui existe dans la BDD " , responseContainer = "Set<PersSkillsDto>")
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "la liste de PersSkillsDto / une liste vide"),

    })
    Set<PersSkillsDto> findAll(Pageable pageable);
}
