package br.com.impacta.old;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/impacta?useSSL=false","root","impacta");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
}
