package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ListDistricts {

	public void displayDistricts()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
		
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
		
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
			String sql;
			sql = "SELECT * from dbo.District";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
			// Retrieve by column name
			int did = rs.getInt("district_id");
			int sid = rs.getInt("state_id");
			String district_name = rs.getString("name");
			int hid = rs.getInt("head_id");
			int status = rs.getInt("flag");
			//String last = rs.getString("last");

			// Display values
			System.out.println(did+"\t"+district_name+"\t"+hid+"\t"+sid+"\t"+status);
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

