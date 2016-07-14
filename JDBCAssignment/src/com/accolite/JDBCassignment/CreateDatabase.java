package com.accolite.JDBCassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.accolite.util.Constants;

public class CreateDatabase {
		CreateDatabase() {
		 	Connection conn = null;
			Statement stmt = null;
			
			try {
				
				String sql;
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
				
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				sql = "CREATE DATABASE db2";
				stmt.executeUpdate(sql);
				
				sql = "CREATE DATABASE db1";
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