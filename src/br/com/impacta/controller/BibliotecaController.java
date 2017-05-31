package br.com.impacta.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BibliotecaController {
	/*
	@RequestMapping("")
	public String index(){
		System.out.println("redirecionando!!");
		return "menu";
	}
	@RequestMapping("home")
	public String home(){
		return "tarefa/home";
	}
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	*/
	/*
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}		
		//TarefaDAO dao = new TarefaDAO();
		//dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	*/
}
