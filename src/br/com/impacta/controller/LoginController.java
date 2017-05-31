package br.com.impacta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.impacta.dao.AtendenteDAO;
import br.com.impacta.dao.LivroDAO;
import br.com.impacta.dao.ProfessorDAO;
import br.com.impacta.dao.SolicitanteDAO;
import br.com.impacta.model.Atendente;
import br.com.impacta.model.Livro;
import br.com.impacta.model.Professor;

@Controller
public class LoginController {
	
	@RequestMapping(value = {"", "index"})
	public String index(){
		return "index";
	}
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}

	
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Atendente atendente, HttpSession session){
		if(new AtendenteDAO().existeUsuario(atendente)){
			session.setAttribute("usuarioLogado", atendente);
			return "index";			
		} 
		return "redirect:loginForm";
	}
	

	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginForm";		
	}
	
//#############################Metodos do Acervo#######################################3
	
	@RequestMapping("acervo")
	public String acervo(){
		return "acervo";
	}
	@RequestMapping("listarLivro")
	public String listarLivro(Model model){
		LivroDAO dao = new LivroDAO();
		List<Livro> livros = dao.listar();
		model.addAttribute("livros", livros);
		return "listarLivro";
	}
	
	@RequestMapping("formCadLivro")
	public String formCadLivro(){
		return "formCadLivro";
	}

	@RequestMapping("inserirLivro")
	public String inserirLivro(Livro livro) {
		LivroDAO dao = new LivroDAO();
		try {
			dao.cadastrar(livro);
		} catch (Exception e) {
			Livro l = new Livro();
			dao.getFactory().close();
			throw new RuntimeException();
		}
		return "formCadLivro";
	}
	
	@RequestMapping("formUpLivro")
	public String formUpLivro(@RequestParam(value="isbn", required=true) String isbn, HttpServletRequest request, HttpServletResponse response, Model model){
		LivroDAO dao = new LivroDAO();
		Livro livro = dao.buscarPorIsbn(isbn);
		model.addAttribute("livro", livro);
		return "formUpLivro";
	}

	@RequestMapping("alterarLivro")
	public String alterarLivro(Livro livro) {
		LivroDAO dao = new LivroDAO();
		dao.alterar(livro);
		return "formUpLivro";
	}
	
	@RequestMapping("deletarLivro")
	public String deletarLivro(@RequestParam(value="isbn", required=true) String isbn, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LivroDAO dao = new LivroDAO();
		dao.remover(isbn);
		return "redirect:/listarLivro";		
	}
	
//###############################Metodos dos Solicitantes#################################	
	@RequestMapping("solicitante")
	public String solicitante(){
		return "solicitante";
	}	
	
	@RequestMapping("listarProfessor")
	public String listarProfessor(Model model){
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> prof = dao.listar();
		model.addAttribute("prof", prof);
		return "listarProfessor";
	}
	
	@RequestMapping("formCadProf")
	public String formCadProf(Model model){
		return "formCadProf";
	}
	
	@RequestMapping("inserirProf")
	public String inserirProf(Professor prof) {
		ProfessorDAO dao = new ProfessorDAO();
		dao.cadastrar(prof);
		dao.getFactory().close();
		return "formCadLivro";
	}	
	
}
