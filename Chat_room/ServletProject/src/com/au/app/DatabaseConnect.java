package com.au.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.au.util.Constants;

public class DatabaseConnect {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;

	public void insertWord(String words) {
		try {
		   		    
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			 String[] prohibwords = words.split(","); 
			    int n=prohibwords.length;
			    for(int i=0;i<n;i++){
					pstmt = conn.prepareStatement("INSERT INTO dbo.Words values(?)");	
					pstmt.setString(1,prohibwords[i]);
					pstmt.executeUpdate();
				}      
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void insertUser(String name,String uname,String password) {
		try {
		
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("INSERT INTO dbo.Users values(?,?,?)");
			pstmt.setString(1,name);
			pstmt.setString(2,uname);
			pstmt.setString(3, password);
			System.out.println("added"+"to "+Constants.DB_URL);	
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	public void insertMessage(String name,String text) {
		try {
			
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("INSERT INTO dbo.Messages values(?,?)");
			pstmt.setString(1,name);
			pstmt.setString(2,text);	
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	public String getMessages() {
		String message="";
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("SELECT * FROM dbo.Messages");
			rs = pstmt.executeQuery();
			while (rs.next()) {
			message=message+rs.getString(1)+":"+rs.getString(2)+"<br>";
				}       
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return message;

	}
	public boolean verifyuser(String name,String password) {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("SELECT * FROM dbo.Users");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(((rs.getString(2)).equals(name))&&(rs.getString(3).equals(password))){
					return true;
				}       
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return false;

	}
	public String getName(String uname) {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("SELECT * FROM dbo.Users");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if((rs.getString(2)).equals(uname)){
					return rs.getString(1);
				}       
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return uname;

	}
	
	public boolean verifyword(String word) {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("SELECT * FROM dbo.Words");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if((rs.getString(1)).equals(word)){
					return true;
				}       
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return false;

	}

	public void closeResources() {
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
