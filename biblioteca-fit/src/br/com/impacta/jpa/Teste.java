package br.com.impacta.jpa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.impacta.dao.AtendenteDAO;
import br.com.impacta.dao.EmprestimoDAO;
import br.com.impacta.dao.LivroDAO;
import br.com.impacta.dao.ProfessorDAO;
import br.com.impacta.model.Acervo;
import br.com.impacta.model.Aluno;
import br.com.impacta.model.Atendente;
import br.com.impacta.model.Emprestimo;
import br.com.impacta.model.Livro;
import br.com.impacta.model.Pessoa;
import br.com.impacta.model.Professor;

public class Teste {

	public static void main(String[] args) throws ParseException {
	
		Atendente a = new Atendente();
		a.setNomeCompleto("teste");
		a.setCpf("000.000.000-00");
		a.setRe("544554");
		a.setUsuario("teste");
		a.setSenha("teste");
		
		AtendenteDAO dao = new AtendenteDAO();
		dao.cadastrar(a);
		
		
		/*
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> prof = dao.listar();
		for(Professor p : prof){
			System.out.println(p.getNomeCompleto());
			System.out.println(p.getRe());
		}
		*/
		/*
		ProfessorDAO dao = new ProfessorDAO();
		Professor prof = dao.buscarPorRe("454545");
		
		System.out.println(prof.getNomeCompleto());
		prof.getRe();
		*/

		/*
		Acervo a = new Livro();
		Pessoa p = new Professor();
		a.setIdAcervo(1);
		p.setIdPessoa((long)2);
		Emprestimo e = new Emprestimo();
		e.setAcervo(a);
		e.setPessoa(p);
		
		Calendar dataDevolucao = Calendar.getInstance();
		dataDevolucao.add(Calendar.DATE, +7);
		
		e.setDataDevolucao(dataDevolucao);
		Calendar dataEmprestimo = Calendar.getInstance();
		e.setDataEmprestimo(dataEmprestimo);		
		e.setStatus(false);		
		
		EmprestimoDAO dao = new EmprestimoDAO();
		List<Emprestimo> lista =  dao.listar();
		
		for(Emprestimo e : lista){
			System.out.println("Nome " + e.getPessoa().getNomeCompleto());
			System.out.println("Livro " + e.getAcervo().getTitulo());
		}

*/
	}


}
