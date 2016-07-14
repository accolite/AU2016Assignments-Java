package com.au.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import com.au.util.Constants;

public class Db1Table {

	PreparedStatement pstmt = null;
	Statement stmt;
	static Connection conn = null;
	ResultSet rs = null;
    
	 public void connect(){
			try {
				conn = DriverManager.getConnection(Constants.DB_URLD2,Constants.username,Constants.password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	
	public void createTable() {
		try {         
			conn = DriverManager.getConnection(Constants.DB_URLD2,Constants.username,Constants.password);
			System.out.println("Connected to Database_1\n");
			   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			   
			   String sql;
 
			   sql="CREATE TABLE CITIZENS (CitizenID INTEGER NOT NULL, CitizenName VARCHAR(50),Age INTEGER,DistrictID INTEGER,Relation VARCHAR(50) DEFAULT null,PRIMARY KEY(CitizenID))";
			      stmt.executeUpdate(sql); 
			    
			   System.out.println("Table Citizens has been created\n");			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	public void insertDb1() {
			try {
				pstmt = conn.prepareStatement("INSERT INTO CITIZENS values(?,?,?,?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				
				System.out.println(" name");
				String Name = br.readLine();

				System.out.println("age");
				String s2 = br.readLine();
				int age = Integer.parseInt(s2);
								
				System.out.println("enter district id");
				String s1 = br.readLine();
				int did = Integer.parseInt(s1);

				System.out.println("relation ");
				String rel = br.readLine();
				
				pstmt.setInt(3, age);
				pstmt.setString(2, Name);
				pstmt.setInt(4, did);
				pstmt.setString(5, rel);
				pstmt.addBatch();

				System.out.println("Want to add more records ? y/n");

				String ans = br.readLine();
				if (ans.equals("n")) {
					break;
				}
			}
	
			pstmt.executeBatch();
			System.out.println("Record Successfully saved");
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void updateDb1(int cid,String Name, int age, int did,String rel) {
		try {
			pstmt = conn.prepareStatement("UPDATE CITIZENS set CitizenName=?,Age=?,DistrictID=?,Relation=? WHERE CitizenID=?");
			pstmt.setString(1, Name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, did);
			pstmt.setString(4, rel);
			pstmt.setInt(5, cid);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deleteDb(int id) {
		try {
		   pstmt = conn.prepareStatement("DELETE FROM CITIZENS WHERE CitizenID = ?");
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
 
	
	public void retirve(Connection conn) {
		try {
     		pstmt = conn.prepareStatement("SELECT * FROM CITIZENS");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

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














/*
package com.au.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import com.au.util.Constants;


public class Db1Table {

	public static void main(String[] args) {


	}


}
*/