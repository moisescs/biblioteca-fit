package br.com.impacta.dao;

import java.sql.Connection;

import br.com.impacta.old.ConnectionFactory;

public abstract class ExemplarDAO {
	Connection conn;
	public ExemplarDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

}
