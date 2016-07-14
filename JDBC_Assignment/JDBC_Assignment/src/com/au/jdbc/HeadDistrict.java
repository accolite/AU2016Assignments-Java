

package com.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.au.util.Constants;



public class HeadDistrict {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;
	
	public void head() throws SQLException {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
			String query=new String("select ads.Name,adc.Name  from Assignment_DB1.dbo.District ads  join Assignment_DB2.dbo.Citizen adc on ads.DistrictID=adc.DistrictID where adc.isHead='Yes' Order by ads.DistrictID");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("District: "+rs.getString(1)+"  Head: "+ rs.getString(2));
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
