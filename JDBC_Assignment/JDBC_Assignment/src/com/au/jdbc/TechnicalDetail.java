package com.au.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.au.util.Constants;



public class TechnicalDetail {
	Connection conn = null;
	DatabaseMetaData dbmd = null;
	
	public void technicalInfo() throws SQLException {
		
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
			dbmd = conn.getMetaData();
			
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

		} catch (Exception e) {

		}finally {
			conn.close();
		}
}
}
