package com.example.TutoSpring.controller.Api;

import com.example.TutoSpring.dto.kpis.CategoryDto;
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

@Api("/category")
public interface CategoryApi {

    @PostMapping(value = "/category/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer une Category",notes = "cette methode permet d'enregistrer ou modifier une Category" , response = CategoryDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "l'object Category crier / modifier"),
            @ApiResponse(code=400,message = "l'object Category n'est pas valid")
    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = "/category/{idCategory}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une Category par ID",notes = "cette methode permet de chercher une Category par son ID " , response = CategoryDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le Category a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun Category n'a ete trouve dans la BDD avec l'ID fournit")

    })
    CategoryDto findById(@PathVariable("idCategory") UUID idCategory);

    @DeleteMapping(value = "/category/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer une Category",notes = "cette methode permet de supprimer une Category par ID " )
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le Category a ete trouve supprimer")
    })
    void Delete(@PathVariable("idCategory") UUID idCategory);

    @GetMapping(value = "/category/{description}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une Category par description",notes = "cette methode permet de chercher une Category par son description " , response = CategoryDto.class)
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "le Category a ete trouve dans le BDD"),
            @ApiResponse(code=404,message = "aucun Category n'a ete trouve dans la BDD avec le description fournit")
    })
    CategoryDto findByDescription(@PathVariable("description") String description);

    /*@Override
        public SkillsDto update(SkillsDto skillsDto, UUID idSki){
            return skillsService.update(skillsDto,idSki);
        }*/
    @GetMapping(value = "/category/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvoi la liste de Category",notes = "cette methode permet de chercher et revoyer la liste de Category qui existe dans la BDD " , responseContainer = "Set<CategoryDto>")
    @ApiResponses( value = {
            @ApiResponse(code=200,message = "la liste de Category / une liste vide"),
    })
    Set<CategoryDto> findAll(Pageable pageable);
}
