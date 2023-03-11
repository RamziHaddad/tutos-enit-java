package com.conn;
import java.sql.Connection;
import java.sql.DriverManager;

//singleton
public class SingletonConnectionProvider implements ConnectionProvider{

	
	private static Connection connection= null;

	@Override
	public Connection getConnection() throws Exception {
		if (connection == null || connection.isClosed()) {
			Class.forName(DRIVER);
			this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }
	

}
