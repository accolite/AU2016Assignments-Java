package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accolite.au.jdbc.util.Constants;

public class State {
	
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet resultSet;
	
	public void createConnection() throws SQLException{
		conn = DriverManager.getConnection(Constants.ORG_DB_URL);
	}
	
	public void displayAll(){
		try{
			createConnection();
			pstmt = conn.prepareStatement("SELECT * FROM Org.dbo.State");
			resultSet = pstmt.executeQuery();
			System.out.println("State ID \t State Name");
			while(resultSet.next()){
				System.out.println(resultSet.getInt("ID")+" \t\t "+resultSet.getString("Name"));
			}
		}
		catch(SQLException e){
			
		}
		finally{
			closeConnections();
		}
	}
	
	public boolean removeState(String stateName){
		Boolean result = false;
		try{
			createConnection();
			pstmt = conn.prepareStatement("DELETE FROM Org.dbo.State "
					+ "WHERE State.Name = ?");
			pstmt.setString(1, stateName);
			pstmt.executeUpdate();
			result = true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			closeConnections();
		}
		return result;
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
		State s = new State();
		s.displayAll();
	}
}
