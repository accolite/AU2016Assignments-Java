package org.au.assignment.JDBCAssignement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AllDistrictsList {
	 PreparedStatement pstmt = null;
	  Connection conn = null;
	   Connection conn2 = null;
	    Statement stmt = null,stmt2=null;
	 public AllDistrictsList() {
	  // TODO Auto-generated constructor stub
	 }
	 public void listingAllDistricts()
	 {
	  try {
	   Scanner sc=new Scanner(System.in);
	   conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
	   stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	   String sql="use [1stDatabase] Select name,districtId from District";
	   ResultSet rs = stmt.executeQuery(sql);
	   rs.beforeFirst();
	   while(rs.next()) {
	    int id = rs.getInt("districtId");
	    String name = rs.getString("name");
	    // Display values
	    System.out.println(id+"\t"+name+"\t");
	    
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
