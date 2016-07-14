package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangeHead {

	
	public void ChangeDistrictHead(String district,String citizen)
	{
			Connection conn = null;
			Statement stmt = null;
			Statement stmt1 = null;
			try {
			
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				
				conn = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String sql,sql1;
				sql = "SELECT citizen.citizen_id as CitizenID "
    + 	"FROM Database2.dbo.Citizen citizen  "
    +" WHERE citizen.name = " + "'"+citizen+"'";
    
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
				// Retrieve by column name
				
				
				int cid = rs.getInt("CitizenID");
				sql1 = "UPDATE  Database1.dbo.District  SET head_id = "+ cid
						+ "  WHERE name = " +  "'"+district+"'";
				stmt1.executeUpdate(sql1);
				// Display values
				//System.out.println(cname);
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


