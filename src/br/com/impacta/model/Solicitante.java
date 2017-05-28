package br.com.impacta.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Solicitante")
public abstract class Solicitante extends Pessoa {

	private String tipoSolicitante;
	private int qtdLivro;
	private int qtdRevista;
	private int qtdDia;
	
	
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	public int getQtdLivro() {
		return qtdLivro;
	}

	public void setQtdLivro(int qtdLivro) {
		this.qtdLivro = qtdLivro;
	}

	public int getQtdRevista() {
		return qtdRevista;
	}

	public void setQtdRevista(int qtdRevista) {
		this.qtdRevista = qtdRevista;
	}

	public int getQtdDia() {
		return qtdDia;
	}

	public void setQtdDia(int qtdDia) {
		this.qtdDia = qtdDia;
	}
	
}
