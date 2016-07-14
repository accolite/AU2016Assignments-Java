package com.accolite.JDBCassignment;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.accolite.util.Constants;

public class InsertInTableDistricts {
	public void Insert() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL1,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("INSERT INTO db1.DISTRICTS values(?,?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("enter DistrictID");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter DistrictName");
				String name = br.readLine();
				
				System.out.println("enter StateID");
				String s2 = br.readLine();
				int stateid = Integer.parseInt(s2);

				System.out.println("enter HeadCitizenID");
				String s3 = br.readLine();
				int headcitizenid = Integer.parseInt(s3);

				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, stateid);
				pstmt.setInt(4, headcitizenid);
				
			
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
