package org.au.assignment.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.au.assignment.util.Constants;

public class ListTechnicalData 
{
	
	void listTechnicalData()
	{
	DatabaseMetaData dbmd = null;
	try {
		 Connection conn = null;
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		
		
		
		dbmd = conn.getMetaData();
		
		System.out.println("Driver Name: "+dbmd.getDriverName());  
		System.out.println("Driver Version: "+dbmd.getDriverVersion());  
		System.out.println("UserName: "+dbmd.getUserName());  
		System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
		System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

	} 
	catch (Exception e) {

	}
	}
}
