package br.com.impacta.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Acervo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Acervo {	
	@Id
	@GeneratedValue
	private long idAcervo;
	private String titulo;
	private String categoria;
	private Calendar anoPublicacao;
	private String tipoPublicacao;
	

	public long getIdAcervo() {
		return idAcervo;
	}
	public void setIdAcervo(long idAcervo) {
		this.idAcervo = idAcervo;
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
