package br.com.impacta.model;

public class Revista extends Exemplar {
	
	private String edicao;
	private String editora;
	
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
