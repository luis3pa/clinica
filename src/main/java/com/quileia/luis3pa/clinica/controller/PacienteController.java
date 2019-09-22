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

import com.quileia.luis3pa.clinica.models.entities.Paciente;
import com.quileia.luis3pa.clinica.services.PacienteService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,  RequestMethod.DELETE})
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	PacienteService pacienteService;
	 
	@GetMapping(value = "/all")
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

	@PostMapping(value = "/addpaciente",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Paciente addNewPaciente(@RequestBody Paciente paciente) {
        return this.pacienteService.addPaciente(paciente);
    }
    
    @PutMapping(value = "/updatepaciente",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Paciente updateUser(@RequestBody Paciente paciente) {
        return this.pacienteService.updatePaciente(paciente);
    }
    
    @GetMapping(value = "/{id}")
	public Optional<Paciente> getpacienteId(@PathVariable ("id") String idPaciente)  {
		return this.pacienteService.getPacienteById(idPaciente);
	}

    @DeleteMapping(value = "/delete/{id}")
	public void deletePaciente(@PathVariable ("id") String idPaciente) {
		this.pacienteService.deletePacienteById(idPaciente);
	}
    
    
    
}
