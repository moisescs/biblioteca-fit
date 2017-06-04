package br.com.impacta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Aluno")
public class Aluno extends Solicitante{
	@Column(name = "ra", unique = true, nullable = false)
	private String ra; 

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra; 
	}
}
