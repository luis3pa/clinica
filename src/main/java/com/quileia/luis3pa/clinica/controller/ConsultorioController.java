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

import com.quileia.luis3pa.clinica.models.entities.Consultorio;
import com.quileia.luis3pa.clinica.services.ConsultorioService;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,  RequestMethod.DELETE})
@RequestMapping("/consultorio")
public class ConsultorioController {
	
	@Autowired
	ConsultorioService consultorioService;
	
	@GetMapping(value = "/getConsultorio")
	public  List<Consultorio> getAllConsultorio() {

		return consultorioService.getAllConsultorio();
	}

	@PostMapping(value = "/addConsultorio", 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public Consultorio addNewConsultorio(@RequestBody Consultorio consultorio) {
		return this.consultorioService.addConsultorio(consultorio);
	}

}
