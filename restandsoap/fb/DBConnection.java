package com.accolite.fb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection connection = null;
	
	public DBConnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		
		return connection;
	}
}
