package com.quileia.luis3pa.clinica.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {
	@Column(name = "cod_tar_pro")
	@Id
	private String codTarPro;
	@Column(name = "anios_experiencia")
	private Number aniosExperiencia;
	@Column(name = "id_especialidad")
	private int idEspecialidad;
	@Column(name = "id_consultorio")
	private int idConsultorio;
	@Column(name = "eps")
	private String eps;
	@Column(name = "id_atiende")
	private int idAtiende;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medico", cascade = CascadeType.ALL)
	private Set<Cita> cita = new HashSet<>();

	public Medico(String codTarPro, Number aniosExperiencia, int idEspecialidad, int idConsultorio, String eps,
			int idAtiende, Set<Cita> cita) {
		super();
		this.codTarPro = codTarPro;
		this.aniosExperiencia = aniosExperiencia;
		this.idEspecialidad = idEspecialidad;
		this.idConsultorio = idConsultorio;
		this.eps = eps;
		this.idAtiende = idAtiende;
		this.cita = cita;
	}

	public Medico() {
	}

	public String getCodTarPro() {
		return codTarPro;
	}

	public void setCodTarPro(String codTarPro) {
		this.codTarPro = codTarPro;
	}

	public Number getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(Number aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public int getIdAtiende() {
		return idAtiende;
	}

	public void setIdAtiende(int idAtiende) {
		this.idAtiende = idAtiende;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public Set<Cita> getCita() {
		return cita;
	}

	public void setCita(Set<Cita> cita) {
		this.cita = cita;
	}

}
