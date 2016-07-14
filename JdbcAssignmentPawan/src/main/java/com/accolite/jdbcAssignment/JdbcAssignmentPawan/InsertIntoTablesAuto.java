package com.accolite.jdbcAssignment.JdbcAssignmentPawan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;




public class InsertIntoTablesAuto {


	public void insert() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB2_URL, Constants.username, Constants.password);
			// insert in citizen table
			pstmt = conn.prepareStatement("INSERT INTO JdbcAssignmentDB2.dbo.citizen values(?,?,?,?,?)");
				pstmt.setInt(1, 1);
				pstmt.setString(2, "Pawan1");
				pstmt.setInt(3, 22);
				pstmt.setString(4, "VIP");
				pstmt.setInt(5, 1);
				pstmt.addBatch();
				
				
				
				pstmt.setInt(1, 2);
				pstmt.setString(2, "Pawan2");
				pstmt.setInt(3, 22);
				pstmt.setString(4, "VIP");
				pstmt.setInt(5, 2);
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setString(2, "Pawan3");
				pstmt.setInt(3, 22);
				pstmt.setString(4, "VIP");
				pstmt.setInt(5, 3);
				pstmt.addBatch();
				
				pstmt.setInt(1, 4);
				pstmt.setString(2, "Pawan4");
				pstmt.setInt(3, 22);
				pstmt.setString(4, "VIP");
				pstmt.setInt(5, 4);
				pstmt.addBatch();
				
				pstmt.setInt(1, 5);
				pstmt.setString(2, "Pawan5");
				pstmt.setInt(3, 22);
				pstmt.setString(4, "VIP");
				pstmt.setInt(5, 5);
				pstmt.addBatch();
				
				
				pstmt.setInt(1, 6);
				pstmt.setString(2, "Modi");
				pstmt.setInt(3, 22);
				pstmt.setString(4, "VIP");
				pstmt.setInt(5, 5);
				pstmt.addBatch();
				
				pstmt.setInt(1, 7);
				pstmt.setString(2, "pawan7");
				pstmt.setInt(3, 22);
				pstmt.setString(4, "NORMAL");
				pstmt.setInt(5, 5);
				pstmt.addBatch();
				
				pstmt.setInt(1, 8);
				pstmt.setString(2, "pawan8");
				pstmt.setInt(3, 22);
				pstmt.setString(4, "NORMAL");
				pstmt.setInt(5, 5);
				pstmt.addBatch();
				
				pstmt.setInt(1, 9);
				pstmt.setString(2, "pawan9");
				pstmt.setInt(3, 89);
				pstmt.setString(4, "NORMAL");
				pstmt.setInt(5, 5);
				pstmt.addBatch();
				
				
				pstmt.executeBatch();
				
				conn.close();
				
			// 
				Connection conn1 = DriverManager.getConnection(Constants.DB1_URL, Constants.username, Constants.password);
				// insert in citizen table
				pstmt = conn1.prepareStatement("INSERT INTO JdbcAssignmentDB1.dbo.district values(?,?,?,?)");
			
				pstmt.setInt(1, 1);
				pstmt.setString(2, "aligarh");
				pstmt.setInt(3, 1);  // headCtizenID
				pstmt.setInt(4, 1);  // stateID
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setString(2, "agra");
				pstmt.setInt(3, 2);  // headCtizenID
				pstmt.setInt(4, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setString(2, "noida");
				pstmt.setInt(3, 3);  // headCtizenID
				pstmt.setInt(4, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 4);
				pstmt.setString(2, "bangaloreEAst");
				pstmt.setInt(3, 4);  // headCtizenID
				pstmt.setInt(4, 2);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 5);
				pstmt.setString(2, "bangaloreWEst");
				pstmt.setInt(3, 5);  // headCtizenID
				pstmt.setInt(4, 2);
				
				pstmt.addBatch();
				pstmt.executeBatch();
			// insert into president table
				pstmt = conn1.prepareStatement("INSERT INTO JdbcAssignmentDB1.dbo.state values(?,?,?)");
			
				pstmt.setInt(1, 1);
				pstmt.setString(2, "uttarPradesh");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setString(2, "Karanataka");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				pstmt.executeBatch();
				
			// insert into state table
				pstmt = conn1.prepareStatement("INSERT INTO JdbcAssignmentDB1.dbo.president values(?,?)");
			
				pstmt.setInt(1, 6);
				pstmt.setString(2, "Modi");
				
				
				pstmt.addBatch();

				
				pstmt.executeBatch();
	
		
			System.out.println("Record Successfully saved");
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
