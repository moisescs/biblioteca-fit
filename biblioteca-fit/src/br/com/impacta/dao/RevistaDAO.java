package br.com.impacta.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.impacta.model.Livro;
import br.com.impacta.model.Professor;
import br.com.impacta.model.Revista;

public class RevistaDAO extends AcervoDAO{
	
	public void cadastrar(Revista r){
		getManager().getTransaction().begin();
		getManager().persist(r);
		getManager().getTransaction().commit();
		getManager().close();
		getFactory().close();
	}
	
	public void remover(String cod){	
		Query query = this.getManager().createQuery("select r from Revista as r where codigoRevista = :cod");
		query.setParameter("cod", cod);
		Revista revista = (Revista) query.getSingleResult();
		revista.setDeletado(true);
		
		getManager().getTransaction().begin();
		getManager().merge(revista);
		getManager().getTransaction().commit();
		getFactory().close();

	}
	public void alterar(Revista r){		
		getManager().getTransaction().begin();
		getManager().merge(r);
		getManager().getTransaction().commit();	
		getManager().close();
		getFactory().close();
	}
	
	public Revista buscarPorId(String codigoRevista){
		Query query = this.getManager().createQuery("select r from Revista as r where codigoRevista = :cod");
		query.setParameter("cod", codigoRevista);
		Revista revista = (Revista) query.getSingleResult();
		return revista;
	}
	
	public List<Revista> listar(){
		List<Revista> lista = getManager().createQuery("select r from Revista as r").getResultList();	
		getManager().close();
		getFactory().close();
		return lista;		
	}
}
