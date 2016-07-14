package com.accolite.jdbcAssignment.jdbcJuhi;
import com.accolite.jdbcAssignment.utils.*;

import java.sql.*;



public class Demo01Statements {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.Password);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			String sql;
			sql = "SELECT id, firstname, lastname, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.absolute(4);
			rs.relative(2);
			rs.afterLast();
			rs.moveToInsertRow();
			
			rs.updateInt(1, 110);
			rs.updateString(2, "Darth");
			rs.updateString(3, "Vader");
			rs.updateInt(4, 20);
			
			rs.insertRow();
			
			rs.beforeFirst();
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");

				// Display values
				System.out.println(id+"\t"+age+"\t"+first+"\t"+last);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}