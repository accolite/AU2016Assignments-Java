package com.accolite.jdbcAssignment.JdbcAssignmentPawan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class InsertIntoTablesManual {

	public void insert() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB1_URL, Constants.username, Constants.password);
			
			System.out.println("-------Insert data to District table-------");	
			
			pstmt = conn.prepareStatement("USE JdbcAssignmentDB1 ");
			pstmt.execute();
			
			
			pstmt = conn.prepareStatement("INSERT INTO dbo.district values(?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("distrit ID: ");
				String s1 = br.readLine();
				int districtID = Integer.parseInt(s1);

				System.out.println("district name: ");
				String districtName = br.readLine();
				
				
				System.out.println("headCitizenID: ");
				String s2 = br.readLine();
				int headCitizenID = Integer.parseInt(s2);

				System.out.println("State ID: ");
				String s3 = br.readLine();
				int stateID = Integer.parseInt(s3);

				pstmt.setInt(1, districtID);
				pstmt.setString(2, districtName);
				pstmt.setInt(3, headCitizenID);
				pstmt.setInt(4, stateID);

				pstmt.addBatch();

				System.out.println("Want to add more records ? y/n");

				String ans = br.readLine();
				if (ans.equals("n")) {
					break;
				}
			}
			pstmt.executeBatch();
			
			
			
			System.out.println("-------Insert data to State table-------");	
			PreparedStatement pstmt1 = null;
			pstmt1 = conn.prepareStatement("INSERT INTO dbo.state values(?,?,?)");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("State ID: ");
				String s1 = br1.readLine();
				int stateID = Integer.parseInt(s1);

				System.out.println("State name: ");
				String stateName = br1.readLine();
				
				
				System.out.println("presidentCitizenID: ");
				String s2 = br1.readLine();
				int presidentCitizenID = Integer.parseInt(s2);


				pstmt1.setInt(1, stateID);
				pstmt1.setString(2, stateName);
				pstmt1.setInt(3, presidentCitizenID);
				pstmt1.addBatch();

				System.out.println("Want to add more records ? y/n");

				String ans = br1.readLine();
				if (ans.equals("n")) {
					break;
				}
			}
			pstmt1.executeBatch();
			
			
			
			
			System.out.println("-------Insert data to president table-------");	
			PreparedStatement pstmt2 = null;
			pstmt2 = conn.prepareStatement("INSERT INTO dbo.president values(?,?)");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("President ID: ");
				String s1 = br2.readLine();
				int presidentID = Integer.parseInt(s1);

				System.out.println("President name: ");
				String presidentName = br2.readLine();
			
				pstmt2.setInt(1, presidentID);
				pstmt2.setString(2, presidentName);
				pstmt2.addBatch();

				System.out.println("Want to add more records ? y/n");

				String ans = br2.readLine();
				if (ans.equals("n")) {
					break;
				}
			}
			pstmt2.executeBatch();
			
			conn.close();

			System.out.println("-------Insert data to Citizen table-------");
			Connection conn1 = null;
			conn1 = DriverManager.getConnection(Constants.DB2_URL, Constants.username, Constants.password);
				
				
			PreparedStatement pstmt3 = null;
			pstmt3 = conn1.prepareStatement("USE JdbcAssignmentDB2 ");
			pstmt3.execute();
			
			pstmt3 = null;
			pstmt3 = conn1.prepareStatement("INSERT INTO dbo.citizen values(?,?,?,?,?)");
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Citizen ID: ");
				String s1 = br3.readLine();
				int citizenID = Integer.parseInt(s1);

				System.out.println("Citizen name: ");
				String citizenName = br3.readLine();
				
				
				System.out.println("age: ");
				String s2 = br3.readLine();
				int age = Integer.parseInt(s2);

				System.out.println("Type: ");
				String type = br3.readLine();
				
				
				System.out.println("District ID: ");
				String s3 = br3.readLine();
				int districtID = Integer.parseInt(s3);


				pstmt3.setInt(1, citizenID);
				pstmt3.setString(2, citizenName);
				pstmt3.setInt(3, age);
				pstmt3.setString(4, type);
				pstmt3.setInt(5, districtID);
				pstmt3.addBatch();

				System.out.println("Want to add more records ? y/n");

				String ans = br3.readLine();
				if (ans.equals("n")) {
					break;
				}
			}
			pstmt3.executeBatch();
			
			
			
			System.out.println("Record Successfully saved");
			conn1.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
