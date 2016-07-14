


package com.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.au.util.Constants;



public class  RemoveDistrict {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	
	
	public void Remove(String s) throws SQLException {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
			String query=new String("Update Assignment_DB2.dbo.Citizen  set isActive='No',isHead='No',DistrictID=null from Assignment_DB2.dbo.Citizen adc join Assignment_DB1.dbo.District ad on adc.DistrictID=ad.DistrictID where ad.Name=?");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, s);
			pstmt.executeUpdate();
			query="Delete  from Assignment_DB1.dbo.District where Name=?";
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
