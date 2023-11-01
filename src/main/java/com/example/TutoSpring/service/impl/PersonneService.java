package com.example.TutoSpring.service.impl;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.dto.kpis.PersonneDto;
import com.example.TutoSpring.model.TypeEmploy;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.UUID;

public interface PersonneService {

    PersonneDto save(PersonneDto personneDto);

    PersonneDto findById(UUID idPers);

    PersonneDto findByTypeEmploy(TypeEmploy typeEmploy);

    void Delete(UUID idPers);


    PersonneDto update(PersonneDto personneDto, UUID idPers);

    Set<PersonneDto> findAll(Pageable pageable);
}
