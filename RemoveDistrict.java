package org.au.assignment.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.au.assignment.util.Constants;

public class RemoveDistrict
{
	
	PreparedStatement pstmt = null;
	 Connection conn = null;
	  Connection conn2 = null;
	   java.sql.Statement stmt = null;
	Statement stmt2=null;
	  
	  public  void RemovingADistrict()
	  {
	   try {
	    Scanner sc=new Scanner(System.in);
	    conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    pstmt = conn.prepareStatement("DELETE FROM COUNTRY.dbo.District WHERE Did=?");
	    System.out.println("enter district id to be deleted");
	    int d=sc.nextInt();
	    pstmt.setInt(1, d);
	    pstmt.executeUpdate();
	    pstmt = conn.prepareStatement("DELETE FROM Country_Citizens.dbo.Citizen WHERE Did=?");
	    pstmt.setInt(1, d);
	    pstmt.executeUpdate();
	       } catch (Exception e) {
	    e.printStackTrace();
	   } 
	  }
	  
	  
	  

}
