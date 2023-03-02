package com.iga.app.dal;

import java.sql.Connection;

public interface ConnectionProvider {
	static final String DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://localhost/HR";
	static final String USERNAME = "postgres";
	static final String PASSWORD = "azerty";
	
	abstract Connection getConnection() throws Exception;
	
}
