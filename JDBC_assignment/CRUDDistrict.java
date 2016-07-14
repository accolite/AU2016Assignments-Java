package Assignment;

import java.sql.*;



public class CRUDDistrict {

	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;

	public void insertDistrict(int districtid, String name, int headuserid,int stateid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("INSERT INTO dbo.district values(?,?,?,?)");
			pstmt.setInt(1, districtid);
			pstmt.setString(2, name);
			pstmt.setInt(3, headuserid);
			pstmt.setInt(4, stateid);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void updateDistrict(int districtid, String name, int headuserid, int stateid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("UPDATE dbo.district set name=?,headuserid=?,stateid=? WHERE districtid = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, headuserid);
			pstmt.setInt(3, stateid);
			pstmt.setInt(4, districtid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void deleteDistrict(int districtid, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("DELETE FROM dbo.district WHERE districtid = ?");
			pstmt.setInt(1, districtid);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void retirveAllDistrict(Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL1);
			pstmt = conn.prepareStatement("SELECT * FROM dbo.district");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + rs.getInt(4));
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

		CRUDDistrict demo02 = new CRUDDistrict();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			// insert
			//demo02.insertDistrict(1, "pp ",6,1, conn);
			 //demo02.insertDistrict(2, "kk ",3,2, conn);
			 demo02.insertDistrict(3, "cc ",7,2, conn);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
