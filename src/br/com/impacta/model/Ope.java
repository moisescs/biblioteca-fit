package br.com.impacta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="Ope")
public class Ope extends Acervo {
	@Column(name = "idOpe", unique = true, nullable = false)
	@GeneratedValue
	private long idOpe;
	private String Turma;

	public long getIdOpe() {
		return idOpe;
	}

	public void setIdOpe(long idOpe) {
		this.idOpe = idOpe;
	}

	public String getTurma() {
		return Turma;
	}

	public void setTurma(String turma) {
		Turma = turma;
	}
}
