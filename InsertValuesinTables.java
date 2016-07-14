package org.au.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.au.assignment.util.Constants;

public class InsertValuesinTables 
{
	static PreparedStatement pstmt = null;
	static Connection conn = null;
	
	void insert(String Table_Name) throws SQLException
	{
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		
		 if(Table_Name.equals("citizen"))
		 
		 {
			  insertUsingPreparedStatement(1,10,"Anshika","Agarwal",23,"DistrictHead",conn);
			  insertUsingPreparedStatement(2,20,"Shrema","Singh",22,"Common",conn);
			  insertUsingPreparedStatement(3,30,"Juhi","Jain",24,"President",conn);
			  insertUsingPreparedStatement(4,40,"Surya","Rao",25,"Common",conn);
			  insertUsingPreparedStatement(5,50,"Logitha","Vani",21,"Common",conn);
			  insertUsingPreparedStatement(6,10,"Sunny","Goel",61,"Common",conn);
			  
		 }
		 
		 if(Table_Name.equals("district"))
		 {
			 insertIntoDistrict(10,1,"Bijnor",02,conn);
			 insertIntoDistrict(30,3,"Delhi",03,conn);
			 insertIntoDistrict(20,2,"Bangalore",01,conn);
			 insertIntoDistrict(40,4,"Gwalior",04,conn);
			 insertIntoDistrict(50,5,"Lucknow",02,conn);
			 
		 }
		
		 if(Table_Name.equals("state"))
		 {
			 insertIntoState(02,"U.P",3,conn);
			 insertIntoState(03,"Delhi",3,conn);
			 insertIntoState(01,"Karnataka",3,conn);
			 insertIntoState(04,"M.P",3,conn);
			 insertIntoState(05,"Bihar",3,conn);
		 }
		
		 if(Table_Name.equals("president"))
		 {
			 insertIntoPresident(3,"Pranab Mukherjee",conn);
		 }
		
		 
	}
	
	private void insertUsingPreparedStatement(int cid, int did, String firstName, String lastName,int age,String type, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			String sql = "Use Country_Citizens "+ "INSERT INTO dbo.citizen values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.setInt(2, did);
			pstmt.setString(3, firstName);
			pstmt.setString(4, lastName);
			pstmt.setInt(5,age);
			pstmt.setString(6,type);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	private void insertIntoDistrict(int did, int hid, String Name,int stateId, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			String sql = "Use COUNTRY "+ "INSERT INTO dbo.District values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, did);
			pstmt.setInt(2, hid);
			pstmt.setString(3,Name);
			pstmt.setInt(4,stateId);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	private void insertIntoState(int sid, String Name,int Pid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			String sql = "Use COUNTRY "+ "INSERT INTO dbo.State values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			pstmt.setString(2,Name);
			pstmt.setInt(3,Pid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	private void insertIntoPresident(int Pid, String Name, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			String sql = "Use COUNTRY "+ "INSERT INTO dbo.President values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Pid);
			pstmt.setString(2,Name);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	private void closeResources() {
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
