package br.com.impacta.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.impacta.model.Acervo;
import br.com.impacta.model.Emprestimo;
import br.com.impacta.model.Funcionario;
import br.com.impacta.model.Livro;
import br.com.impacta.model.Pessoa;
import br.com.impacta.model.Professor;

public class EmprestimoDAO {
	private EntityManager manager;
	private EntityManagerFactory factory;
	public EmprestimoDAO() {
		this.factory = Persistence.createEntityManagerFactory("biblioteca");
		this.manager = factory.createEntityManager();	
	}
	
	public void emprestar(Acervo a, Pessoa p){	
		Query queryPessoa = this.manager.createQuery("select p from Pessoa as p where p.usuario = :login and p.senha = :senha");
		queryPessoa.setParameter("login", p.getUsuario());
		queryPessoa.setParameter("senha", p.getSenha());			
		Pessoa pessoa = (Pessoa)queryPessoa.getSingleResult();

		
		Query queryAcervo = this.manager.createQuery("select a from Acervo as a where idAcervo = :id");
		queryAcervo.setParameter("id", a.getIdAcervo());
		Acervo acervo = (Acervo) queryAcervo.getSingleResult();	
		
		
		
		Emprestimo e = new Emprestimo();
		e.setPessoa(pessoa);
		e.setAcervo(acervo);
		e.setStatus(false);
		e.setDataEmprestimo(Calendar.getInstance());
		e.setDataDevolucao(null);		
		Calendar dataPrevistaDevolucao = Calendar.getInstance();
		dataPrevistaDevolucao.add(Calendar.DATE, +7);		
		e.setDataPrevistaDevolucao(dataPrevistaDevolucao);
		
		this.manager.getTransaction().begin();
		this.manager.persist(e);
		this.manager.getTransaction().commit();
		this.factory.close();
	}
	
	public void alterar(Emprestimo e){
		this.manager.getTransaction().begin();
		this.manager.merge(e);
		this.manager.getTransaction().commit();
	}
	
	public void devolver(long id){
		
		this.manager.getTransaction().begin();
		Emprestimo e = this.manager.find(Emprestimo.class, id);
		this.manager.getTransaction().commit();		
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, +0);
		e.setStatus(true);
		
		e.setDataDevolucao(c);
		this.manager.getTransaction().begin();
		this.manager.merge(e);
		this.manager.getTransaction().commit();		
	}

	public String renovar(long id){
		this.manager.getTransaction().begin();
		Emprestimo e = this.manager.find(Emprestimo.class, id);
		this.manager.getTransaction().commit();	
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		
		if(e.getDataPrevistaDevolucao().compareTo(c) >= 0){
			c.add(Calendar.DATE, +7);
			e.setDataPrevistaDevolucao(c);
			e.setStatus(false);
			this.manager.getTransaction().begin();
			this.manager.merge(e);
			this.manager.getTransaction().commit();
			return "Empréstimo Renovado com sucesso!" + (e.getDataPrevistaDevolucao().compareTo(c) >= 0);
		}else{
			return "Não é Possivel Renovar seu Empréstimo, pois está vencido!";
		}	
	}
	
	public List<Emprestimo> listar(boolean emp){
		Query query = this.manager.createQuery("select e from Emprestimo as e where status = :emp");	
		query.setParameter("emp", emp);
		List<Emprestimo> lista = query.getResultList();
		this.factory.close();
		return lista;
	}	
}
