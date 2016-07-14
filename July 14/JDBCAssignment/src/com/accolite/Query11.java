package com.accolite;

/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 14, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.*;
import com.accolite.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class Query11.
 */
public class Query11{
	public static void main(String a[]) throws SQLException{
		Statement stmt = null;
		Connection conn = null;
		String sql = null;
		String name = null;
		int id;
		
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			
			String sql1 = "drop database database1, database2";
			stmt = conn.createStatement();
			
			stmt.addBatch(sql1);
			stmt.addBatch("Create database Database1");
			stmt.addBatch("Create database Database2");
			stmt.addBatch("Use Database1");
			stmt.addBatch("Create table dbo.States(StateID int ,StateName varchar(20))");
			stmt.addBatch("Create table dbo.Districts(DistrictID int,StateID int,DistrictName varchar(20),HeadID int)");

			stmt.addBatch("Use Database2");
			stmt.addBatch("Create table dbo.Citizen(CitizenID int,CitizenName varchar(20),DistrictID int,Position int)");
			stmt.addBatch("Use Database1");
			stmt.addBatch("Insert into dbo.States(StateID,StateName)values(1,'TamilNadu')");
			stmt.addBatch("Insert into dbo.States(StateID,StateName)values(2,'Maharashtra')");
			stmt.addBatch("Insert into dbo.States(StateID,StateName)values(3,'AndhraPradesh')");
			

			// INSERTING ENTRIES FOR TABLE 2
			stmt.addBatch("Use Database1");
			stmt.addBatch("Insert into dbo.Districts(DistrictID,StateID,DistrictName,HeadID)values(21,1,'Madurai',351)");
			stmt.addBatch("Insert into dbo.Districts(DistrictID,StateID,DistrictName,HeadID)values(22,1,'Chennai',352)");
			stmt.addBatch("Insert into dbo.Districts(DistrictID,StateID,DistrictName,HeadID)values(23,2,'Mumbai',353)");
			stmt.addBatch("Insert into dbo.Districts(DistrictID,StateID,DistrictName,HeadID)values(24,3,'Hyderabad',354)");

			// INSERTING ENTRIES FOR TABLE 3
			stmt.addBatch("Use Database2");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(351,'Rani',21,1)");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(352,'Ram',22,1)");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(353,'Rakesh',23,1)");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(354,'Ravi',24,1)");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(355,'Renuka',21,0)");
			stmt.addBatch("Insert into dbo.Citizen(CitizenID,CitizenName,DistrictID,Position)values(351,'Reshma',24,2)");
			
			
			stmt.executeBatch();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
			stmt.close();
			conn.close();
			
		}
		
	}
}
