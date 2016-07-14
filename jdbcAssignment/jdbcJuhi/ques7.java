package com.accolite.jdbcAssignment.jdbcJuhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.accolite.jdbcAssignment.utils.*;

public class ques7 {
	
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;

	
	public void display_citizen_under_state() {
		
		try
		{
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
		pstmt = conn.prepareStatement(" Select database1.dbo.citizen.C_Id as citizenid,database1.dbo.citizen.Name as citizenname from database2.dbo.district inner join database2.dbo.State on database2.dbo.district.State_Id=database2.dbo.state.state_Id inner join database1.dbo.citizen on database2.dbo.district.D_Id=database1.dbo.citizen.D_Id where database2.dbo.district.state_Id=3");
		rs=pstmt.executeQuery();
		while(rs.next())
		System.out.println(rs.getString(2));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}