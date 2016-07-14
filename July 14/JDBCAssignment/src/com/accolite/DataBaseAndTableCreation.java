/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 14, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */
package com.accolite;

import com.accolite.util.*;
import java.sql.*;
import java.util.Scanner;

public class DataBaseAndTableCreation {
	Statement stmt = null;
	Connection conn = null;
    String sql = null;

	// METHOD TO ESTABLISH CONNECTION
	public void CreateConnection() {
		try {

			// REGISTERING DRIVER
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			System.out.println("Registered successfully");

			// ESTABLISHING CONNECTION
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			System.out.println("Connection successful");

			// CREATE STATEMENT
			stmt = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// METHOD TO CREATE 2 DATABASES
	public void CreateDatabase() {
		try {
			stmt.addBatch("Create database Database1");
			stmt.addBatch("Create database Database2");
			stmt.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// METHOD TO CREATE TABLES
	public void CreateTables() {
		try {
			stmt.addBatch("Use Database1");
			stmt.addBatch("Create table dbo.States(StateID int ,StateName varchar(20))");
			stmt.addBatch("Create table dbo.Districts(DistrictID int,StateID int,DistrictName varchar(20),HeadID int)");

			stmt.addBatch("Use Database2");
			stmt.addBatch(
					"Create table dbo.Citizen(CitizenID int,CitizenName varchar(20),DistrictID int,Position int)");
			stmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Insert values into tables.
	 */
	// METHOD TO INSERT VALUES
	public void InsertValuesIntoTables() {
		try {
			// INSERTING ENTRIES FOR TABLE 1
			stmt.addBatch("Use Database1");
			stmt.addBatch("Insert into dbo.States(StateID,StateName)values(1,'TamilNadu')");
			stmt.addBatch("Insert into dbo.States(StateID,StateName)values(2,'Maharashtra')");
			stmt.addBatch("Insert into dbo.States(StateID,StateName)values(3,'AndhraPradesh')");
			stmt.executeBatch();

			// INSERTING ENTRIES FOR TABLE 2
			stmt.addBatch("Use Database1");
			stmt.addBatch(
					"Insert into dbo.Districts(DistrictID,StateID,DistrictName,HeadID)values(21,1,'Madurai',351)");
			stmt.addBatch(
					"Insert into dbo.Districts(DistrictID,StateID,DistrictName,HeadID)values(22,1,'Chennai',352)");
			stmt.addBatch("Insert into dbo.Districts(DistrictID,StateID,DistrictName,HeadID)values(23,2,'Mumbai',353)");
			stmt.addBatch(
					"Insert into dbo.Districts(DistrictID,StateID,DistrictName,HeadID)values(24,3,'Hyderabad',354)");
			stmt.executeBatch();

			// INSERTING ENTRIES FOR TABLE 3
			stmt.addBatch("Use Database2");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(351,'Rani',21,1)");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(352,'Ram',22,1)");
			stmt.addBatch(
					"Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(353,'Rakesh',23,1)");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(354,'Ravi',24,1)");
			stmt.addBatch(
					"Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(355,'Renuka',21,0)");
			stmt.addBatch(
					"Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(351,'Reshma',24,2)");
			stmt.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String a[]) {
		DataBaseAndTableCreation db = new DataBaseAndTableCreation();
		int choice;
		Scanner s = new Scanner(System.in);

		System.out.println("Enter your choice:");
		System.out.println("1-Create Connection");
		System.out.println("2-Create database");
		System.out.println("3-Create tables");
		System.out.println("4-Insertion");
		System.out.println("5-Exit");
		
		choice = s.nextInt();
		
		switch(choice){
		case 1: db.CreateConnection();
		        break;
		case 2: db.CreateDatabase();
		        break;
		case 3: db.CreateTables();
		        break;
		case 4: db.InsertValuesIntoTables();
		        break;
		case 5: break;
		}

	}

}
