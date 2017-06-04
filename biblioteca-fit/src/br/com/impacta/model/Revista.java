package br.com.impacta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Revista")
public class Revista extends Acervo {
	@Column(name = "codigoRevista", unique = true, nullable = false)
	private String codigoRevista;
	private String edicao;
	private String editora;
	
	
	public String getCodigoRevista() {
		return codigoRevista;
	}
	public void setCodigoRevista(String codigoRevista) {
		this.codigoRevista = codigoRevista;
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
