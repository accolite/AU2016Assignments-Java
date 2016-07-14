package com.accolite.jdbcAssignment.jdbcJuhi;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import com.accolite.jdbcAssignment.utils.*;



public class InsertIntoTables {
	public void createDB() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			stmt = conn.createStatement();
			
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'SUMEET_DATABASE1') CREATE DATABASE SUMEET_DATABASE1";
			stmt.executeUpdate(createDbIfNotExists);
			
			createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'SUMEET_DATABASE2') CREATE DATABASE SUMEET_DATABASE2";
			stmt.executeUpdate(createDbIfNotExists);
			
			//System.out.println("Dropping table if exits");
			String dropTable ="USE  SUMEET_DATABASE2 "+ "IF OBJECT_ID('dbo.citizens', 'x') IS NOT NULL DROP TABLE dbo.citizens; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.citizens' AND type = 'x') "
					+ "BEGIN "
					+ "CREATE TABLE citizens(citizenID int not null primary key,districtID int not null,name varchar (255),age int not null,type int not null) "
					+ "END";

			stmt.executeUpdate(createTable);
			
			dropTable ="USE  SUMEET_DATABASE1 "+ "IF OBJECT_ID('dbo.district', 'U') IS NOT NULL DROP TABLE dbo.district; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.district' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE district(districtID int not null  primary key,headcitizenID int not null,name varchar (255),stateID int not null) "
					+ "END";

			stmt.executeUpdate(createTable);
			
			dropTable ="USE  SUMEET_DATABASE1 "+ "IF OBJECT_ID('dbo.state', 'U') IS NOT NULL DROP TABLE dbo.state; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.state' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE state(stateID int not null  primary key,name varchar (255),presidentID int not null) "
					+ "END";

			stmt.executeUpdate(createTable);
			
			
			dropTable ="USE  SUMEET_DATABASE1 "+ "IF OBJECT_ID('dbo.president', 'U') IS NOT NULL DROP TABLE dbo.president; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.president' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE president(presidentID int not null  primary key,name varchar (255)) "
					+ "END";

			stmt.executeUpdate(createTable);
			conn.close();
			
			


		} catch (SQLException se) {
			System.out.println(se.getErrorCode());
			if (se.getErrorCode() == 1801) {
				// Database already exists error
				System.out.println(se.getMessage());
			} else {
				// Some other problems, e.g. Server down, no permission, etc
				se.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
			// insert in citizen table
			pstmt = conn.prepareStatement("INSERT INTO database1.dbo.citizen values(?,?,?,?,?)");
				pstmt.setInt(1, 1);
				pstmt.setInt(2, 1);
				pstmt.setString(3, "sumeet");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 1);
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setInt(2, 1);
				pstmt.setString(3, "pawan");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 1);
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setInt(2, 1);
				pstmt.setString(3, "Akash");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 0);
				pstmt.addBatch();
				
				pstmt.setInt(1, 4);
				pstmt.setInt(2, 2);
				pstmt.setString(3, "surya");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 0);
				pstmt.addBatch();
				
				pstmt.setInt(1, 5);
				pstmt.setInt(2, 2);
				pstmt.setString(3, "saumyadeep");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 0);
				pstmt.addBatch();
				pstmt.executeBatch();
				
			// insert in district table
			pstmt = conn.prepareStatement("INSERT INTO database2.dbo.district values(?,?,?,?)");
				pstmt.setInt(1, 1);
				pstmt.setInt(2, 1);
				pstmt.setString(3, "xx");
				pstmt.setInt(4, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setInt(2, 2);
				pstmt.setString(3, "yy");
				pstmt.setInt(4, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setInt(2, 3);
				pstmt.setString(3, "vv");
				pstmt.setInt(4, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 4);
				pstmt.setInt(2, 4);
				pstmt.setString(3, "zz");
				pstmt.setInt(4, 2);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 5);
				pstmt.setInt(2, 5);
				pstmt.setString(3, "rr");
				pstmt.setInt(4, 2);
			
				pstmt.addBatch();
				pstmt.executeBatch();
			// insert into president table
			pstmt = conn.prepareStatement("INSERT INTO database2.dbo.president values(?,?)");
			
				pstmt.setInt(1, 1);
				pstmt.setString(2, "ss");
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setString(2, "abdg");
				
				pstmt.addBatch();
				pstmt.executeBatch();
				
			// insert into state table
			pstmt = conn.prepareStatement("INSERT INTO database2.dbo.state values(?,?,?)");
			
				pstmt.setInt(1, 1);
				pstmt.setString(2, "Bihar");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setString(2, "Jharkand");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setString(2, "UP");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 4);
				pstmt.setString(2, "Karnatka");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 5);
				pstmt.setString(2, "Telangana");
				pstmt.setInt(3, 1);
			
				pstmt.addBatch();
				pstmt.executeBatch();
	
		
			System.out.println("Record Successfully saved");
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[])
	{
		InsertIntoTables i=new InsertIntoTables();
		i.insert();
	}

}

