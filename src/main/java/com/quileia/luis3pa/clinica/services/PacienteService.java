package com.quileia.luis3pa.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quileia.luis3pa.clinica.models.entities.Paciente;
import com.quileia.luis3pa.clinica.models.repositories.PacienteReposirory;

@Service
public class PacienteService {

	@Autowired
	PacienteReposirory pacienteReposirory;

	public List<Paciente> getAllPacientes() {
		return this.pacienteReposirory.findAll();
	}

	public Paciente addPaciente(Paciente paciente) {
		return this.pacienteReposirory.save(paciente);
	}

	public Optional<Paciente> getPacienteById(String idPaciente) {
		return this.pacienteReposirory.findById(idPaciente);
	}

	public Paciente updatePaciente(Paciente paciente) {
		return this.pacienteReposirory.save(paciente);
	}

	public void deletePacienteById(String idPaciente) {
		this.pacienteReposirory.deleteById(idPaciente);
	}

	public void deleteAllPacientes() {
		this.pacienteReposirory.deleteAll();
	}

}