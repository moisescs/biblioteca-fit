package br.com.impacta.dao;

import java.util.List;
import br.com.impacta.model.Ope;

public class OpeDAO extends AcervoDAO{

	public void cadastrar(Ope o){
		getManager().getTransaction().begin();
		getManager().persist(o);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(Ope o){	
		Ope ope = getManager().find(Ope.class, o.getIdOpe());
		getManager().getTransaction().begin();
		getManager().remove(ope);
		getManager().getTransaction().commit();
		getManager().close();
	}
	public void alterar(Ope o){		
		getManager().getTransaction().begin();
		getManager().merge(o);
		getManager().getTransaction().commit();	
	}
	
	public Ope buscarPorId(Ope o){
		Ope ope = getManager().find(Ope.class, o.getIdOpe());		 
		return ope;
	}
	
	public List<Ope> listar(){
		List<Ope> lista = getManager().createQuery("select o from Ope as o").getResultList();		
		return lista;		
	}
	
}
