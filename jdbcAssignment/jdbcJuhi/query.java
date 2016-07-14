package com.accolite.jdbcAssignment.jdbcJuhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.accolite.jdbcAssignment.utils.*;

public class query {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;
	update_head u=new update_head();

	private void display_state() {
	
		try
		{
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
		pstmt = conn.prepareStatement("Select  Name FROM  database2.dbo.state");
		rs=pstmt.executeQuery();
		while(rs.next())
		System.out.println(rs.getString(1));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

}

	private void display_district() {
		
		try
		{
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
		pstmt = conn.prepareStatement("Select Name FROM  database2.dbo.district");
		rs=pstmt.executeQuery();
		while(rs.next())
		System.out.println(rs.getString(1));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

}
	

private void display_head_district() {
	
	try
	{
	conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
	pstmt = conn.prepareStatement(" Select database1.dbo.citizen.C_Id as citizenid,database1.dbo.citizen.Name as citizenname from database2.dbo.district inner join database1.dbo.citizen on database2.dbo.district.Head_Id=database1.dbo.citizen.C_Id where database2.dbo.district.D_Id=2 ");
	rs=pstmt.executeQuery();
	while(rs.next())
	System.out.println(rs.getString(2));
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	

}

private void display_citizen_count() {
	
	try
	{
	conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
	pstmt = conn.prepareStatement(" Select Count(database1.dbo.citizen.C_Id) as total,database2.dbo.state.state_Id as Stateid from database2.dbo.district inner join database2.dbo.state on database2.dbo.district.State_Id=database2.dbo.state.state_Id inner join database1.dbo.citizen on database2.dbo.district.D_Id=database1.dbo.citizen.D_Id group by(database2.dbo.state.state_Id)  ");
	rs=pstmt.executeQuery();
	while(rs.next())
	System.out.println(rs.getString(2));
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	

}




	
	
	
	
	 public static void main(String args[])
		{
          query q=new query();
		  System.out.println("\n 1.list all states \n 2.list all districts \n 3. display all citizen count for states \n 4.remove a citizen \n 5. remove a state");
          System.out.println("\n 6.list all citizen under state \n 7.list all citizen under district \n 8.show head of district  \n 9.change head of district \n 10.list all technical details");
          Scanner scanner = new Scanner(System.in);  
          int choice=(scanner.nextInt());
          citizencount c=new citizencount();
          ques7 qq=new ques7();
          update_head uu =new update_head();
          remove_district r =new remove_district();
          switch(choice)
          {
          	case 1:q.display_state();
          	break;
          	case 2:q.display_district();
          	break;
          	case 3:q.display_citizen_count();
          	break;
          	case 4:r.remove();
          	break;
          	case 6:
          		c.display_citizen_under_ditrict();
          	break;
          	case 7:qq.display_citizen_under_state();
          	break;
          	case 8:q.display_head_district();
          	break;
          	case 9:uu.update();
          	break;
          }
          
          
      }
}