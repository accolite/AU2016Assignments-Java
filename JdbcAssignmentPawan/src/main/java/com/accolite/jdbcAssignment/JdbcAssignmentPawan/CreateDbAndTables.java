package com.accolite.jdbcAssignment.JdbcAssignmentPawan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDbAndTables {

	public void create() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username, Constants.password);
			stmt = conn.createStatement();
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'JdbcAssignmentDB1') CREATE DATABASE JdbcAssignmentDB1";
			stmt.executeUpdate(createDbIfNotExists);

			System.out.println("Dropping tables of DB1 if exits");
			String dropTable ="USE JdbcAssignmentDB1 "+ "IF OBJECT_ID('dbo.district', 'U') IS NOT NULL DROP TABLE dbo.district; " ;
			stmt.executeUpdate(dropTable);
			String dropTable1 ="USE JdbcAssignmentDB1 "+ "IF OBJECT_ID('dbo.state', 'U') IS NOT NULL DROP TABLE dbo.state; " ;
			stmt.executeUpdate(dropTable1);
			String dropTable2 ="USE JdbcAssignmentDB1 "+ "IF OBJECT_ID('dbo.president', 'U') IS NOT NULL DROP TABLE dbo.president; " ;
			stmt.executeUpdate(dropTable2);

			System.out.println("Creating tables of DB1 if not exists");
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.district' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE district(districtID int not null, name varchar(50) not null, headCitizenID int not null, stateID int not null); "
					+ "END";
			stmt.executeUpdate(createTable);		
			
			String createTable1 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.state' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE state(stateID int not null, name varchar(50) not null, presidentCitizenID int not null); "
					+ "END";
			stmt.executeUpdate(createTable1);			
			
			String createTable2 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.president' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE president(presidentCitizenID int not null, name varchar(50) not null); "
					+ "END";
			stmt.executeUpdate(createTable2);
			
			
			
			String createDbIfNotExists1 = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'JdbcAssignmentDB2') CREATE DATABASE JdbcAssignmentDB2";
			stmt.executeUpdate(createDbIfNotExists1);

			System.out.println("Dropping tables of DB2 if exits");
			String dropTable3 ="USE JdbcAssignmentDB2 "+ "IF OBJECT_ID('dbo.citizen', 'U') IS NOT NULL DROP TABLE dbo.citizen; " ;
			stmt.executeUpdate(dropTable3);

			System.out.println("Creating tables of DB2 if not exists");
			String createTable3 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.citizen' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE citizen(citizenID int not null, name varchar(50) not null, age int not null, type varchar(50) not null,  districtID int not null); "
					+ "END";
			stmt.executeUpdate(createTable3);

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
}
