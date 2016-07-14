package org.au.assignment.JDBCAssignement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CitizensListUnderDistrict {
	PreparedStatement pstmt = null;
	 Connection conn = null;
	  Connection conn2 = null;
	   Statement stmt = null,stmt2=null;
	 public CitizensListUnderDistrict() {
	  // TODO Auto-generated constructor stub
	  }
	 
	  public  void displayingCitizenListDistrict()
	  {
	   try {
	    //Scanner sc=new Scanner(System.in);
	    conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
	    stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    String sql=" Select 2ndDatabase.dbo.Citizen.citizenId as citizenid,2ndDatabase.dbo.Citizen.name as citizenname from 1stDatabase.dbo.District inner join 1stDatabase.dbo.State on 1stDatabase.dbo.District.StateId=1stDatabase.dbo.State.stateId inner join 2ndDatabase.dbo.Citizen on 1stDatabase.dbo.District.districtId=2ndDatabase.dbo.Citizen.districtId where 1stDatabase.dbo.District.districtId=34";
	     ResultSet rs=stmt.executeQuery(sql);
	     rs.beforeFirst();
	     while(rs.next()) {
	      int id = rs.getInt("citizenid");
	      String name=rs.getString("citizenname");
	      System.out.println(id+" "+name);
	     }
	    rs.close();
	    
	   } catch (Exception e) {
	    e.printStackTrace();
	   } finally {
	    closeResources();
	   }
	  }
	  private  void closeResources() {
	   try {
	    if (pstmt != null)
	     pstmt.close();
	   } catch (SQLException se2) {
	    se2.printStackTrace();
	   }
	   try {
	    if (conn != null)
	     conn.close();
	   } catch (SQLException se) {
	    se.printStackTrace();
	   }
	  }

}
