package com.au.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.au.connection.Constants;

public class ManagerDao {

	public List<String> getAllEmployees() {
		List<String> employees = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			
			String sql;
			sql = "SELECT *FROM CHATBOX.dbo.employee";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String str = "";
				str += rs.getString("id");
				str += "\t";
				str += rs.getString("name");
				str += "\t";
				str += rs.getString("email");
				str += "\n";

				employees.add(str);

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

		return employees;

	}

}
