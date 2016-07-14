package com.accolite.jdbcAssignment.jdbcJuhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.accolite.jdbcAssignment.utils.*;

public class citizencount {
	
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;

	
public void display_citizen_under_ditrict() {
		
		try
		{
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
		pstmt = conn.prepareStatement(" Select database1.dbo.citizen.C_Id ,database1.dbo.citizen.Name as citizenname from database1.dbo.citizen where database1.dbo.citizen.D_Id=1");
		rs=pstmt.executeQuery();
		while(rs.next())
		System.out.println(rs.getString(1)+ "\t" + rs.getString(2));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

}

}
