package com.accolite.jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ListOfCitizensUnderState {
	 PreparedStatement pstmt = null;
	Connection conn = null;
	 Connection conn2 = null;
   Statement stmt = null,stmt2=null;
	public ListOfCitizensUnderState() {
		// TODO Auto-generated constructor stub
		}
	
		public  void displayingCitizenList()
		{
			try {
				//Scanner sc=new Scanner(System.in);
				conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB,Constants.username,Constants.password);
				stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String sql=" Select database2.dbo.Citizen.citizenId as citizenid,database2.dbo.Citizen.name as citizenname from database1.dbo.District inner join database1.dbo.State on database1.dbo.District.StateId=database1.dbo.State.stateId inner join database2.dbo.Citizen on database1.dbo.District.districtId=database2.dbo.Citizen.districtId where database1.dbo.State.stateId=23";
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
