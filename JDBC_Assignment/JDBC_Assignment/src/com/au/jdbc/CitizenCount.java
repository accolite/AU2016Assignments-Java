package com.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.au.util.Constants;



public class CitizenCount {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;
	
	public void count() throws SQLException {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
			String query=new String("select ads.Name,Count(adc.StateID) from Assignment_DB1.dbo.State ads left join Assignment_DB2.dbo.Citizen adc on ads.StateID=adc.StateID  Group by adc.StateID,ads.Name");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+ rs.getInt(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}

	}

}
