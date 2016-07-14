package org.au.assignment.JDBCAssignement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CitizenCountDisplay {
	
	 PreparedStatement pstmt = null;
	 Connection conn = null;
	  Connection conn2 = null;
	   Statement stmt = null,stmt2=null;
	 public CitizenCountDisplay() {
	  // TODO Auto-generated constructor stub
	  }
	 
	  public  void displayingCitizenCount()
	  {
	   try {
	    //Scanner sc=new Scanner(System.in);
	    conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
	    stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    String sql=" Select Count(2ndDatabase.dbo.Citizen.citizenId) as total,1stDatabase.dbo.State.stateId as Stateid from 1stDatabase.dbo.District inner join 1stDatabase.dbo.State on 1stDatabase.dbo.District.StateId=1stDatabase.dbo.State.stateId inner join 2ndDatabase.dbo.Citizen on 1stDatabase.dbo.District.districtId=2ndDatabase.dbo.Citizen.districtId group by(1stDatabase.dbo.State.stateId )";
	     ResultSet rs=stmt.executeQuery(sql);
	     rs.beforeFirst();
	     while(rs.next()) {
	      int id = rs.getInt("total");
	      int name=rs.getInt("Stateid");
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
