package com.accolite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.util.Constants;

public class CreateTables_2 {
	public static void main(String args[]){
		Connection conn=null;
		Statement stmt=null;
		try{
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL2,Constants.username,Constants.password);
			System.out.println("Connected to Database_2\n");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sqlQ;
			sqlQ="CREATE TABLE CITIZEN (CitizenID INTEGER NOT NULL, Age INTEGER, DistrictID INTEGER, Name VARCHAR(100),"
					+ " RelationWithPresident VARCHAR(50) DEFAULT 'NoRealation', PRIMARY KEY(CitizenID) )";
			stmt.executeUpdate(sqlQ);
			System.out.println("Table Citizens has been created\n");
			
			InsertInTableCitizen ic=new InsertInTableCitizen();
			ic.Insert();
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
