package com.quileia.luis3pa.clinica.controller;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quileia.luis3pa.clinica.models.entities.Paciente;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class PacienteControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(PacienteControllerTest.class);

	@Autowired
	MockMvc mockMvc;

	@Test
	@Sql({ "/test-deletePaciente.sql", "/test-import.sql" })
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void getAllPacientesTest() throws Exception {
		logger.info("@getAllPacientesTest");
		String uri = "/paciente/all";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		logger.info("@getAllPacientesTest " + content);

	}

	@Test
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void addNewPacienteTest() throws Exception {
		logger.info("@addNewPacienteTest");
		Paciente paciente = new Paciente("1", "luis", "trespalacios", null, 1);

		String inputJson = mapToJson(paciente);
		String uri = "/paciente/addpaciente";

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		logger.info("@addNewPacienteTest " + content);

	}
	
	@Test
	@Sql("/test-addPaciente.sql")
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void updatePacienteTest() throws Exception {
		logger.info("@updatePacienteTest");
		Paciente paciente = new Paciente("1", "jose", "trespalacios", null, 1);

		String inputJson = mapToJson(paciente);
		String uri = "/paciente/updatepaciente";

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		logger.info("@updatePacienteTest " + content);

	}
	
	@Test
	@Sql("/test-addPaciente.sql")
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void getPacienteIdTest() throws Exception {
		logger.info("@getPacienteIdTest");
		String uri = "/paciente/1";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		logger.info("@getPacienteIdTest " + content);

	}

	
	@Test
	@Sql("/test-addPaciente.sql")
	@Sql(scripts = "/test-deletePaciente.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void deletePacienteTest() throws Exception {
		logger.info("@deletePacienteTest");
		String uri = "/paciente/delete/1";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		logger.info("@deletePacienteTest " + content);

	}
	public String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

}
