package com.accolite.jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class RemoveADistrict {
	 PreparedStatement pstmt = null;
	Connection conn = null;
	 Connection conn2 = null;
   Statement stmt = null,stmt2=null;
  // PreparedStatement pstmt = null;
	public RemoveADistrict() {
		// TODO Auto-generated constructor stub
		}
	
		public  void RemovingADistrict()
		{
			try {
				Scanner sc=new Scanner(System.in);
				conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB,Constants.username,Constants.password);
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				   //stmt = conn.createStatement();
				pstmt = conn.prepareStatement("DELETE FROM database1.dbo.District WHERE districtID=?");
				System.out.println("enter district id to be deleted");
				int d=sc.nextInt();
				pstmt.setInt(1, d);
				  pstmt.executeUpdate();
				  pstmt = conn.prepareStatement("DELETE FROM database2.dbo.Citizen WHERE districtID=?");
				  pstmt.setInt(1, d);
				  pstmt.executeUpdate();
				   
				   
				
				
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
