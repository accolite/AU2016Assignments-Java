/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 14, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.jdbcAssignment;

import java.sql.*;

import com.accolite.jbdcExample.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class for Initial inserts for the JDBC Assignment
 */
public class JdbcAssignmentInitialInsert {
	
	/** The connection. */
	Connection connection;

	/** The Names. */
	final String[] Name = {"Sharukh Mohamed","Naveen Raja","Shyam Mohan","Shajahan","Shahin"};
	
	/** The state names. */
	final String[] stateName = {"Tamil Nadu","Kerala","Karnataka","Maharashtra","Telengana"};
	
	/** The district names. */
	final String[] districtName = {"Coimbatore", "Palakkad", "Kochi", "Chennai", "Bangalore"};
	
	/** The district states. */
	final int[] districtState = {1,2,2,1,3};
	
	/** The district heads. */
	final int[] districtHead = {2,3,4,1,5};
	
	/** The district citizens. */
	final int[] districtCitizens = {5,4,4,5,4};
	
	/** The ages. */
	final int[] age = {25,64,44,65,24};
	
	/**
	 * Setup for initiating Connection
	 *
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public void setup() throws SQLException,Exception{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		connection = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.USERNAME, Constants.PASSWORD);
	}
	
	/**
	 * Creates the databases.
	 */
	public void createDatabases(){
		try{
			//DATABASE 1
			setup();
			Statement statement = connection.createStatement();
			String createDbIfNotExists = "USE master;IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'Database1') "
					+ "CREATE DATABASE Database1";
			statement.executeUpdate(createDbIfNotExists);
			teardown();
			
			//DATABASE 2
			setup();
			statement = connection.createStatement();
			createDbIfNotExists = "USE master;IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'Database2') "
					+ "CREATE DATABASE Database2";
			statement.executeUpdate(createDbIfNotExists);
			teardown();
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	
	/**
	 * Drops the tables.
	 */
	public void dropTables(){
		try{
			setup();

			/***
			 * CITIZENS
			 */
			Statement statement = connection.createStatement();
			String dropTable ="USE  Database2; "+ "IF OBJECT_ID('dbo.Citizens', 'U') "
					+ "IS NOT NULL DROP TABLE dbo.Citizens; " ;
			statement.executeUpdate(dropTable);
			teardown();

			/***
			 * PRESIDENT
			 */
			setup();
			statement = connection.createStatement();
			dropTable ="USE  Database1; "+ "IF OBJECT_ID('dbo.President', 'U') "
					+ "IS NOT NULL DROP TABLE dbo.President; " ;
			statement.executeUpdate(dropTable);

			/***
			 * DISTRICTS
			 */
			dropTable ="USE  Database1; "+ "IF OBJECT_ID('dbo.Districts', 'U') "
					+ "IS NOT NULL DROP TABLE dbo.Districts; " ;
			statement.executeUpdate(dropTable);


			/***
			 * STATES
			 */
			dropTable ="USE  Database1; "+ "IF OBJECT_ID('dbo.States', 'U') "
					+ "IS NOT NULL DROP TABLE dbo.States; " ;
			statement.executeUpdate(dropTable);
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Creates the tables.
	 */
	public void createTables(){
		try{
			setup();
			
			/**
			 * CITIZENS
			 * */
			//System.out.println("Citizens");
			Statement statement = connection.createStatement();
			String dropTable ="USE  Database2; "+ "IF OBJECT_ID('dbo.Citizens', 'U') "
					+ "IS NOT NULL DROP TABLE dbo.Citizens; " ;
			statement.executeUpdate(dropTable);
			String createTable ="USE  Database2; "+ "CREATE TABLE Citizens("
					+ "citizenId int PRIMARY KEY IDENTITY(1,1),"
					+ "Name varchar(50) not null,"
					+ "age int,"
					+ "districtId int,"
					+ "spouseId int foreign key references Citizens(citizenId),"
					+ "parentId int);";
			statement.executeUpdate(createTable);
			statement.close();
			teardown();
			

			/**
			 * PRESIDENT
			 * */

			//System.out.println("President");
			setup();
			statement = connection.createStatement();
			dropTable ="USE  Database1; "+ "IF OBJECT_ID('dbo.President', 'U') "
					+ "IS NOT NULL DROP TABLE dbo.President; " ;
			statement.executeUpdate(dropTable);
			createTable ="USE  Database1; "
					+ "CREATE TABLE President(countryId int primary key, citizenId int not null);" ;
			statement.executeUpdate(createTable);
			

			/**
			 * STATES
			 * */
			//System.out.println("States");
			dropTable ="USE  Database1; "+ "IF OBJECT_ID('dbo.States', 'U') "
					+ "IS NOT NULL DROP TABLE dbo.States; " ;
			statement.executeUpdate(dropTable);
			createTable ="USE  Database1; "+ "CREATE TABLE States( "
					+ "stateId int PRIMARY KEY IDENTITY(1,1), "
					+ "stateName varchar(50) not null);" ;
			statement.executeUpdate(createTable);
			

			/**
			 * DISTRICTS
			 * */
			//System.out.println("Districts");
			dropTable ="USE  Database1; "+ "IF OBJECT_ID('dbo.Districts', 'U') "
					+ "IS NOT NULL DROP TABLE dbo.Districts; " ;
			statement.executeUpdate(dropTable);
			createTable ="USE  Database1; "+ "CREATE TABLE Districts("
					+ "districtId int PRIMARY KEY IDENTITY(1,1),"
					+ "districtName varchar(50) not null,"
					+ "districtHead int,"
					+ "stateId int foreign key references dbo.States(stateId));";
			statement.executeUpdate(createTable);
			statement.close();
			teardown();
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Creates the triggers.
	 */
	public void createTriggers() {
		try{
			setup();
			
			/**
			 * CITIZENS
			 * */
			//System.out.println("Citizens");
			Statement statement = connection.createStatement();
			String dropTrigger ="USE  Database2; "+ "IF OBJECT_ID('dbo.CreateCitizens', 'TR') "
					+ "IS NOT NULL DROP TRIGGER dbo.CreateCitizens; " ;
			statement.executeUpdate(dropTrigger);
			String createTrigger =
					"CREATE TRIGGER dbo.CreateCitizens "
					+ "ON dbo.Citizens "
					+ "AFTER INSERT "
					+"AS "
					+"IF EXISTS (SELECT *"
					+" FROM dbo.Citizens c"
					+" JOIN inserted AS i "
					+"ON c.citizenId = i.citizenId"
					+" JOIN Database1.dbo.Districts AS d "
					+"ON d.districtId=i.districtId"
					+" WHERE i.districtId is NOT NULL)"
					+" BEGIN "
					+"RAISERROR ('Improper District entered', 16, 1); "
					+"ROLLBACK TRANSACTION; "
					+"RETURN; " 
					+"END;";
			statement.executeUpdate(createTrigger);
			statement.close();
			teardown();
			
			/***
			 * TODO - Create More Constraints as Triggers after initial backup
			 */
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Insert seed values.
	 */
	public void insertValues(){
		try{
			

			setup();
			Statement statement = connection.createStatement();
			String dbConnect = "USE Database1;";
			statement.executeUpdate(dbConnect);
			statement.close();
			
			/***
			 * STATES
			 * */
			//System.out.println("STATES");
			String insertTable ="INSERT INTO dbo.States(stateName) values(?)";
			PreparedStatement prepStatement = connection.prepareStatement(insertTable);
			for(int i=0;i<5;i++){
				prepStatement.setString(1, stateName[i]);
				prepStatement.addBatch();
			}
			prepStatement.executeBatch();
			prepStatement.close();
			

			/***
			 * DISTRICTS
			 * */
			//System.out.println("DISTRICTS");
			insertTable ="INSERT INTO dbo.Districts(districtName, districtHead, stateId) values(?, ?, ?)";
			prepStatement = connection.prepareStatement(insertTable);
			for(int i=0;i<5;i++){
				prepStatement.setString(1, districtName[i]);
				prepStatement.setInt(2, districtHead[i]);
				prepStatement.setInt(3, districtState[i]);
				prepStatement.addBatch();
			}
			prepStatement.executeBatch();
			prepStatement.close();
			teardown();
			
			setup();
			statement = connection.createStatement();
			dbConnect = "USE Database2;";
			statement.executeUpdate(dbConnect);
			statement.close();
			
			/**
			 * CITIZENS
			 * */
			//System.out.println("Citizens");
			insertTable ="INSERT INTO dbo.Citizens(Name, Age, districtId) values(?, ?, ?)";
			prepStatement = connection.prepareStatement(insertTable);
			for(int i=0;i<5;i++){
				prepStatement.setString(1, Name[i]);
				prepStatement.setInt(2, age[i]);
				prepStatement.setInt(3, districtCitizens[i]);
				prepStatement.addBatch();
			}
			
			prepStatement.executeBatch();
			prepStatement.close();
			
			/**
			 * PRESIDENTS
			 * */
			//System.out.println("PRESIDENT");
			insertTable ="INSERT INTO Database1.dbo.President values(1,2)";
			statement = connection.createStatement();
			statement.executeUpdate(insertTable);

			statement.close();
			teardown();
			/***
			 * Handling all exceptions
			 */	
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	

	/**
	 * Drop triggers.
	 */
	public void dropTriggers(){
		try{
			setup();
		
		Statement statement = connection.createStatement();
		String dropTrigger ="USE  Database2; "+ "IF OBJECT_ID('dbo.CreateCitizens', 'TR') "
				+ "IS NOT NULL DROP TRIGGER dbo.CreateCitizens; " ;
		statement.executeUpdate(dropTrigger);
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	
	/**
	 * Creates the backup.
	 */
	public void createBackup(){
		try{
			setup();
			Statement statement = connection.createStatement();
			String backup = "BACKUP DATABASE Database1 " 
						+"TO DISK = \'D:\\Database1.bak\'";
			statement.executeUpdate(backup);
			backup = "BACKUP DATABASE Database2 " 
					+"TO DISK = \'D:\\Database2.bak\'";
			statement.executeUpdate(backup);
			statement.close();
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Teardown the database.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void teardown() throws SQLException{ 
		connection.close();
	}
	
	/**
	 * Inititate call for required Startup.
	 */
	public void inititateCall(){
		dropTables();
		dropTriggers();
		createDatabases();
		createTables();
		//createTriggers();
		insertValues();
		createBackup();
	}
	
	/**
	 * The Driver program if needed to check
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		JdbcAssignmentInitialInsert initial = new JdbcAssignmentInitialInsert();
		initial.inititateCall();
	}
}
