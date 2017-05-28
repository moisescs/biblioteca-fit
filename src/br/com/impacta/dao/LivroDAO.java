package br.com.impacta.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import br.com.impacta.model.Livro;

public class LivroDAO extends ExemplarDAO{
	public void cadastrar(Livro l){
		String sql = "";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getCategoria());
			stmt.setDate(3, new Date(l.getAnoPublicacao().getInstance().getTimeInMillis()));
			stmt.setString(4, l.getTipoPublicacao());
			stmt.setString(5, l.getAutor());
			stmt.setString(6, l.getEdicao());
			stmt.setString(7, l.getEditora());
			stmt.setString(8, l.getIsbn());
			
			stmt.execute();
			stmt.close();
			conn.close();
			System.out.println("Livro cadastrado com sucesso!");
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	public void alterar(Livro l){
		String sql = "";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getCategoria());
			stmt.setDate(3, new Date(l.getAnoPublicacao().getInstance().getTimeInMillis()));
			stmt.setString(4, l.getTipoPublicacao());
			stmt.setString(5, l.getAutor());
			stmt.setString(6, l.getEdicao());
			stmt.setString(7, l.getEditora());
			stmt.setString(8, l.getIsbn());
			stmt.setLong(9, l.getId());
			
			stmt.execute();
			stmt.close();
			conn.close();
			System.out.println("Livro cadastrado com sucesso!");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public Livro consultarPorId(Livro l){
		String sql = "";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Livro livro = new Livro();
			
			livro.setTitulo(rs.getString(""));
			livro.setCategoria(rs.getString(""));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataFinalizacao"));			
			livro.setAnoPublicacao(data);
			
			livro.setTipoPublicacao(rs.getString(""));
			livro.setAutor(rs.getString(""));
			livro.setEdicao(rs.getString(""));
			livro.setIsbn(rs.getString(""));
			livro.setEditora(rs.getString(""));
			livro.setId(rs.getLong(1));

			stmt.close();
			conn.close();			
			return livro;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	public List<Livro> listar(){
		String sql = "";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Livro> livros = new ArrayList<Livro>();
			
			while (rs.next()){
				Livro livro = new Livro();
				livro.setTitulo(rs.getString(""));
				livro.setCategoria(rs.getString(""));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));			
				livro.setAnoPublicacao(data);
				
				livro.setTipoPublicacao(rs.getString(""));
				livro.setAutor(rs.getString(""));
				livro.setEdicao(rs.getString(""));
				livro.setIsbn(rs.getString(""));
				livro.setEditora(rs.getString(""));
				livro.setId(rs.getLong(1));			
				livros.add(livro);
			}
			rs.close();
			stmt.close();
			return livros;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
