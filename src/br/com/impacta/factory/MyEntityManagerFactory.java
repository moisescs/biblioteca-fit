package br.com.impacta.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
	
	public EntityManagerFactory factory;

	public EntityManager getEntityManagerFactory(){		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager manager = factory.createEntityManager();
		return manager;		
	}
}
