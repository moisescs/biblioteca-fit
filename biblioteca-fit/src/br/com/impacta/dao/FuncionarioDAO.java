package br.com.impacta.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.impacta.model.Funcionario;
import br.com.impacta.model.Professor;

public class FuncionarioDAO extends SolicitanteDAO {

	public void cadastrar(Funcionario f){
		getManager().getTransaction().begin();
		getManager().persist(f);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(String re){	
		Query query = this.getManager().createQuery("select f from Funcionario as f where re = :re");
		query.setParameter("re", re);
		Funcionario funcionario = (Funcionario) query.getSingleResult();
		funcionario.setBloqueado(true);
		
		getManager().getTransaction().begin();
		getManager().merge(funcionario);
		getManager().getTransaction().commit();		
		getFactory().close();
	}
	public void alterar(Funcionario f){		
		getManager().getTransaction().begin();
		getManager().merge(f);
		getManager().getTransaction().commit();	
	}
	
	public Funcionario buscarPorRe(String re){
		Query query = this.getManager().createQuery("select f from Funcionario as f where re = :re");
		query.setParameter("re", re);
		Funcionario funcionario = (Funcionario) query.getSingleResult();
		getFactory().close();
		return funcionario;
	}
	
	public List<Funcionario> listar(){
		List<Funcionario> lista = getManager().createQuery("select t from Funcionario as t").getResultList();		
		return lista;		
	}


}
