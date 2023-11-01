package com.example.TutoSpring.controller.Api;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.dto.kpis.PersonneDto;
import com.example.TutoSpring.model.Personne;
import com.example.TutoSpring.model.TypeEmploy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@Api("/personne")
public interface PersonneApi {


    @PostMapping(value = "/personne/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer une Personne",notes = "cette methode permet d'enregistrer ou modifier une Personne" , response = PersonneDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "l'object Personne crier / modifier"),
            @ApiResponse(code=400,message = "l'object Personne n'est pas valid")
    })
    PersonneDto save(@RequestBody PersonneDto personneDto);

    @GetMapping(value = "/personne/{idPers}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une Personne par ID",notes = "cette methode permet de chercher une Personne par son ID " , response = PersonneDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le Personne a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun Personne n'a ete trouve dans la BDD avec l'ID fournit")

    })
    PersonneDto findById(@PathVariable("idPers") UUID idPers);

    @GetMapping(value = "/personne/{typeEmploy}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une Personne par son type ",notes = "cette methode permet de chercher une Personne par son type " , response = PersonneDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le Personne a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun Personne n'a ete trouve dans la BDD avec le description fournit")
    })
    PersonneDto findByTypeEmploy(@PathVariable("typeEmploy") TypeEmploy typeEmploy);

    @DeleteMapping(value = "/personne/{idPers}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer une Personne",notes = "cette methode permet de supprimer une Personne par ID " )
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le Personne a ete trouve supprimer")
    })
    void Delete(@PathVariable("idPers") UUID idPers);

    @GetMapping(value = "/personne/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvoi la liste des Personnes",notes = "cette methode permet de chercher et revoyer la liste des Personnes qui existe dans la BDD " , responseContainer = "Set<PersonneDto>")
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "la liste des Personnes / une liste vide"),

    })
    Set<PersonneDto> findAll(Pageable pageable);
}
