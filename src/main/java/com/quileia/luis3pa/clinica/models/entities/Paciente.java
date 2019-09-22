package com.quileia.luis3pa.clinica.models.entities;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "paciente")
public class Paciente {
	@Id
	@Column(name = "id_paciente")
	private String idPaciente;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "fecha ")
	private Date fecha;
	@Column(name = "id_tratamiento ")
	private int idTratamiento;
	
	 @OneToMany(fetch = FetchType.LAZY,mappedBy="paciente",cascade = CascadeType.ALL)
	 private Set<Cita> cita  = new HashSet<>();
	
 
    public Paciente(String idPaciente, String nombre, String apellido, Date fecha, int idTratamiento) {
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha = fecha;
		this.idTratamiento = idTratamiento;
	}

	public Paciente() {
    }

	public String getIdPaciente() {
		return idPaciente;
	}



	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}



	public int getIdTratamiento() {
		return idTratamiento;
	}



	public void setIdTratamiento(int idTratamiento) {
		this.idTratamiento = idTratamiento;
	}



	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@JsonIgnore
	public Set<Cita> getCita() {
		return cita;
	}


	@JsonIgnore
	public void setCita(Set<Cita> cita) {
		this.cita = cita;
	}

	
	

}