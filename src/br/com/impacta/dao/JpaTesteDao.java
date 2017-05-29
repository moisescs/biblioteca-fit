package br.com.impacta.dao;

import javax.persistence.EntityManager;

import br.com.impacta.model.Funcionario;
import br.com.impacta.model.Pessoa;

public class JpaTesteDao {
	  EntityManager manager;

	  //sem construtor
	public static void main(String[] args) {
		Funcionario p = new Funcionario();
		p.setNomeCompleto("Nome");
		p.setLograouro("Rua Teste");
		p.setNumero("10");
		p.setBairro("carumbé");
		p.setCidade("são Paulo");
		p.setCep("02855-180");
		p.setBloqueado(false);
		p.setSenha("1234");
		p.setUsuario("user4");
		p.setUf("sp");
		
		p.setTipoSolicitante("123");
		p.setQtdDia(5);
		p.setQtdLivro(10);
		p.setQtdRevista(20);
		
		p.setRe("REAEAEA4");
		
		JpaTesteDao jpa = new JpaTesteDao();
		jpa.adiciona(p);
	}

	    public void adiciona(Pessoa p) {	
			
	    	//EntityManager e = new MyEntityManagerFactory().getEntityManagerFactory();	    	
			//e.getTransaction().begin();
			//e.persist(p);
			//e.getTransaction().commit();
	    }
	    
	


}
