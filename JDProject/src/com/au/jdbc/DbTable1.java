package com.au.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import com.au.util.Constants;


public class DbTable1 {

	PreparedStatement pstmt = null;
	Statement stmt;
	static Connection conn = null;
	ResultSet rs = null;
	 public void connect(){
			try {
				conn = DriverManager.getConnection(Constants.DB_URLD1,Constants.username,Constants.password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	public void createTable() {
		try {         
			conn = DriverManager.getConnection(Constants.DB_URLD1,Constants.username,Constants.password);
			System.out.println("Connected to Database_1\n");
			   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			   
			   String sql;
			   sql="CREATE TABLE PRESIDENTS (PresidentID INTEGER NOT NULL, Name VARCHAR(20), PRIMARY KEY (PresidentID))";
			   stmt.executeUpdate(sql);
			   System.out.println("Table Prsidents has been created\n");
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	public void insertDb1() {
			try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URLD1);
			pstmt = conn.prepareStatement("INSERT INTO PRESIDENTS values(?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
		/*		System.out.println("enter id");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);
*/
				System.out.println("enter name ");
				String st = br.readLine();

			//	pstmt.setInt(1, id);
				pstmt.setString(2, st);
				pstmt.addBatch();

				System.out.println("Want cant add more records ? y/n");

				String ans ="y";
				if (ans.equals("y")) {
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

	public void updateDb1(int id, String name) {
		try {
			pstmt = conn.prepareStatement("UPDATE PRESIDENTS set Name=? WHERE PresidentID = ?");
			pstmt.setInt(2, id);
			pstmt.setString(1, name);  
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deleteDb1(int id, Connection conn) {
		try {
				pstmt = conn.prepareStatement("DELETE FROM PRESIDENTS WHERE id = ?");
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
			pstmt = conn.prepareStatement("SELECT * FROM PRESIDENTS");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " +rs.getString(2) );
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
