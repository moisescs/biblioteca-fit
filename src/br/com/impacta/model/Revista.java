package br.com.impacta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="Revista")
public class Revista extends Acervo {
	@Column(name = "idRevista", unique = true, nullable = false)
	@GeneratedValue
	private long idRevista;
	private String edicao;
	private String editora;
	
		
	public long getIdRevista() {
		return idRevista;
	}
	public void setIdRevista(long idRevista) {
		this.idRevista = idRevista;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}	
}
