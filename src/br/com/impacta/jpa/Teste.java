package br.com.impacta.jpa;

import java.util.Calendar;
import java.util.List;

import br.com.impacta.dao.LivroDAO;
import br.com.impacta.model.Livro;

public class Teste {

	public static void main(String[] args) {
		Livro l = new Livro();
		
		//l.setTitulo("tituloalterado");
		//l.setCategoria("categoriaalterado");
		
		//Calendar calendar = Calendar.getInstance();
		//calendar.set(10, 28, 2018);		
		//l.setAnoPublicacao(calendar);
		//l.setTipoPublicacao("tipoPublicacaoalterado");
		l.setIsbn("alterado");
		//l.setAutor("moisesalterado");
		//l.setEdicao("01alterado");
		//l.setEditora("saraivaalterado");
		
		LivroDAO dao = new LivroDAO();
		//dao.cadastrar(l);
		//l.setId(1);
		//dao.alterar(l);
		//List<Livro> livros = dao.listar();
		//for (Livro livro : livros) {
			//   System.out.println("Titulo: " + livro.getTitulo());
			//   System.out.println("Titulo: " + livro.getIsbn());
		//}
		dao.remover(l);

		
		
	}

}
