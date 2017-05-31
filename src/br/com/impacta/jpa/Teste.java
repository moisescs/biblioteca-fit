package br.com.impacta.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.impacta.dao.AtendenteDAO;
import br.com.impacta.dao.LivroDAO;
import br.com.impacta.dao.OpeDAO;
import br.com.impacta.model.Atendente;
import br.com.impacta.model.Livro;
import br.com.impacta.model.Ope;

public class Teste {

	public static void main(String[] args) throws ParseException {
		/*
		Atendente a = new Atendente();
		a.setNomeCompleto("teste");
		a.setCpf("000.000.000-00");
		a.setRe("544554");
		a.setUsuario("teste");
		a.setSenha("teste");
		
		AtendenteDAO dao = new AtendenteDAO();
		dao.cadastrar(a);
		*/
		LivroDAO dao = new LivroDAO();
		List<Livro> l = dao.listar();
		for(Livro livro : l){
			
			System.out.println(livro.getTitulo());
			System.out.println(livro.getAnoPublicacao());
			System.out.println(livro.isDeletado());
			System.out.println("#########################################");
		}
		
		
	}

}
