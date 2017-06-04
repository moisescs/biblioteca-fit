package br.com.impacta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Atendente")
public class Atendente extends Pessoa{
	@Column(name = "cpf", unique = true, nullable = false)
	private String cpf;
	private String rg;
	
	@Column(name = "re", unique = true, nullable = false)
	private String re;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getRe() {
		return re;
	}
	public void setRe(String re) {
		this.re = re;
	}
	
}
