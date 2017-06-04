package br.com.impacta.dao;

import java.util.List;

import javax.persistence.Query;
import br.com.impacta.model.Aluno;
import br.com.impacta.model.Professor;

public class AlunoDAO extends SolicitanteDAO {
	
	public void cadastrar(Aluno a){
		getManager().getTransaction().begin();
		getManager().persist(a);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(String ra){	
		Query query = this.getManager().createQuery("select a from Aluno as a where ra = :ra");
		query.setParameter("ra", ra);
		Aluno aluno = (Aluno) query.getSingleResult();
		aluno.setBloqueado(true);
		
		getManager().getTransaction().begin();
		getManager().merge(aluno);
		getManager().getTransaction().commit();		
		getFactory().close();

	}
	public void alterar(Aluno a){		
		getManager().getTransaction().begin();
		getManager().merge(a);
		getManager().getTransaction().commit();	
	}	
	
	public Aluno buscarPorRa(String ra){
		Query query = this.getManager().createQuery("select a from Aluno as a where ra = :ra");
		query.setParameter("ra", ra);
		Aluno aluno = (Aluno)query.getSingleResult();
		getFactory().close();
		return aluno;
	}
	
	public List<Aluno> listar(){
		List<Aluno> lista = getManager().createQuery("select t from Aluno as t").getResultList();		
		return lista;		
	}

}
