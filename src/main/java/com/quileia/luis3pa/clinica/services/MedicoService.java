package com.quileia.luis3pa.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quileia.luis3pa.clinica.models.entities.Medico;
import com.quileia.luis3pa.clinica.models.repositories.MedicoReposirory;

@Service
public class MedicoService {
	@Autowired
	MedicoReposirory medicoReposirory;

	public List<Medico> getAllMedicos() {
		return this.medicoReposirory.findAll();
	}

	public Medico addMedico(Medico medico) {
		return this.medicoReposirory.save(medico);
	}

	public Optional<Medico> getMedicoById(String idMedico) {
		return this.medicoReposirory.findById(idMedico);
	}

	public Medico updateMedico(Medico medico) {
		return this.medicoReposirory.save(medico);
	}

	public void deleteMedicoById(String idMedico) {
		this.medicoReposirory.deleteById(idMedico);
	}

	public void deleteAllMedicos() {
		this.medicoReposirory.deleteAll();
	}

	public int getComprobar(String idMedico) {
		return this.medicoReposirory.getComprobar(idMedico);
	}


}
