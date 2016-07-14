package Assignment;

import java.sql.*;

public class CRUDState {

	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;

	public void insertState(int stateid, String name, int headuserid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("INSERT INTO dbo.state values(?,?,?)");
			pstmt.setInt(1, stateid);
			pstmt.setString(2, name);
			pstmt.setInt(3, headuserid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void updateState(int stateid, String name, int headuserid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("UPDATE dbo.state set name=?,headuserid=? WHERE stateid = ?");

			pstmt.setString(1, name);
			pstmt.setInt(2, headuserid);
			pstmt.setInt(3, stateid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deleteState(int stateid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("DELETE FROM dbo.state WHERE stateid = ?");
			pstmt.setInt(1, stateid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void retirveAllState(Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("SELECT * FROM dbo.state");
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

		CRUDState demo02 = new CRUDState();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			// insert
			demo02.insertState(1, "UP ", 2, conn);
			demo02.insertState(1, "MP ", 5, conn);
			// demo02.updateState(2,"MP",5,conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
