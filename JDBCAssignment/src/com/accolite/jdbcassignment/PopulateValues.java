package com.accolite.jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class PopulateValues {
	 PreparedStatement pstmt = null;
	Connection conn = null;
	 Connection conn2 = null;
   Statement stmt = null,stmt2=null;
	public PopulateValues() {
		// TODO Auto-generated constructor stub
		}
	
		public  void populateValuesIntoTables()
		{
			Scanner sc=new Scanner(System.in);
				System.out.println("Enter 1 for citizen,2 for district,3 for state,4 for President");
				
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1: Citizen();
				break;
				case 2: District();
				break;
				case 3: State();
				break;
				case 4:President();
				break;
				default:System.out.println("INVALID CHOICE");
				}
		}
		public void Citizen()
		{
			try {
				Scanner sc=new Scanner(System.in);
				conn = DriverManager.getConnection(Constants.DB_URL_datatbase1,Constants.username,Constants.password);
				pstmt = conn.prepareStatement("use database2 "+ "INSERT INTO dbo.Citizen values(?,?,?,?,?)");
				System.out.println("Enter citizenid ,districtid,name,age,type");
				int cid=sc.nextInt();
				int did=sc.nextInt();
				String name=sc.next();
				int age=sc.nextInt();
				String type=sc.next();
				pstmt.setInt(1, cid);
				pstmt.setInt(2, did);
				pstmt.setString(3, name);
				pstmt.setInt(4, age);
				pstmt.setString(5, type);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeResources();
			}
		}
		public void District()
		{
			try {
				Scanner sc=new Scanner(System.in);
				conn = DriverManager.getConnection(Constants.DB_URL_datatbase1,Constants.username,Constants.password);
				pstmt = conn.prepareStatement("use database1 "+"INSERT INTO dbo.District values(?,?,?,?)");
				System.out.println("Enter districtid ,headid,name,stateid");
				int did=sc.nextInt();
				int hid=sc.nextInt();
				String name=sc.next();
				int sid=sc.nextInt();
				pstmt.setInt(1, did);
				pstmt.setInt(2, hid);
				pstmt.setString(3, name);
				pstmt.setInt(4, sid);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeResources();
			}
		}
		public  void State()
		{
			try {
				Scanner sc=new Scanner(System.in);
				conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB,Constants.username,Constants.password);
				pstmt = conn.prepareStatement("use database1 "+"INSERT INTO dbo.State values(?,?,?)");
				System.out.println("Enter stateid ,name,Presidentid");
				int sid=sc.nextInt();
				String name=sc.next();
				int pid=sc.nextInt();
				pstmt.setInt(1, sid);
				pstmt.setString(2,name);
				pstmt.setInt(3, pid);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeResources();
			}
		}
		public  void President()
		{
			try {
				Scanner sc=new Scanner(System.in);
				conn = DriverManager.getConnection(Constants.DB_URL_datatbase1,Constants.username,Constants.password);
				pstmt = conn.prepareStatement("use database1 "+"INSERT INTO dbo.President values(?,?)");
				System.out.println("Enter Presidentid ,name");
				int pid=sc.nextInt();
				String name=sc.next();
				pstmt.setInt(1,pid);
				pstmt.setString(2,name);
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
