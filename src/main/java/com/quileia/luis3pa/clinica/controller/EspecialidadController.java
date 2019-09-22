package com.quileia.luis3pa.clinica.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quileia.luis3pa.clinica.models.entities.Especialidad;
import com.quileia.luis3pa.clinica.services.EspecialidadService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,  RequestMethod.DELETE})
@RequestMapping("/especialidad")
public class EspecialidadController {
	@Autowired
	EspecialidadService especialidadService;
	
	@GetMapping(value = "/getEspecialidad")
	public  List<Especialidad> getAllEspecialidad() {
		return especialidadService.getAllEspecialidad();
	}

	@PostMapping(value = "/addEspecialidad",
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Especialidad addNewEspecialidad(@RequestBody Especialidad especialidad) {
		return this.especialidadService.addEspecialidad(especialidad);
	}
	

}
