package com.quileia.luis3pa.clinica.models.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "cita")
public class Cita {
	@Id
    @Column(name = "id_cita")
    private int idCita;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Paciente paciente;  
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tar_pro", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Medico medico;
    @Column(name = "fecha_hora")
    private Date fechaHora;
    @Column(name = "valor")
    private int valor;
    @Column(name = "id_asistir")
    private int idAsistir;
    @Column(name = "firma")
    private byte[] firma;
    

	

	public Cita(int idCita, Paciente paciente, Medico medico, Date fechaHora, int valor, int idAsistir,
			byte[] firma) {
		super();
		this.idCita = idCita;
		this.paciente = paciente;
		this.medico = medico;
		this.fechaHora = fechaHora;
		this.valor = valor;
		this.idAsistir = idAsistir;
		this.firma = firma;
	}

	public Cita() {
		
	}

	
	

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getIdAsistir() {
		return idAsistir;
	}

	public void setIdAsistir(int idAsistir) {
		this.idAsistir = idAsistir;
	}

	@JsonIgnore
	public Paciente getPaciente() {
		return paciente;
	}
	@JsonIgnore
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	@JsonIgnore
	public Medico getMedico() {
		return medico;
	}
	@JsonIgnore
	public void setMedico(Medico medico) {
		this.medico = medico;
	}



	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public byte[] getFirma() {
		return firma;
	}

	public void setFirma(byte[] firma) {
		this.firma = firma;
	}
	
	

    
}
