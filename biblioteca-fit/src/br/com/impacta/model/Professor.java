package br.com.impacta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Professor")
public class Professor extends Solicitante {
	@Column(name = "re", unique = true, nullable = false)
	private String re;

	public String getRe() {
		return re;
	}
	public void setRe(String re) {
		this.re = re;
	}	
	
}
