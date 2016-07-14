package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accolite.au.jdbc.util.Constants;

public class Citizen {
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet resultSet;
	
	public void createConnection() throws SQLException{
		conn = DriverManager.getConnection(Constants.PEOPLE_DB_URL);
	}
	
	public void displayAll(){
		try{
			createConnection();
			pstmt = conn.prepareStatement("SELECT * FROM People.dbo.Citizen citizen WHERE citizen.Active = 1");
			resultSet = pstmt.executeQuery();
			System.out.println("Citizen ID \t Citizen Name \t Age");
			while(resultSet.next()){
				System.out.println(resultSet.getInt("ID")+" \t\t "+resultSet.getString("Name")+" \t "+resultSet.getInt("Age"));
			}
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
	}
	
	public void displayCitizenCountByState(){
		try{
			createConnection();
			String sql = "SELECT state.Name as StateName, count(district.StateID) as No_of_citizen "
					+ "FROM People.dbo.Citizen citizen, Org.dbo.State state, Org.dbo.District district "
					+ "WHERE citizen.DistrictID = district.ID "
					+ "AND district.StateID = state.ID "
					+ "AND citizen.Active = 1 "
					+ "GROUP BY state.Name, district.StateID";
			pstmt = conn.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			System.out.println("State Name \t No of citizens");
			while(resultSet.next()){
				System.out.println(resultSet.getString("StateName")+" \t\t "+resultSet.getString("No_of_citizen"));
			}
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
	}
	
	public void displayCitizenByDistrict(String districtName){
		try{
			createConnection();
			String sql = "SELECT citizen.Name name, citizen.Age age "
					+ "FROM People.dbo.Citizen citizen, Org.dbo.District district "
					+ "WHERE  citizen.Active = 1 "
					+ "AND citizen.DistrictID = district.ID "
					+ "AND district.Name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,districtName);
			resultSet = pstmt.executeQuery();
			System.out.println("Name \t Age");
			while(resultSet.next()){
				System.out.println(resultSet.getString("name")+" \t "+resultSet.getString("age"));
			}
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
	}
	
	public void displayCitizenByState(String stateName){
		try{
			createConnection();
			String sql = "SELECT citizen.Name, citizen.Age "
					+ "FROM People.dbo.Citizen citizen, Org.dbo.District district, Org.dbo.State state "
					+ "WHERE citizen.DistrictID = district.ID "
					+ "AND district.StateID = state.ID "
					+ "AND citizen.Active = 1"
					+ "AND state.Name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stateName);
			resultSet = pstmt.executeQuery();
			System.out.println("Name \t Age");
			while(resultSet.next()){
				System.out.println(resultSet.getString("name")+" \t "+resultSet.getString("age"));
			}
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
	}
	
	public void displayTechnicalDetails(){
		try{
			createConnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
//			resultSet = dbmd.getTableTypes();
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
		

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
		Citizen c = new Citizen();
		c.displayAll();
//		c.displayCitizenCountByState();
//		c.displayCitizenByDistrict("chennai");
//		c.displayCitizenByState("tamilnadu");
	}
}
