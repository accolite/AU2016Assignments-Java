package com.au.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import com.au.util.Constants;


public class DbTable2 {

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
			   sql="CREATE TABLE STATES (StateID INTEGER NOT NULL, StateName VARCHAR(50), PRIMARY KEY (StateID))";
			   stmt.executeUpdate(sql);
			   System.out.println("Table States has been Created\n");
			
		
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
			pstmt = conn.prepareStatement("INSERT INTO STATES values(?,?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
/*				System.out.println("enter state id");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);
*/
				System.out.println("enter state name");
				String Name = br.readLine();

				//pstmt.setInt(1, id);
				pstmt.setString(2, Name);

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

	public void updateDb1(int id ,String Name) {
		try {
			pstmt = conn.prepareStatement("UPDATE STATES set StateName=?, WHERE StateID = ?");
			pstmt.setInt(2, id);
			pstmt.setString(1, Name);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deleteDb1(int id) {
		try {
			pstmt = conn.prepareStatement("DELETE FROM STATES WHERE StateID = ?");
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
 
	
	public void retirve() {
		try {
			pstmt = conn.prepareStatement("SELECT * FROM STATES");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) );
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
