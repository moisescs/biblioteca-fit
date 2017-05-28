package br.com.impacta.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

import br.com.impacta.model.Revista;

public class RevistaDAO extends ExemplarDAO{
	public void cadastrar(Revista r){
		String sql = "";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,r.getTitulo());
			stmt.setString(2,r.getCategoria());
			stmt.setString(3,r.getEdicao());
			stmt.setString(4,r.getEditora());
			stmt.setString(4,r.getTipoPublicacao());
			stmt.setDate(5,new Date(r.getAnoPublicacao().getInstance().getTimeInMillis()));
			
			stmt.execute();
			conn.close();
			stmt.close();
			System.out.println("Revista Cadastrada com sucesso!");
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public void alterar(Revista r){
		String sql = "";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,r.getTitulo());
			stmt.setString(2,r.getCategoria());
			stmt.setString(3,r.getEdicao());
			stmt.setString(4,r.getEditora());
			stmt.setString(4,r.getTipoPublicacao());
			stmt.setDate(5,new Date(r.getAnoPublicacao().getInstance().getTimeInMillis()));
			stmt.setLong(6, r.getId());
			
			stmt.execute();
			conn.close();
			stmt.close();
			System.out.println("Revista alterada com sucesso!");
		} catch (Exception e) {
			throw new RuntimeException();
		}	
	}
	
	public Revista consultaPorId(){
		String sql = "";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Revista revista = new Revista();
			
			revista.setTitulo(rs.getString(""));
			revista.setCategoria(rs.getString(""));
			revista.setEditora(rs.getString(""));
			revista.setEdicao(rs.getString(""));
			revista.setTipoPublicacao(rs.getString(""));
			
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate(""));			
			revista.setAnoPublicacao(data);
			
			stmt.execute();
			stmt.close();
			rs.close();
			conn.close();			
			return revista;
		} catch (Exception e) {
			throw new RuntimeException();
		}				
	}
	
	public List<Revista> listar(){
		String sql = "";
		
		try {
			
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return null;
		
	}
}
