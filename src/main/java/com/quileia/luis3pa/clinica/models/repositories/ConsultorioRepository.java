package com.quileia.luis3pa.clinica.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quileia.luis3pa.clinica.models.entities.Consultorio;

@Repository	
public interface ConsultorioRepository extends JpaRepository<Consultorio, Integer>{

}
