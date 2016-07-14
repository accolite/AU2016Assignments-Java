package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accolite.au.jdbc.util.Constants;

public class District {
	
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet resultSet;
	
	public void createConnection() throws SQLException{
		conn = DriverManager.getConnection(Constants.ORG_DB_URL);
	}
	
	public void displayAll(){
		try{
			createConnection();
			pstmt = conn.prepareStatement("SELECT d.ID as ID, d.Name as DName, s.Name as SName FROM Org.dbo.District d, Org.dbo.State s WHERE d.StateID = s.ID");
			resultSet = pstmt.executeQuery();
			System.out.println("District ID \t District Name\t State Name");
			while(resultSet.next()){
				System.out.println(resultSet.getInt("ID")+" \t\t "+resultSet.getString("DName")+" \t\t "+resultSet.getString("SName"));
			}
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
	}
	
	public boolean removeDistrict(String districtName){
		Boolean result = false;
		try{
			createConnection();
			pstmt = conn.prepareStatement("DELETE FROM Org.dbo.District "
					+ "WHERE Org.dbo.District.Name = ?");
			pstmt.setString(1, districtName);
			pstmt.executeUpdate();
			result = true;
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
		return result;
	}
	
	public boolean removeHead(String districtName){
		Boolean result = false;
		try{
			createConnection();
			pstmt = conn.prepareStatement("UPDATE Org.dbo.District SET head = NULL WHERE Name=?");
			pstmt.setString(1, districtName);
			pstmt.execute();
			result = true;
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
		return result;
	}
	
	public boolean changeHead(String districtName, String headName){
		Boolean result = false;
		try{
			createConnection();
			pstmt = conn.prepareStatement("UPDATE Org.dbo.District SET head = (SELECT TOP 1 citizen.ID FROM People.dbo.Citizen citizen WHERE citizen.Name = ?)  WHERE District.Name=?");
			pstmt.setString(1, headName);
			pstmt.setString(2, districtName);
			pstmt.execute();
			result = true;
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
		return result;
	}
	
	public String getHead(String districtName){
		String headName = null;
		try{
			createConnection();
			pstmt = conn.prepareStatement("SELECT citizen.Name "
					+ "FROM People.dbo.Citizen citizen, Org.dbo.District district "
					+ "WHERE district.Head = citizen.ID "
					+ "AND district.Name=?");
			pstmt.setString(1, districtName);
			resultSet = pstmt.executeQuery();
			if(resultSet.next())
				headName = resultSet.getString(1);
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
		return headName;
	}
	
	public void closeConnections(){
		try{
			if(resultSet != null)
				resultSet.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}
		catch(SQLException e){
			
		}
	}
	
	public static void main(String[] args) {
		District d = new District();
//		d.displayAll();
		System.out.println("Head of district is "+d.getHead("chennai"));
	}
}
