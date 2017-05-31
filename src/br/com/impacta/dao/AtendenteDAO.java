package br.com.impacta.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.impacta.model.Atendente;

public class AtendenteDAO extends PessoaDAO{
	
	public void cadastrar(Atendente a){
		getManager().getTransaction().begin();
		getManager().persist(a);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(Atendente a){	
		Atendente atendente = getManager().find(Atendente.class, a.getIdPessoa());
		getManager().getTransaction().begin();
		getManager().remove(atendente);
		getManager().getTransaction().commit();
		getManager().close();
	}
	public void alterar(Atendente a){		
		getManager().getTransaction().begin();
		getManager().merge(a);
		getManager().getTransaction().commit();	
	}
	
	public Atendente buscarPorId(Atendente p){
		Atendente atendente = getManager().find(Atendente.class, p.getIdPessoa());		 
		return atendente;
	}
	
	public List<Atendente> listar(){
		List<Atendente> lista = getManager().createQuery("select t from Atendente as t").getResultList();		
		return lista;		
	}

}
