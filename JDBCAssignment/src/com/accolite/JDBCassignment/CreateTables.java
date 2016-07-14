package com.accolite.JDBCassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.util.Constants;

public class CreateTables {
	public CreateTables() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
     			String sql;
			    Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		    	conn = DriverManager.getConnection(Constants.DB_URL1,Constants.username,Constants.password);
			
			    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			    System.out.println("Connected to Database_1\n");
			   
			   
			
			   sql="CREATE TABLE PRESIDENTS (PresidentID INTEGER NOT NULL, PresidentName VARCHAR(20), PRIMARY KEY (PresidentID))";
			   stmt.executeUpdate(sql);
			   System.out.println("Table Prsidents has been created\n");
			   sql="CREATE TABLE STATES (StateID INTEGER NOT NULL, StateName VARCHAR(50), PRIMARY KEY (StateID))";
			   stmt.executeUpdate(sql);
			   System.out.println("Table States has been Created\n");
			   sql="CREATE TABLE DISTRICTS (DistrictID INTEGER NOT NULL, DistrictName VARCHAR(50),StateID INTEGER,HeadCitizenID INTEGER, PRIMARY KEY(DistrictID))";
			   stmt.executeUpdate(sql);
			   System.out.println("Table Districts has been created\n");
			
			   stmt.close();
			   conn.close();
			
			   conn = DriverManager.getConnection(Constants.DB_URL2,Constants.username,Constants.password);
			
			   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			   System.out.println("Connected to Database_2\n");
			    
			   sql="CREATE TABLE CITIZENS (CitizenID INTEGER NOT NULL, CitizenName VARCHAR(50),Age INTEGER,DistrictID INTEGER,SpouseID INTEGER,Relation VARCHAR(50) DEFAULT null,PRIMARY KEY(CitizenID))";
			   stmt.executeUpdate(sql);
			 
			   stmt.close();
			   conn.close();
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}				
		}
	}
}
