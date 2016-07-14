package com.au.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.au.util.Constants;



public class ValidateDB {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
			stmt = conn.createStatement();
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'Mohit1') CREATE DATABASE Mohit1";
			stmt.executeUpdate(createDbIfNotExists);

			System.out.println("Dropping table if exits");
			String dropTable ="USE  Mohit "+ "IF OBJECT_ID('dbo.President', 'U') IS NOT NULL DROP TABLE dbo.President; " ;
			stmt.executeUpdate(dropTable);

			

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
