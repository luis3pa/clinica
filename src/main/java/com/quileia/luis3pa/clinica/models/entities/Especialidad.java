package com.quileia.luis3pa.clinica.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad {
	@Id
	@Column(name = "id_especialidad")
    private int idEspecialidad;
	@Column(name = "especialidad")
    private String nombreEspecialidad;
	public Especialidad(int idEspecialidad, String nombreEspecialidad) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
	}
	
	public Especialidad() {
		super();
	}
	

	
	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	
	
	
}
