package br.com.impacta.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.impacta.dao.AtendenteDAO;
import br.com.impacta.dao.OpeDAO;
import br.com.impacta.model.Atendente;
import br.com.impacta.model.Ope;

public class Teste {

	public static void main(String[] args) throws ParseException {
		Atendente a = new Atendente();
		a.setNomeCompleto("Moises silva");
		a.setCpf("123.123.456.-98");
		a.setRe("67666767");
		a.setUsuario("teste");
		a.setSenha("teste");
		AtendenteDAO dao = new AtendenteDAO();
		dao.cadastrar(a);
		
	}

}
