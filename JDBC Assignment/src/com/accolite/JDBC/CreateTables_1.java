package com.accolite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.util.Constants;

public class CreateTables_1 {
	public static void main(String args[]){
		Connection conn=null;
		Statement stmt=null;
		try{
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL1,Constants.username,Constants.password);
			System.out.println("Connected to Database_1\n");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sqlQ;
			sqlQ="CREATE TABLE PRESIDENTS (CitizenID INTEGER NOT NULL, Status VARCHAR(20), PRIMARY KEY (CitizenID))";
			stmt.executeUpdate(sqlQ);
			System.out.println("Table Prsidents has been created\n");
			sqlQ="CREATE TABLE STATES (StateID INTEGER NOT NULL, StateName VARCHAR(50), PRIMARY KEY (StateID))";
			stmt.executeUpdate(sqlQ);
			System.out.println("Table States has been Created\n");
			sqlQ="CREATE TABLE DISTRICTS (DistrictID INTEGER NOT NULL, Name VARCHAR(50),StateID INTEGER,HeadCitizenID INTEGER, PRIMARY KEY(DistrictID))";
			stmt.executeUpdate(sqlQ);
			System.out.println("Table Districts has been created\n");
			InsertInTablePresident ip=new InsertInTablePresident();
			ip.Insert();
			InsertInTableState is=new InsertInTableState();
			is.Insert();
			InsertInTableDistricts id=new InsertInTableDistricts();
			id.Insert();
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
