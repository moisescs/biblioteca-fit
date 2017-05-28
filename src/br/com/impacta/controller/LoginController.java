package br.com.impacta.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("")
	public String loginForm(){
		return "formulario-login";
	}

	/*
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Atendente atendente, HttpSession session){
		if(new AtendenteDAO().existeUsuario(atendente)){
			session.setAttribute("usuarioLogado", atendente);
			return "index";			
		} 
		return "redirect:loginForm";
	}
	*/

	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginForm";		
	}
	
	@RequestMapping("index")
	public String teste(){
		return "index";		
	}
	
	@RequestMapping("cad-exemplar")
	public String cadexemplar(){
		return "form-cad-exemplar";
	}
}
