package com.accolite.au.jdbc;
import java.sql.*;



public class Metadata {

		public void getTechnicalDetails()
		{
			Connection conn = null;
			DatabaseMetaData dbmd = null;
			try {
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				conn = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
				dbmd = conn.getMetaData();
				
				System.out.println("Driver Name: "+dbmd.getDriverName());  
				System.out.println("Driver Version: "+dbmd.getDriverVersion());  
				System.out.println("UserName: "+dbmd.getUserName());  
				System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
				System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
