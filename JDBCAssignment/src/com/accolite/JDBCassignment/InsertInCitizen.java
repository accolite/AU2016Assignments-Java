package com.accolite.JDBCassignment;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.accolite.util.Constants;
public class InsertInCitizen {
	public void Insert() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL2,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("INSERT INTO db2.CITIZENS values(?,?,?,?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("enter CitizenID");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter CitizenName");
				String name = br.readLine();
				
				System.out.println("enter Age");
				String s2 = br.readLine();
				int age = Integer.parseInt(s2);

				System.out.println("enter DistrictID");
				String s3 = br.readLine();
				int districtid = Integer.parseInt(s3);
				
				System.out.println("enter SpouseID");
				String s4 = br.readLine();
				int spid = Integer.parseInt(s4);
				
				System.out.println("enter RelationWIthPresident");
				String rel = br.readLine();
				

				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setInt(4, districtid);
				pstmt.setInt(5, spid);
				pstmt.setString(6, rel);
				
			
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
}
