package org.au.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.au.assignment.util.Constants;

public class DisplayCitizenCount 
{
	
		static Connection conn = null;
		static Statement stmt = null;
		void list() throws SQLException
		{
			String sql = "SELECT Count(c.cid) as TotalCitizen , s.Sid FROM Country_Citizens.dbo.Citizen c  INNER JOIN COUNTRY.dbo.District d ON d.Did = c.Did INNER JOIN COUNTRY.dbo.State s ON s.Sid = d.Sid GROUP BY s.Sid" ;
				conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				ResultSet rs = stmt.executeQuery(sql);
				rs.beforeFirst();
//				
				while (rs.next()) {
					// Retrieve by column name
					int count = rs.getInt("TotalCitizen");
					int id = rs.getInt("Sid");
					

					// Display values
					System.out.println(count +" "+ id);
				}
			
		};
			
		
	}


