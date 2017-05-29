package br.com.impacta.dao;

import java.util.List;

import br.com.impacta.model.Aluno;

public class AlunoDAO extends SolicitanteDAO {
	
	public void cadastrar(Aluno a){
		getManager().getTransaction().begin();
		getManager().persist(a);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(Aluno a){	
		Aluno aluno = getManager().find(Aluno.class, a.getIdPessoa());
		getManager().getTransaction().begin();
		getManager().remove(aluno);
		getManager().getTransaction().commit();
		getManager().close();
	}
	public void alterar(Aluno a){		
		getManager().getTransaction().begin();
		getManager().merge(a);
		getManager().getTransaction().commit();	
	}
	
	public Aluno buscarPorId(Aluno a){
		Aluno aluno = getManager().find(Aluno.class, a.getIdPessoa());		 
		return aluno;
	}
	
	public List<Aluno> listar(){
		List<Aluno> lista = getManager().createQuery("select t from Aluno as t").getResultList();		
		return lista;		
	}

}
