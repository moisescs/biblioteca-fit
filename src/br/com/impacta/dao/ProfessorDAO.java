package br.com.impacta.dao;

import java.util.List;

import br.com.impacta.model.Professor;

public class ProfessorDAO extends SolicitanteDAO{
	
	public void cadastrar(Professor p){
		getManager().getTransaction().begin();
		getManager().persist(p);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(Professor p){	
		Professor professor = getManager().find(Professor.class, p.getIdPessoa());
		getManager().getTransaction().begin();
		getManager().remove(professor);
		getManager().getTransaction().commit();
		getManager().close();
	}
	public void alterar(Professor p){		
		getManager().getTransaction().begin();
		getManager().merge(p);
		getManager().getTransaction().commit();	
	}
	
	public Professor buscarPorId(Professor p){
		Professor professor = getManager().find(Professor.class, p.getIdPessoa());		 
		return professor;
	}
	
	public List<Professor> listar(){
		List<Professor> lista = getManager().createQuery("select p from Professor as p").getResultList();		
		return lista;		
	}

}
