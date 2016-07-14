package org.au.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.au.assignment.util.Constants;

public class ShowHeadOfDistrict 
{
	static Connection conn = null;
	static Statement stmt = null;
	void list() throws SQLException
	{
		String sql =  "SELECT  DISTINCT c.first , c.last FROM Country_Citizens.dbo.Citizen c INNER JOIN COUNTRY.dbo.District d ON d.Head_id = c.cid where c.Did = '10' " ;
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery(sql);
			rs.beforeFirst();
//			
			while (rs.next()) {
				// Retrieve by column name
				//int id = rs.getInt("cid");
				String name = rs.getString("first");
				String name1 = rs.getString("last");

				// Display values
				System.out.println(name + name1);
			}
		
	}

}
