package com.quileia.luis3pa.clinica.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consultorio")
public class Consultorio {
	@Id
	@Column(name = "id_consultorio")
    private int idConsultorio;
	@Column(name = "consultorio")
    private String nombreConsultorio;
	public Consultorio(int idConsultorio, String nombreConsultorio) {
		super();
		this.idConsultorio = idConsultorio;
		this.nombreConsultorio = nombreConsultorio;
	}
	
	public Consultorio() {
		super();
	}

	

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getNombreConsultorio() {
		return nombreConsultorio;
	}

	public void setNombreConsultorio(String nombreConsultorio) {
		this.nombreConsultorio = nombreConsultorio;
	}


}
