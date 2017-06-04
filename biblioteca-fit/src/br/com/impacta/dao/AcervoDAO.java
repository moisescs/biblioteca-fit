package br.com.impacta.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AcervoDAO {
	private EntityManager manager;
	private EntityManagerFactory factory;
	
	public AcervoDAO() {
		this.factory = Persistence.createEntityManagerFactory("biblioteca");
		this.manager = factory.createEntityManager();		
	}
	public EntityManager getManager() {
		return manager;
	}
	public EntityManagerFactory getFactory() {
		return factory;
	}
	
}
