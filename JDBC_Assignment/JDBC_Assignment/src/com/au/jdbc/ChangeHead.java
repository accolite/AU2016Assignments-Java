


package com.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.au.util.Constants;



public class  ChangeHead {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	
	
	public void change(String s) throws SQLException {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL2,Constants.username,Constants.password);
			String query=new String("Update Assignment_DB2.dbo.Citizen set isHead='Yes' where Name=? and isActive='Yes'");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, s);
			pstmt.executeUpdate();
			query="Update Assignment_DB2.dbo.Citizen set isHead='No' where Name!=? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, s);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			pstmt.close();
			conn.close();
		}

	}

}
