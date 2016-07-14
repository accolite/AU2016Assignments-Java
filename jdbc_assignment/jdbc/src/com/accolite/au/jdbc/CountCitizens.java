package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountCitizens {

	public void getCitizenCount()
	{
			Connection conn = null;
			Statement stmt = null;
			try {
			
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				
				conn = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
				String sql ;
				sql = "SELECT state.name as StateName, count(district.state_id) as No_of_citizen "
						+     " FROM Database2.dbo.Citizen citizen, Database1.dbo.State state, Database1.dbo.District district "
						+    "WHERE citizen.district_id = district.district_id "
						+    "AND district.state_id = state.state_id " 
						+	 "AND citizen.flag = 1 "
						+    "GROUP BY state.name, district.state_id ";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
				// Retrieve by column name
				
				String state_name = rs.getString("StateName");
				int count = rs.getInt("No_of_citizen");
				
				
				// Display values
				System.out.println(state_name+"\t"+count);
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

