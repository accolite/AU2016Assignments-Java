package org.au.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.au.assignment.util.Constants;

public class CreateTables 
{
	static Connection conn = null;
	static Statement stmt = null;
	
	
	
		void create() throws SQLException, ClassNotFoundException
		{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		
		try {
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   
	    
	      System.out.println("Creating table if not exists");
		  String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.citizen' AND type = 'U') "
				  + "USE Country_Citizens "
					+ "BEGIN "
					+ "CREATE TABLE Citizen(cid int not null,Did int not null,first varchar (255),last varchar (255),age int not null,type varchar(255)) "
					+ "END";

		  stmt.executeUpdate(createTable);
	      System.out.println("Created table in given database...");
	      
	     
	      
	      
	    

	      System.out.println("Creating table if not exists");
		  String createTable1 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.district' AND type = 'U') "
				  	+ "USE COUNTRY "
					+ "BEGIN "
					+ "CREATE TABLE District(Did int not null,Head_id int not null,Name varchar (255),Sid int not null) "
					+ "END";

		  stmt.executeUpdate(createTable1);
	      System.out.println("Created District table in given database...");
	      
	      
	      System.out.println("Creating table if not exists");
		  String createTable2 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.State' AND type = 'U') "
				  	+ "USE COUNTRY "
					+ "BEGIN "
					+ "CREATE TABLE State(Sid int not null,Name varchar (255),President_id int not null) "
					+ "END";

		  stmt.executeUpdate(createTable2);
		  
		  System.out.println("Created State table in given database...");
	      
	      System.out.println("Creating table if not exists");
		  String createTable3 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.President' AND type = 'U') "
				  	+ "USE COUNTRY "
					+ "BEGIN "
					+ "CREATE TABLE President(Pid int not null,Name varchar (255)) "
					+ "END";

		  stmt.executeUpdate(createTable3);
		  
		  System.out.println("Created President table in given database...");
	      
	}
	
	
}


