package com.quileia.luis3pa.clinica.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quileia.luis3pa.clinica.models.entities.Cita;

@Repository	
public interface CitaReposirory extends JpaRepository<Cita, Integer> {
	@Query(value = "SELECT * FROM  cita WHERE id_paciente = ?1 ",nativeQuery = true)
	List<Cita> getCitaUnicoPaciente ( String idPaciente);
	
	@Query(value = "SELECT * FROM  cita WHERE cita.cod_tar_pro = ?1 ",nativeQuery = true)
	List<Cita> getCitaUnicoMedico ( String idMedico);
	
	@Query(value = "SELECT cita.id_paciente FROM  cita WHERE cita.id_cita = ?1 ",nativeQuery = true)
	String getPaciente ( int idCita);
	
	@Query(value = "delete FROM  cita WHERE cita.id_pacinete = ?1 ",nativeQuery = true)
	void deleteCitaPaciente ( String idPaciente);
	
	@Query(value = "delete FROM  cita WHERE cita.cod_tar_pro = ?1 ",nativeQuery = true)
	void deleteCitaMedico ( String idMedico);
	
	
	@Query(value = "UPDATE cita SET  firma= ?1, id_asistir = 1  WHERE id_paciente= ?2 AND id_cita=?3 ",nativeQuery = true)
	Cita updateFirma (String idPaciente,String idCita);

}
