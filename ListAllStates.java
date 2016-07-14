package org.au.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.au.assignment.util.Constants;

public class ListAllStates
{
	static Connection conn = null;
	static Statement stmt = null;
	
	 void list() throws SQLException
	{
		String sql = "Use COUNTRY " + "SELECT DISTINCT s.Name FROM State s";
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = stmt.executeQuery(sql);
		rs.beforeFirst();
//		
		while (rs.next()) {
			// Retrieve by column name
			String name = rs.getString("name");

			// Display values
			System.out.println(name);
		}
	}

}
