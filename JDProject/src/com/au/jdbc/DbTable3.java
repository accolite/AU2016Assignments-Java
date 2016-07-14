package com.au.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import com.au.util.Constants;


public class DbTable3 {

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

			   sql="CREATE TABLE DISTRICTS (DistrictID INTEGER NOT NULL, Name VARCHAR(50),StateID INTEGER,HeadCitizenID INTEGER, PRIMARY KEY(DistrictID))";
			   stmt.executeUpdate(sql);
			   System.out.println("Table Districts has been created\n");			
		
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
			pstmt = conn.prepareStatement("INSERT INTO DISTRICTS values(?,?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				
				System.out.println(" name");
				String Name = br.readLine();
				
				System.out.println("enter stateid");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter headid");
				String s2 = br.readLine();
				int hid = Integer.parseInt(s2);

				pstmt.setInt(3, id);
				pstmt.setString(2, Name);
				pstmt.setInt(4, hid);

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

	public void updateDb1(int did,String Name, int hid, int sid) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("UPDATE DISTRICTS set Name=?,StateID=?,HeadCitizenID=? WHERE DistrictID= ?");
			pstmt.setString(1, Name);
			pstmt.setInt(2, sid);
			pstmt.setInt(3,hid );
			pstmt.setInt(4, did);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deleteDb1(int id) {
		try {
		   pstmt = conn.prepareStatement("DELETE FROM DISTRICTS WHERE DistrictID = ?");
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
     		pstmt = conn.prepareStatement("SELECT * FROM DISTRICTS");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getInt(4));
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
