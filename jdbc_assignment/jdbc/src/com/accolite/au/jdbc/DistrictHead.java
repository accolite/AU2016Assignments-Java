package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DistrictHead {

	public void getDistrictHead(String input)
	{
			Connection conn = null;
			Statement stmt = null;
			try {
			
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				
				conn = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
				String sql ;
				sql = "SELECT citizen.name as Head_of_District "
    + 	"FROM Database2.dbo.Citizen citizen,  Database1.dbo.District district "
    +" WHERE district.head_id = citizen.citizen_id "
    + " AND district.name = " + "'"+input+"'";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
				// Retrieve by column name
				
				
				String cname = rs.getString("Head_of_District");
				
				
				// Display values
				System.out.println(cname);
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
