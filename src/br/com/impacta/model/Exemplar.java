package br.com.impacta.model;

import java.util.Calendar;

public abstract class Exemplar {
	private long id;
	private String titulo;
	private String categoria;
	private Calendar anoPublicacao;
	private String tipoPublicacao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Calendar getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(Calendar anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getTipoPublicacao() {
		return tipoPublicacao;
	}
	public void setTipoPublicacao(String tipoPublicacao) {
		this.tipoPublicacao = tipoPublicacao;
	}

}
