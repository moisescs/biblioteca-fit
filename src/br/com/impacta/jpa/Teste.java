package br.com.impacta.jpa;

import java.util.ArrayList;
import java.util.List;

import br.com.impacta.dao.AtendenteDAO;
import br.com.impacta.model.Atendente;

public class Teste {

	public static void main(String[] args) {
		Atendente p = new Atendente();
		p.setUsuario("78yu9887878787878787uiuiuiiuui");		
		p.setSenha("aletradodenovao");
		AtendenteDAO dao = new AtendenteDAO();
		
		List<Atendente> lista = new ArrayList<Atendente>();		
		System.out.println(dao.existeUsuario(p));
		
	}

}
