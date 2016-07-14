package org.su.jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
		Connection conn = null;
		Statement stmt = null;
		String dropTable,createTable;
		CreateDatabase()
		{
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
			stmt = conn.createStatement();
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'ARNIKA') CREATE DATABASE ARNIKA";
			stmt.executeUpdate(createDbIfNotExists);

			System.out.println("Dropping table if exits");
			dropTable ="USE  ARNIKA "+ "IF OBJECT_ID('dbo.Citizen', 'U') IS NOT NULL DROP TABLE dbo.Citizen; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.Citizen' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE Citizen(CitizenID int not null,Age int not null,Name varchar (255),DistrictID int not null,Status int not null default 1) "
					+ "END";

			stmt.executeUpdate(createTable);
			dropTable ="USE  ARNIKA "+ "IF OBJECT_ID('dbo.District', 'U') IS NOT NULL DROP TABLE dbo.District; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.District' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE District(DistrictID int not null,DistrictHeadID int not null,Name varchar (255),StateID int not null,Status int not null default 1) "
					+ "END";

			stmt.executeUpdate(createTable);
			dropTable ="USE  ARNIKA "+ "IF OBJECT_ID('dbo.State', 'U') IS NOT NULL DROP TABLE dbo.State; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.State' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE State(StateID int not null,Name varchar (255),Status int not null default 1) "
					+ "END";

			stmt.executeUpdate(createTable);
			dropTable ="USE  ARNIKA "+ "IF OBJECT_ID('dbo.President', 'U') IS NOT NULL DROP TABLE dbo.President; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.President' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE President(PresidentID int not null,Status int not null default 1) "
					+ "END";

			stmt.executeUpdate(createTable);
			dropTable ="USE  ARNIKA "+ "IF OBJECT_ID('dbo.VIP', 'U') IS NOT NULL DROP TABLE dbo.VIP; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.VIP' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE VIP(RelationID int not null,CitizenID int not null,Relation varchar (255),RelatedID int not null) "
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
