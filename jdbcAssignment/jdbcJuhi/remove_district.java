package com.accolite.jdbcAssignment.jdbcJuhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.accolite.jdbcAssignment.utils.*;

public class remove_district {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;

	
public void remove() {
		
		try
		{
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
		pstmt = conn.prepareStatement("DELETE FROM database2.dbo.district WHERE D_ID= 1");
		pstmt.execute();
		
		pstmt = conn.prepareStatement("DELETE FROM database1.dbo.citizen WHERE D_ID= 1");
		pstmt.execute();
		
		System.out.println(" removed suceesfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

}

}
