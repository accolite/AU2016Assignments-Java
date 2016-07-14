package org.au.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.au.util.Constants;

public class InsertData {
	
	PreparedStatement pstmt = null;
	Connection conn = null;
	
	
	public InsertData(){
		
		try {
			conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		insertPresident(1, 1);
		
		insertState(1, "Punjab");
		insertState(2, "Haryana");
		insertState(3, "Himachal Pradesh");
		insertState(4, "Uttrakhand");
		
		insertDistrict(1, "Barnala", 2, 1);
		insertDistrict(2, "Sangrur", 3, 1);
		insertDistrict(3, "Hisar", 4, 2);
		
		insertCitizen(1, "Diksha", 1, 23);
		insertCitizen(2, "Mitul", 2, 23);
		insertCitizen(3, "Arnika", 3, 21);
		insertCitizen(4, "Anshika", 1, 23);
		insertCitizen(5, "Ankita", 2, 21);
		insertCitizen(6, "Sanjali", 1, 21);
		
		insertRelation(1, 1, 4, "child");
		insertRelation(2, 2, 5, "Wife");
		closeResources();
		
	}
	
	private void insertPresident(int presidentID, int citizenID)
	{
		try{
		
			pstmt = conn.prepareStatement("INSERT INTO dbo.president values(?,?,1)");
			pstmt.setInt(1, presidentID);
			pstmt.setInt(2, citizenID);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				
		}
		
	}
	
	private void insertState(int stateID, String name)
	{
		try{
			pstmt = conn.prepareStatement("INSERT INTO dbo.state values(?,?,1)");
			pstmt.setInt(1, stateID);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				
		}
	}
	
	private void insertDistrict(int districtID, String name, int districtHeadID, int stateID)
	{
		try{
			pstmt = conn.prepareStatement("INSERT INTO dbo.district values(?,?,?,?,1)");
			pstmt.setInt(1, districtID);
			pstmt.setString(2, name);
			pstmt.setInt(3, districtHeadID);
			pstmt.setInt(4, stateID);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				
		}
	}
	
	private void insertCitizen(int citizenID, String name, int districtID, int age)
	{
		try{
			pstmt = conn.prepareStatement("INSERT INTO dbo.citizen values(?,?,?,?,1)");
			pstmt.setInt(1, citizenID);
			pstmt.setString(2, name);
			pstmt.setInt(3, districtID);
			pstmt.setInt(4, age);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {


		}
	}
	
	private void insertRelation(int relationID, int citizenID, int relatorID, String relation)
	{
		try{
			pstmt = conn.prepareStatement("INSERT INTO dbo.relation values(?,?,?,?)");
			pstmt.setInt(1, relationID);
			pstmt.setInt(2, citizenID);
			pstmt.setInt(3, relatorID);
			pstmt.setString(4, relation);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {


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
