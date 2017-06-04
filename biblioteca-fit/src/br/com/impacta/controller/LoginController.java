package br.com.impacta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.impacta.dao.AcervoDAO;
import br.com.impacta.dao.AlunoDAO;
import br.com.impacta.dao.AtendenteDAO;
import br.com.impacta.dao.EmprestimoDAO;
import br.com.impacta.dao.FuncionarioDAO;
import br.com.impacta.dao.LivroDAO;
import br.com.impacta.dao.PessoaDAO;
import br.com.impacta.dao.ProfessorDAO;
import br.com.impacta.dao.RevistaDAO;
import br.com.impacta.dao.SolicitanteDAO;
import br.com.impacta.model.Acervo;
import br.com.impacta.model.Aluno;
import br.com.impacta.model.Atendente;
import br.com.impacta.model.Emprestimo;
import br.com.impacta.model.Funcionario;
import br.com.impacta.model.Livro;
import br.com.impacta.model.Pessoa;
import br.com.impacta.model.Professor;
import br.com.impacta.model.Revista;
import br.com.impacta.model.Solicitante;

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
//****************************************Livros*********************************************	
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
	
	
	//********************************************Revistas******************************************************

	@RequestMapping("listarRevista")
	public String listarRevista(Model model){
		RevistaDAO dao = new RevistaDAO();
		List<Revista> revs = dao.listar();
		model.addAttribute("revs", revs);
		return "listarRevista";
	}
	@RequestMapping("formCadRevista")
	public String formCadRevista(){
		return "formCadRevista";
	}

	@RequestMapping("inserirRevista")
	public String inserirRevista(Revista revista) {
		RevistaDAO dao = new RevistaDAO();
		try {
			dao.cadastrar(revista);
		} catch (Exception e) {
			Revista r = new Revista();
			dao.getFactory().close();
			throw new RuntimeException();
		}
		return "ok";
	}
	@RequestMapping("formUpRevista")
	public String formUpRevista(@RequestParam(value="cod", required=true) String cod, HttpServletRequest request, HttpServletResponse response, Model model){
		RevistaDAO dao = new RevistaDAO();
		Revista rev = dao.buscarPorId(cod);
		model.addAttribute("rev", rev);
		return "formUpRevista";
	}
	
	@RequestMapping("alterarRevista")
	public String alterarRevista(Revista revista) {
		RevistaDAO dao = new RevistaDAO();
		dao.alterar(revista);
		return "ok";
	}
	
	@RequestMapping("deletarRevista")
	public String deletarRevista(@RequestParam(value="cod", required=true) String cod, HttpServletRequest request, HttpServletResponse response) throws IOException{
		RevistaDAO dao = new RevistaDAO();
		dao.remover(cod);
		return "redirect:/listarRevista";		
	}
	
	
//###############################Metodos dos Solicitantes#################################	
	@RequestMapping("solicitante")
	public String solicitante(){
		return "solicitante";
	}	
	
	//*************************** Professor*******************************************
	
	@RequestMapping("listarProfessor")
	public String listarProfessor(Model model){
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> profs = dao.listar();
		model.addAttribute("profs", profs);
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
		return "formCadProf";
	}	
	
	@RequestMapping("formUpProf")
	public String formUpProf(@RequestParam(value="re", required=true) String re, HttpServletRequest request, HttpServletResponse response, Model model){
		ProfessorDAO dao = new ProfessorDAO();
		Professor prof = dao.buscarPorRe(re);
		model.addAttribute("prof", prof);
		return "formUpProf";
	}

	@RequestMapping("alterarProf")
	public String alterarProf(Professor prof) {
		ProfessorDAO dao = new ProfessorDAO();
		dao.alterar(prof);
		return "formUpProf";
	}
	
	@RequestMapping("deletarProf")
	public String deletarProf(@RequestParam(value="re", required=true) String re, HttpServletRequest request, HttpServletResponse response) throws IOException{
		ProfessorDAO dao = new ProfessorDAO();
		dao.remover(re);
		return "redirect:/listarProfessor";		
	}
