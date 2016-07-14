package com.accolite.jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DisplayCitizenCount {
	 PreparedStatement pstmt = null;
	Connection conn = null;
	 Connection conn2 = null;
   Statement stmt = null,stmt2=null;
	public DisplayCitizenCount() {
		// TODO Auto-generated constructor stub
		}
	
		public  void displayingCitizenCount()
		{
			try {
				//Scanner sc=new Scanner(System.in);
				conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB,Constants.username,Constants.password);
				stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String sql=" Select Count(database2.dbo.Citizen.citizenId) as total,database1.dbo.State.stateId as Stateid from database1.dbo.District inner join database1.dbo.State on database1.dbo.District.StateId=database1.dbo.State.stateId inner join database2.dbo.Citizen on database1.dbo.District.districtId=database2.dbo.Citizen.districtId group by(database1.dbo.State.stateId )";
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
