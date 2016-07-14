package Assignment;

import java.sql.*;

public class CRUDCitizen {

	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;

	public void insertCitizen(int userid, String name, int age, int districtid, String designation, int relativeid,
			Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL2);
			pstmt = conn.prepareStatement("INSERT INTO dbo.citizen values(?,?,?,?,?,?)");
			pstmt.setInt(1, userid);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setInt(4, districtid);
			pstmt.setString(5, designation);
			pstmt.setInt(6, relativeid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void updateCitizen(int userid, String name, int age, int districtid, String designation, int relativeid,
			Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL2);
			pstmt = conn.prepareStatement(
					"UPDATE dbo.citizen set name=?,age=?,districtid=?,designation=?,relativeid=? WHERE userid = ?");

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, districtid);
			pstmt.setString(4, designation);
			pstmt.setInt(6, relativeid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deleteCitizen(int userid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL2);
			pstmt = conn.prepareStatement("DELETE FROM dbo.citizen WHERE districtid = ?");
			pstmt.setInt(1, userid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void retirveAllCitizen(Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL2);
			pstmt = conn.prepareStatement("SELECT * FROM dbo.citizen");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + rs.getInt(4)
						+ rs.getString(5) + rs.getInt(6));
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

		CRUDCitizen demo02 = new CRUDCitizen();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			// insert
			demo02.insertCitizen(1, "ank ", 50, 1, "president", 3, conn);
			demo02.insertCitizen(2, "chi ", 40, 2, "statehead", 9999, conn);
			demo02.insertCitizen(3, "gag ", 30, 3, "districthead", 9999, conn);
			demo02.insertCitizen(4, "som ", 20, 1, "null", 2, conn);
			demo02.insertCitizen(5, "pik ", 15, 3, "statehead", 9999, conn);
			demo02.insertCitizen(6, "achu ", 19, 2, "districthead", 9999, conn);
			demo02.insertCitizen(7, "kaka ", 20, 1, "districthead", 9999, conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
