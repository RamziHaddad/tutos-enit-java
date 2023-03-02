package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class PooledConnectionProvider implements ConnectionProvider{

	private static BasicDataSource ds = new BasicDataSource();
	
    static {
        ds.setUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        ds.setInitialSize(5);
        ds.setMinIdle(5);
        ds.setMaxIdle(50);
        ds.setMaxTotal(100);
        ds.setMaxOpenPreparedStatements(1000);
    }

	@Override
	public Connection getConnection() throws Exception {
        return ds.getConnection();
    }
	

}
