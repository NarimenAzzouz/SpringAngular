package com.example.TutoSpring.repository;

import com.example.TutoSpring.dto.kpis.PersonneDto;
import com.example.TutoSpring.model.Personne;
import com.example.TutoSpring.model.TypeEmploy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonneDao extends JpaRepository<Personne, UUID> {

   PersonneDto findByTypeEmploy(TypeEmploy typeEmploy);

}
