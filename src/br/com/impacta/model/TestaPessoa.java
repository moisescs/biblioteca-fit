package br.com.impacta.model;

import br.com.impacta.dao.AtendenteDAO;
import br.com.impacta.dao.PessoaDAO;

public class TestaPessoa {

	public static void main(String[] args) {
		Pessoa p = new Atendente();
		p.setUsuario("teste1");
		p.setSenha("teste");
		
		PessoaDAO dao = new AtendenteDAO();
		//System.out.println(dao.existeUsuario(p));

	}

}
