package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ListStates {

	public void displayStates()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
		
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
		
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
			String sql;
			sql = "SELECT * from dbo.State";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
			// Retrieve by column name
			int sid = rs.getInt("state_id");
			int pid = rs.getInt("president_id");
			String state_name = rs.getString("name");
			//String last = rs.getString("last");

			// Display values
			System.out.println(sid+"\t"+state_name+"\t"+pid);
		}
		// STEP 6: Clean-up environment
		rs.close();
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

