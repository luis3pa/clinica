package com.quileia.luis3pa.clinica.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quileia.luis3pa.clinica.models.entities.Cita;
import com.quileia.luis3pa.clinica.models.entities.Medico;
import com.quileia.luis3pa.clinica.models.entities.Paciente;
import com.quileia.luis3pa.clinica.models.repositories.CitaReposirory;

@Service
public class CitaService {
	@Autowired
	CitaReposirory citaReposirory;
	@Autowired
	MedicoService medicoService;
	@Autowired
	PacienteService pacienteService;

	public List<Cita> getAllCitas() {
		return this.citaReposirory.findAll();
	}

	public Cita addCita(String idMedico, String idPaciente, Cita cita) {
		Set<Cita> citasMedico = new HashSet<>();
		Set<Cita> citasPaciente = new HashSet<>();
		Medico medicoNew = new Medico();
		Paciente pacienteNew = new Paciente();

		Optional<Medico> byIdMedico = medicoService.getMedicoById(idMedico);
		if (byIdMedico.isPresent()) {
			Medico medico = byIdMedico.get();
			cita.setMedico(medico);
		}
		

		Optional<Paciente> byIdPaciente = pacienteService.getPacienteById(idPaciente);
		if (byIdPaciente.isPresent()) {
			Paciente paciente = byIdPaciente.get();
			cita.setPaciente(paciente);
		}
		

		
		
		Cita citaNew = citaReposirory.save(cita);
		citasMedico.add(citaNew);
		citasPaciente.add(citaNew);
		pacienteNew.setCita(citasPaciente);
		medicoNew.setCita(citasMedico);
		return citaNew;
	}

	public Optional<Cita> getCitaById(int idCita) {
		return this.citaReposirory.findById(idCita);
	}

	public Cita updateCita(Cita cita) {
		return this.citaReposirory.save(cita);
	}
	
	
	public Cita updateCitafirma( String idPaciente, String idCita) {
		return this.citaReposirory.updateFirma( idPaciente, idCita);
	}

	public void deleteCitaById(int idCita) {
		this.citaReposirory.deleteById(idCita);
	}

	public void deleteAllCitas() {
		this.citaReposirory.deleteAll();
	}

	public List<Cita> getCitaUnicoPaciente(String idPaciente) {
		return this.citaReposirory.getCitaUnicoPaciente(idPaciente);
	}

	public List<Cita> getCitaUnicoMedico(String idMedico) {
		return this.citaReposirory.getCitaUnicoMedico(idMedico);
	}
	
	public String getPaciente(int idCita) {
		return this.citaReposirory.getPaciente(idCita);
	}
	
	public void deleteCitaByPaciente(String idPaciente) {
		this.citaReposirory.deleteCitaPaciente(idPaciente);
	}
	
	public void deleteCitaByMedico(String idMedico) {
		this.citaReposirory.deleteCitaMedico(idMedico);
	}
}
