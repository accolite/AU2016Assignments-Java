package com.accolite.JDBC;

import java.sql.*;
import com.accolite.util.*;

public class Createdatabases {
	public static void main(String args[]){
		Connection conn=null;
		Statement stmt=null;
		try{
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sqlQ;
			sqlQ="CREATE DATABASE DATABASE_1";
			System.out.println("Database 1 created\n");
			stmt.executeUpdate(sqlQ);
			
			sqlQ="CREATE DATABASE DATABASE_2";
			stmt.executeUpdate(sqlQ);
			System.out.println("Database 2 created\n");
			
			
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
