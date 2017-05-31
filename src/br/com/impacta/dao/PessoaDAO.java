package br.com.impacta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.impacta.model.Pessoa;

public abstract class PessoaDAO {
	private EntityManagerFactory factory;
	private EntityManager manager;
	public PessoaDAO() {
		this.factory = Persistence.createEntityManagerFactory("biblioteca");
		this.manager = factory.createEntityManager();	
	}
	
	public EntityManager getManager() {
		return manager;
	}		
	
	public EntityManagerFactory getFactory() {
		return factory;
	}	
	
	public boolean existeUsuario(Pessoa pessoa){
				
		try {			
			Query query = this.getManager().createQuery("select p from Pessoa as p where p.usuario = :login and p.senha = :senha");
			query.setParameter("login", pessoa.getUsuario());
			query.setParameter("senha", pessoa.getSenha());			
			List<Pessoa> lista = query.getResultList();
			this.getFactory().close();

			if(!lista.isEmpty()){	
				return true;
			}else{
				return false;
			}			
			
		} catch (Exception e) {
			this.getFactory().close();
		}
		return false;
	}
}
