package br.com.impacta.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Emprestimo")
public class Emprestimo {	
	@Id
	@GeneratedValue
	private long idEmprestimo;
	@ManyToOne
	@JoinColumn(name="idPessoa")
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name="idAcervo")
	private Acervo acervo;
	@Temporal(TemporalType.DATE)
	private Calendar dataEmprestimo;
	@Temporal(TemporalType.DATE)
	private Calendar dataDevolucao;
	@Temporal(TemporalType.DATE)
	private Calendar dataPrevistaDevolucao;
	private boolean status;
	
	public long getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Acervo getAcervo() {
		return acervo;
	}
	public void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Calendar getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}
	public void setDataPrevistaDevolucao(Calendar dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}	
}
