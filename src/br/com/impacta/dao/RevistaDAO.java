package br.com.impacta.dao;

import java.util.List;
import br.com.impacta.model.Revista;

public class RevistaDAO extends AcervoDAO{
	
	public void cadastrar(Revista r){
		getManager().getTransaction().begin();
		getManager().persist(r);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(Revista r){	
		Revista revista = getManager().find(Revista.class, r.getIdRevista());
		getManager().getTransaction().begin();
		getManager().remove(revista);
		getManager().getTransaction().commit();
		getManager().close();
	}
	public void alterar(Revista r){		
		getManager().getTransaction().begin();
		getManager().merge(r);
		getManager().getTransaction().commit();	
	}
	
	public Revista buscarPorId(Revista r){
		Revista revista = getManager().find(Revista.class, r.getIdRevista());		 
		return revista;
	}
	
	public List<Revista> listar(){
		List<Revista> lista = getManager().createQuery("select r from revista as r").getResultList();		
		return lista;		
	}
}
