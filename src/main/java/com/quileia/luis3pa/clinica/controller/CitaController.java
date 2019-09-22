package com.quileia.luis3pa.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quileia.luis3pa.clinica.models.entities.Cita;
import com.quileia.luis3pa.clinica.services.CitaService;

@RestController
@RequestMapping("/cita")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class CitaController {
	@Autowired
	CitaService citaService;

	@GetMapping(value = "/all")
	public List<Cita> getAllCitas() {
		return citaService.getAllCitas();
	}

	@PostMapping(value = "/{cod_tar_pro}/{id_paciente}/addcita", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cita addNewCita(@PathVariable(value = "cod_tar_pro") String codTarPro,
			@PathVariable(value = "id_paciente") String idPaciente, @RequestBody Cita cita) {

		return this.citaService.addCita(codTarPro, idPaciente, cita);
	}
	
	@PostMapping(value = "/{id_cita}/{id_paciente}/firma", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cita updateFirma(@PathVariable(value = "id_cita") String idCita,
			@PathVariable(value = "id_paciente") String idPaciente) {

		return this.citaService.updateCitafirma( idPaciente, idCita);
	}

	@GetMapping(value = "/unicopaciente/{id}")
	public List<Cita> getCitaUnicoPaciente(@PathVariable("id") String idPaciente) {

		return citaService.getCitaUnicoPaciente(idPaciente);
	}

	@GetMapping(value = "/unicomedico/{id}")
	public List<Cita> getCitaUnicoMedico(@PathVariable("id") String idMedico) {
		return citaService.getCitaUnicoMedico(idMedico);
	}
	
	@GetMapping(value = "/getPaciente/{id}")
	public String getPaciente(@PathVariable("id") int idCita) {
		return citaService.getPaciente(idCita);
	}
	
	
	@DeleteMapping(value = "/delete/citamedico/{id}")
	public void deleteMedico(@PathVariable ("id") String idPaciente) {
		this.citaService.deleteCitaByMedico(idPaciente);
	}
	
	@DeleteMapping(value = "/delete/citapaciente/{id}")
	public void deletePaciente(@PathVariable ("id") String idPaciente) {
		this.citaService.deleteCitaByPaciente(idPaciente);
	}

}
