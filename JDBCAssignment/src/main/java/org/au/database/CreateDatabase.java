package org.au.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.au.util.Constants;


public class CreateDatabase {
	
	public CreateDatabase() {
		Connection conn = null;
		Statement stmt = null;
		String dropTable,createTable;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,"sa","accolite");
			stmt = conn.createStatement();
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'JDBCDatabase') CREATE DATABASE JDBCDatabase";
			stmt.executeUpdate(createDbIfNotExists);

			//System.out.println("Dropping table if exits");
			dropTable ="USE  JDBCDatabase "+ "IF OBJECT_ID('dbo.president', 'U') IS NOT NULL DROP TABLE dbo.president; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.president' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE president(presidentId int not null, citizenID int not null, status int not null default 1)"
					+ "END";

			stmt.executeUpdate(createTable);
			
			
			
			dropTable ="USE  JDBCDatabase "+ "IF OBJECT_ID('dbo.state', 'U') IS NOT NULL DROP TABLE dbo.state; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.state' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE state(stateID int not null, name varchar(20), status int not null default 1)"
					+ "END";

			stmt.executeUpdate(createTable);
			
			
			
			dropTable ="USE  JDBCDatabase "+ "IF OBJECT_ID('dbo.district', 'U') IS NOT NULL DROP TABLE dbo.district; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.district' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE district(districtId int not null, name varchar(20), districtHeadID int not null, stateID int not null, status int not null default 1)"
					+ "END";

			stmt.executeUpdate(createTable);
			
			
			
			dropTable ="USE  JDBCDatabase "+ "IF OBJECT_ID('dbo.citizen', 'U') IS NOT NULL DROP TABLE dbo.citizen; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.citizen' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE citizen(citizenId int not null, name varchar(20), districtID int not null, age int, status int not null default 1)"
					+ "END";

			stmt.executeUpdate(createTable);
			
			
			
			dropTable ="USE  JDBCDatabase "+ "IF OBJECT_ID('dbo.relation', 'U') IS NOT NULL DROP TABLE dbo.relation; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.relation' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE relation(relationId int not null, citizenID int not null, relatorID int not null, relation varchar(20))"
					+ "END";

			stmt.executeUpdate(createTable);

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
