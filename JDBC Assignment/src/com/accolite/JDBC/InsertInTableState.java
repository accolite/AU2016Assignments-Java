package com.accolite.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.accolite.util.Constants;

public class InsertInTableState {
	public void Insert() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL1,Constants.username,Constants.password);
			pstmt = conn.prepareStatement("INSERT INTO dbo.STATES values(?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("enter StateID");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter StateName");
				String name = br.readLine();
				

				pstmt.setInt(1, id);
				pstmt.setString(2, name);
			
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