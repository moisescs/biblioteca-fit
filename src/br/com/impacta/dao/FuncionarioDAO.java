package br.com.impacta.dao;

import java.util.List;
import br.com.impacta.model.Funcionario;

public class FuncionarioDAO extends SolicitanteDAO {

	public void cadastrar(Funcionario f){
		getManager().getTransaction().begin();
		getManager().persist(f);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	public void remover(Funcionario f){	
		Funcionario funcionario = getManager().find(Funcionario.class, f.getIdPessoa());
		getManager().getTransaction().begin();
		getManager().remove(funcionario);
		getManager().getTransaction().commit();
		getManager().close();
	}
	public void alterar(Funcionario f){		
		getManager().getTransaction().begin();
		getManager().merge(f);
		getManager().getTransaction().commit();	
	}
	
	public Funcionario buscarPorId(Funcionario f){
		Funcionario fucionario = getManager().find(Funcionario.class, f.getIdPessoa());		 
		return fucionario;
	}
	
	public List<Funcionario> listar(){
		List<Funcionario> lista = getManager().createQuery("select t from Funcionario as t").getResultList();		
		return lista;		
	}


}
