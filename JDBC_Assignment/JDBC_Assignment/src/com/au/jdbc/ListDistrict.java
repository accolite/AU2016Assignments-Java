package com.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.au.util.Constants;



public class ListDistrict {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;
	
	public void retirve() throws SQLException {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("SELECT Name FROM dbo.District");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
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
