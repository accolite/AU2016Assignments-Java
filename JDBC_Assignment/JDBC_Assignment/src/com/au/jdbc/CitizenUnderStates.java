package com.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.au.util.Constants;



public class CitizenUnderStates {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;
	
	public void count() throws SQLException {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
			String query=new String("select adc.Name,ads.Name from Assignment_DB1.dbo.State ads  join Assignment_DB2.dbo.Citizen adc on ads.StateID=adc.StateID  Order by ads.StateID");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("Name: "+rs.getString(1)+"  State: "+ rs.getString(2));
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
