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
		getManager().close();
	}
	
	public void remover(Livro l){	
		Query query = this.getManager().createQuery("select l from Livro as l where isbn = :isbn");
		query.setParameter("isbn", l.getIsbn());		
		//query.setMaxResults(1);
		Livro livro = (Livro) query.getSingleResult();
		
		getManager().getTransaction().begin();
		getManager().remove(livro);
		getManager().getTransaction().commit();
		getManager().close();
	}
	public void alterar(Livro l){		
		getManager().getTransaction().begin();
		getManager().merge(l);
		getManager().getTransaction().commit();	
	}
	
	public List<Livro> buscarPorIsbn(Livro l){
		Query query = this.getManager().createQuery("select l from Livro as l where isbn = :isbn");
		query.setParameter("isbn", l.getIsbn());
		List<Livro> livros = query.getResultList();		 
		return livros;
	}
	
	public List<Livro> listar(){
		List<Livro> lista = getManager().createQuery("select l from Livro as l").getResultList();		
		return lista;		
	}

}
