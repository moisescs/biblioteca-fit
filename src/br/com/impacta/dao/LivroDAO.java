package br.com.impacta.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.impacta.model.Acervo;
import br.com.impacta.model.Livro;

public class LivroDAO extends AcervoDAO{
	
	public void cadastrar(Livro l){
		getManager().getTransaction().begin();
		getManager().persist(l);
		getManager().getTransaction().commit();
		getFactory().close();
	}
	
	public void remover(String isbn){	
		Query query = this.getManager().createQuery("select l from Livro as l where isbn = :isbn");
		query.setParameter("isbn", isbn);
		Livro livro = (Livro) query.getSingleResult();
		livro.setDeletado(true);
		
		getManager().getTransaction().begin();
		getManager().merge(livro);
		getManager().getTransaction().commit();
		getFactory().close();
	}
	public void alterar(Livro l){		
		getManager().getTransaction().begin();
		getManager().merge(l);
		getManager().getTransaction().commit();	
		getFactory().close();
	}
	
	public Livro buscarPorIsbn(String isbn){
		Query query = this.getManager().createQuery("select l from Livro as l where isbn = :isbn");
		query.setParameter("isbn", isbn);
		Livro livro = (Livro) query.getSingleResult();	
		getFactory().close();
		return livro;
	}
	
	public List<Livro> listar(){
		List<Livro> lista = getManager().createQuery("select l from Livro as l where deletado = false").getResultList();	
		getFactory().close();
		return lista;		
	}

}
