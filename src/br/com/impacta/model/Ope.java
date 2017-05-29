package br.com.impacta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Ope")
public class Ope extends Acervo {
	@Column(name = "codigoOpe", unique = true, nullable = false)
	private String codigoOpe;
	private String curso;
	private String turma;
	private String turno;
	private String semestre;
	private String componentes;
	

	public String getCodigoOpe() {
		return codigoOpe;
	}

	public void setCodigoOpe(String codigoOpe) {
		this.codigoOpe = codigoOpe;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getsemestre() {
		return semestre;
	}

	public void setsemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getComponentes() {
		return componentes;
	}

	public void setComponentes(String componentes) {
		this.componentes = componentes;
	}
	
	
}
