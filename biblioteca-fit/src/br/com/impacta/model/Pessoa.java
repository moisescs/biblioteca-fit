package br.com.impacta.model;


import javax.persistence.*;

@Entity
@Table(name="Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
	@Id
	@GeneratedValue
	private long idPessoa;
	private String nomeCompleto;
	private String logradouro;
	private String numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	
	@Column(name = "usuario", unique = true, nullable = false)
	private String usuario;
	@Column(nullable = false)
	private String senha;
	private boolean bloqueado;
	
	
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nome) {
		this.nomeCompleto = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

} 
