package com.au.tomcatDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.au.connection.Constants;

public class userDao {

	public String getEmployee(String name) {
		Connection conn = null;
		Statement stmt = null;
		String str = "";

		try {

			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username,
					Constants.password);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String sql;
			sql = "SELECT *FROM tomcatAssignment.dbo.employee where name='" + name +"'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				str += rs.getString("employeeId");
				str += "\t";
				str += rs.getString("name");
				str += "\t";
				str += rs.getString("email");
				str += "\n";

				

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

		return str;
	}

}
