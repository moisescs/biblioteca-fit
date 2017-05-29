package br.com.impacta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.impacta.factory.MyEntityManagerFactory;
import br.com.impacta.model.Pessoa;

public abstract class PessoaDAO {
	private EntityManager manager;
	
	public PessoaDAO() {
		this.manager = new MyEntityManagerFactory().getEntityManagerFactory();
	}
	
	public EntityManager getManager() {
		return manager;
	}	 
	
	public boolean existeUsuario(Pessoa pessoa){
				
		try {			
			Query query = this.getManager().createQuery("select p from Pessoa as p where p.usuario = :login and p.senha = :senha");
			query.setParameter("login", pessoa.getUsuario());
			query.setParameter("senha", pessoa.getSenha());
			
			List<Pessoa> lista = query.getResultList();

			if(!lista.isEmpty()){	
				return true;
			}else{
				return false;
			}			

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
