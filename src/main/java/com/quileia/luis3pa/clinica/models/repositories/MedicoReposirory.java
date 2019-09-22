package com.quileia.luis3pa.clinica.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quileia.luis3pa.clinica.models.entities.Medico;

@Repository	
public interface MedicoReposirory extends JpaRepository<Medico, String> {
	@Query(value = "SELECT COUNT(*) FROM  cita,medico WHERE medico.cod_tar_pro= ?1   and fecha_hora between  (select current_date from dual) and fecha_hora",nativeQuery = true)
	int getComprobar ( String idMedico);
	
}
