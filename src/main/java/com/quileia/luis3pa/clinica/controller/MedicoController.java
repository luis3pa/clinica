package com.quileia.luis3pa.clinica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quileia.luis3pa.clinica.models.entities.Medico;
import com.quileia.luis3pa.clinica.services.MedicoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	MedicoService medicoService;

	@GetMapping(value = "/all")
	public List<Medico> getAllMedicos() {
		return medicoService.getAllMedicos();
	}

	@PostMapping(value = "/addmedico", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Medico addNewMedico(@RequestBody Medico medico) {
		return this.medicoService.addMedico(medico);
	}

	@PutMapping(value = "/updatepaciente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Medico updateUser(@RequestBody Medico medico) {
		return this.medicoService.updateMedico(medico);
	}

	@GetMapping(value = "/{id}")
	public Optional<Medico> getMedicoId(@PathVariable("id") String idMedico) {
		return this.medicoService.getMedicoById(idMedico);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteMedico(@PathVariable("id") String idMedico) {
		this.medicoService.deleteMedicoById(idMedico);
	}

	@GetMapping(value = "/comprobar/{id}")
	public int getComprobar(@PathVariable("id") String idMedico) {
		return medicoService.getComprobar(idMedico);
	}

}
