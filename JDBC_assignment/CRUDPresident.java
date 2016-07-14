package Assignment;

import java.sql.*;

public class CRUDPresident {

	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;

	public void insertPresident(int userid, String name, int age, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("INSERT INTO dbo.president values(?,?,?)");
			pstmt.setInt(1, userid);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void updatePresident(int userid, String name, int age, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("UPDATE dbo.president set name=?,age=? WHERE userid = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, userid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deletePresident(int userid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("DELETE FROM dbo.president WHERE userid = ?");
			pstmt.setInt(1, userid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void retirveAllPresident(Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("SELECT * FROM dbo.president");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
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

	public static void main(String[] args) {

		CRUDPresident demo02 = new CRUDPresident();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			// insert
			demo02.insertPresident(1, "ank", 50, conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
