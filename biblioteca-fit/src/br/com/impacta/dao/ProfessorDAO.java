package br.com.impacta.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.impacta.model.Livro;
import br.com.impacta.model.Pessoa;
import br.com.impacta.model.Professor;

public class ProfessorDAO extends SolicitanteDAO{
	
	public void cadastrar(Professor p){
		getManager().getTransaction().begin();
		getManager().persist(p);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(String re){	
		Query query = this.getManager().createQuery("select p from Professor as p where re = :re");
		query.setParameter("re", re);
		Professor professor = (Professor) query.getSingleResult();
		professor.setBloqueado(true);
		
		getManager().getTransaction().begin();
		getManager().merge(professor);
		getManager().getTransaction().commit();		
		getFactory().close();

	}
	public void alterar(Professor p){		
		getManager().getTransaction().begin();
		getManager().merge(p);
		getManager().getTransaction().commit();	
	}
	
	public Professor buscarPorRe(String re){
		Query query = this.getManager().createQuery("select p from Professor as p where re = :re");
		query.setParameter("re", re);
		Professor professor = (Professor) query.getSingleResult();
		getFactory().close();
		return professor;
	}
	
	public List<Professor> listar(){
		List<Professor> lista = getManager().createQuery("select p from Professor as p where bloqueado = false").getResultList();	
		getFactory().close();
		return lista;		
	}
}
