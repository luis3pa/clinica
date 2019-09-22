package com.quileia.luis3pa.clinica.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;


import com.quileia.luis3pa.clinica.models.entities.Paciente;


@RunWith(SpringRunner.class)
@SpringBootTest
@SpringJUnitConfig
//@TestPropertySource(locations = "classpath:db-test.properties")
public class PacienteServiceTest {
	
	@Autowired
	PacienteService pacienteService;
	

	private static final Logger logger = LoggerFactory.getLogger(PacienteServiceTest.class);
	Paciente paciente;
	
	@Before
	public void setup() {
		logger.info("@before");
		paciente = new Paciente("1","luis","trespalacios",null,1);

	}
	
	@After
	public void tearDown() {
		logger.info("@After");
	}
	
	@Test
	@Sql({"/test-deletePaciente.sql","/test-import.sql"})
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase =ExecutionPhase.AFTER_TEST_METHOD)
    public void getAllPacientesTest() {
		logger.info("@getAllPacientesTest "+pacienteService.getAllPacientes().size());
		List<Paciente> listPaciente = pacienteService.getAllPacientes();
        assertEquals(3, listPaciente.size());   
        assertEquals("trespalacios", listPaciente.get(0).getApellido());
    }
	
	@Test
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase =ExecutionPhase.AFTER_TEST_METHOD)
    public void addPacienteTest() {
		logger.info("@addPacienteTest");	
		
		Paciente newPaciente = pacienteService.addPaciente(paciente);
		
        assertEquals(paciente.getIdPaciente(), newPaciente.getIdPaciente());
        assertEquals(paciente.getApellido(), newPaciente.getApellido());
        assertEquals(paciente.getNombre(), newPaciente.getNombre());
        assertEquals(paciente.getIdTratamiento(), newPaciente.getIdTratamiento());
    }

	@Test
	@Sql("/test-addPaciente.sql")
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase =ExecutionPhase.AFTER_TEST_METHOD)
    public void getPacienteByIdTest() {
		String idPaciente = "1";
        assertEquals(idPaciente, pacienteService.getPacienteById(idPaciente).get().getIdPaciente());
    }
	
	
	@Test
	@Sql("/test-addPaciente.sql")
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase =ExecutionPhase.AFTER_TEST_METHOD)
    public void updatePacienteTest() {
		logger.info("@updatePacienteTest");
		
		List<Paciente> listPaciente = pacienteService.getAllPacientes();		
		listPaciente.get(0).setApellido("torres");
		Paciente updatePaciente = pacienteService.updatePaciente(listPaciente.get(0));
		
        assertEquals(listPaciente.get(0).getIdPaciente(), updatePaciente.getIdPaciente());       
        assertEquals("torres", updatePaciente.getApellido());
    }

	@Test
	@Sql("/test-addPaciente.sql")
    public void deletePacienteByIdTest() {
		logger.info("@deletePacienteByIdTest");
		List<Paciente> listPaciente = pacienteService.getAllPacientes();		
		
		String idPaciente = "1";
        assertEquals(idPaciente, listPaciente.get(0).getIdPaciente());
        pacienteService.deletePacienteById(idPaciente);
        List<Paciente> listPacientenula = pacienteService.getAllPacientes();	
        assertTrue(listPacientenula.isEmpty());    
        
    }


}
