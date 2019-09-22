package com.quileia.luis3pa.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quileia.luis3pa.clinica.models.entities.Especialidad;
import com.quileia.luis3pa.clinica.models.repositories.EspecialidadRepository;

@Service
public class EspecialidadService {
	
	@Autowired
	EspecialidadRepository especialidadRepository;
	
	public List<Especialidad> getAllEspecialidad() {
		return this.especialidadRepository.findAll();
	}
	
	public Especialidad addEspecialidad(Especialidad especialidad) {
		return this.especialidadRepository.save(especialidad);
	}

	
}
