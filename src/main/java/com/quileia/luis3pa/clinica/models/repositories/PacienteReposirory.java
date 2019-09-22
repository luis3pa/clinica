package com.quileia.luis3pa.clinica.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quileia.luis3pa.clinica.models.entities.Paciente;

@Repository	
public interface PacienteReposirory  extends JpaRepository<Paciente, String>{

}
