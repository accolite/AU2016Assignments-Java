package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CitizenUnderDistrict {
	
	public void getCitizenDistrict(String input)
	{
			Connection conn = null;
			Statement stmt = null;
			try {
			
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				
				conn = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
				String sql ;
				sql = "SELECT district.name as DistrictName, citizen.name as Name_of_Citizen "
    + 	"FROM Database2.dbo.Citizen citizen,  Database1.dbo.District district "
    +" WHERE citizen.district_id = district.district_id "
    + " AND district.name = " + "'"+input+"'";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
				// Retrieve by column name
				
				String district_name = rs.getString("DistrictName");
				String cname = rs.getString("Name_of_Citizen");
				
				
				// Display values
				System.out.println(district_name+"\t"+cname);
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
