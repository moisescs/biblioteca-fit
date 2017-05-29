package br.com.impacta.dao;

import javax.persistence.EntityManager;
import br.com.impacta.factory.MyEntityManagerFactory;

public abstract class AcervoDAO {
	private EntityManager manager;
	public AcervoDAO() {
		this.manager = new MyEntityManagerFactory().getEntityManagerFactory();
	}
	
	public EntityManager getManager() {
		return manager;
	}
}