//*******************************************Aluno********************************************************
	@RequestMapping("listarAluno")
	public String listarAluno(Model model){
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> alunos = dao.listar();
		model.addAttribute("alunos", alunos);
		return "listarAluno";
	}
	@RequestMapping("formCadAluno")
	public String formCadAluno(){
		return "formCadAluno";
	}
	@RequestMapping("inserirAluno")
	public String inserirAluno(Aluno a) {
		AlunoDAO dao = new AlunoDAO();
		dao.cadastrar(a);
		dao.getFactory().close();
		return "ok";
	}	
	@RequestMapping("formUpAluno")
	public String formUpAluno(@RequestParam(value="ra", required=true) String ra, HttpServletRequest request, HttpServletResponse response, Model model){
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.buscarPorRa(ra);
		model.addAttribute("aluno", aluno);
		return "formUpAluno";
	}
	@RequestMapping("alterarAluno")
	public String alterarAluno(Aluno a) {
		AlunoDAO dao = new AlunoDAO();
		dao.alterar(a);
		return "ok";
	}
	
	@RequestMapping("deletarAluno")
	public String deletarAluno(@RequestParam(value="ra", required=true) String ra, HttpServletRequest request, HttpServletResponse response) throws IOException{
		AlunoDAO dao = new AlunoDAO();
		dao.remover(ra);
		return "redirect:/listarAluno";		
	}
	
	//*******************************************Funcionário*********************************************************
	@RequestMapping("listarFunc")
	public String listarFunc(Model model){
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcs = dao.listar();
		model.addAttribute("funcs", funcs);
		return "listarFunc";
	}
	@RequestMapping("formCadFunc")
	public String formCadFunc(){
		return "formCadFunc";
	}
	@RequestMapping("inserirFunc")
	public String inserirFunc(Funcionario f) {
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.cadastrar(f);
		dao.getFactory().close();
		return "ok";
	}
	@RequestMapping("formUpFunc")
	public String formUpFunc(@RequestParam(value="re", required=true) String re, HttpServletRequest request, HttpServletResponse response, Model model){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario func = dao.buscarPorRe(re);
		model.addAttribute("func", func);
		return "formUpFunc";
	}
	@RequestMapping("alterarFunc")
	public String alterarFunc(Funcionario f) {
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.alterar(f);
		return "ok";
	}
	@RequestMapping("deletarFunc")
	public String deletarFunc(@RequestParam(value="re", required=true) String re, HttpServletRequest request, HttpServletResponse response) throws IOException{
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.remover(re);
		return "redirect:/listarFunc";		
	}
	
//############################################Metodos do Emprestimos#####################################################

	@RequestMapping("emprestimo")
	public String emprestimo(){
		return "emprestimo";
	}
	
	@RequestMapping("listarEmprestimo")
	public String listarEmprestimo(@RequestParam(value="emp", required=true) boolean emp, HttpServletRequest request, HttpServletResponse response, Model model){
		EmprestimoDAO dao = new EmprestimoDAO();
		List<Emprestimo> emprestimos = dao.listar(emp);
		model.addAttribute("emprestimos", emprestimos);
		return "listarEmprestimo";
	}
	
	@RequestMapping("formEmprestimoLivro")
	public String formEmprestimo(@RequestParam(value="isbn", required=true) String isbn, HttpServletRequest request, HttpServletResponse response, Model model){
		LivroDAO ldao = new LivroDAO();
		Livro livro = ldao.buscarPorIsbn(isbn);
		model.addAttribute("livro", livro);
		return "formEmprestimoLivro";
	}
	
	@RequestMapping("formEmprestimoRevista")
	public String formEmprestimoa(@RequestParam(value="cod", required=true) String cod, HttpServletRequest request, HttpServletResponse response, Model model){
		RevistaDAO rdao = new RevistaDAO();
		Revista livro = rdao.buscarPorId(cod);
		model.addAttribute("livro", livro);
		return "formEmprestimoRevista";
	}
	
	@RequestMapping("emprestarLivro")
	public String emprestarLivro(Acervo a, Solicitante sol){
		SolicitanteDAO s = new SolicitanteDAO();
		boolean autentica = s.existeUsuario(sol);
		if(autentica == true){
			EmprestimoDAO dao = new EmprestimoDAO();
			dao.emprestar(a, sol);
			return "ok";
		}else{
			return "falhaLogin";
		}
	}
	
	@RequestMapping("devolverEmprestimo")
	public String devolverEmprestimo(@RequestParam(value="emp", required=true) int emp, HttpServletRequest request, HttpServletResponse response){
		EmprestimoDAO dao = new EmprestimoDAO();
		dao.devolver(emp);
		return "redirect:/listarEmprestimo?emp=false";		
	}
	
	@RequestMapping("renovarEmprestimo")
	public String renovarEmprestimo(@RequestParam(value="emp", required=true) int emp, HttpServletRequest request, HttpServletResponse response){
		EmprestimoDAO dao = new EmprestimoDAO();
		dao.renovar(emp);
		return "redirect:/listarEmprestimo?emp=false";
	}
}
