package com.example.TutoSpring.service.impl.Implementation;

import com.example.TutoSpring.dto.kpis.CategoryDto;
import com.example.TutoSpring.dto.kpis.PersonneDto;
import com.example.TutoSpring.model.Personne;
import com.example.TutoSpring.model.TypeEmploy;
import com.example.TutoSpring.repository.PersonneDao;
import com.example.TutoSpring.service.impl.PersonneService;
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
public class PersonneServiceImpl implements PersonneService {


    @Autowired
    private PersonneDao personneDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PersonneDto save(PersonneDto personneDto) {
        Personne personne = modelMapper.map(personneDto,Personne.class);
        Personne saved = personneDao.save(personne);
        return modelMapper.map(saved, PersonneDto.class);
    }

    @Override
    public PersonneDto findById(UUID idPers) {
        Personne personne = personneDao.findById(idPers).orElseThrow(()-> new RuntimeException("Personne not Found"));
        return modelMapper.map(personne,PersonneDto.class);
    }

    @Override
    public PersonneDto findByTypeEmploy(TypeEmploy typeEmploy) {
        PersonneDto personne = personneDao.findByTypeEmploy(typeEmploy);
        return modelMapper.map(personne,PersonneDto.class);
    }

    @Override
    public void Delete(UUID idPers) {

        personneDao.deleteById(idPers);

    }

    @Override
    public PersonneDto update(PersonneDto personneDto, UUID idPers) {
        Optional<Personne> personneOptional = personneDao.findById(idPers);
        if(personneOptional.isPresent()){
            Personne personne = personneOptional.get(); // Récupérer l'objet Certification existant
            // Mettre à jour les champs de l'objet Certification avec les valeurs de certificationDto
            personne.setNom(personneDto.getNom()); // Remplacez "champ1" par le nom de vos champs
            personne.setPrenom(personneDto.getPrenom()); // Remplacez "champ2" par le nom de vos champs
            personne.setTypeEmploy(personneDto.getTypeEmploy()); // Remplacez "champ2" par le nom de vos champs




            Personne updated = personneDao.save(personne);
            return modelMapper.map(updated, PersonneDto.class);
        } else {
            throw new NoSuchElementException("Personne non trouvée avec l'ID: " + idPers);
        }
    }

    @Override
    public Set<PersonneDto> findAll(Pageable pageable) {
        return personneDao.findAll(PageRequest.of(0, 10)).stream().map(el ->modelMapper.map(el,PersonneDto.class))
                .collect(Collectors.toSet());
    }
    }

