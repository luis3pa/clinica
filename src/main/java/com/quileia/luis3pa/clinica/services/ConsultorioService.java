package com.quileia.luis3pa.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quileia.luis3pa.clinica.models.entities.Consultorio;
import com.quileia.luis3pa.clinica.models.repositories.ConsultorioRepository;


@Service
public class ConsultorioService {

	
	@Autowired
	ConsultorioRepository consultorioRepository;
	
	public List<Consultorio> getAllConsultorio() {
		return this.consultorioRepository.findAll();
	}
	
	public Consultorio addConsultorio(Consultorio consultorio) {
		return this.consultorioRepository.save(consultorio);
	}

}
