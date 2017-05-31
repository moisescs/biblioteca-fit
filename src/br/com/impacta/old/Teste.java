package br.com.impacta.old;

import java.sql.Connection;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) throws SQLException {
		Connection coon = new ConnectionFactory().getConnection();
		System.out.println("Conectado");
		coon.close();		

	}

}
