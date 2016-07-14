package JdbcConn;

import java.sql.*;
import JdbcConn.*;
import JdbcUtil.*;

//Prepared Statements into table
public class Insert {

	PreparedStatement pstmt = null;
	static Connection conn = null;
	String Db1 = "Citizen";
	String Db2 = "Territory";
	ResultSet rs = null;

	Insert() {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 public void Citizen(String Name, int head, int ParentId, int SpouseId,  int age,int DistrictId, Connection conn) {
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "DataBaseName=Citizen", "sa",
					"accolite");
			pstmt = conn.prepareStatement("INSERT INTO Citizen values(?,?,?,?,?,?)");

			pstmt.setString(1, Name);
			pstmt.setInt(5, age);
			pstmt.setInt(6, DistrictId);
			pstmt.setInt(3, ParentId);
			pstmt.setInt(4, SpouseId);
			pstmt.setInt(2, head);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	public void State(String StateName, Connection conn) {
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "DataBaseName=Territory", "sa",
					"accolite");
			pstmt = conn.prepareStatement("INSERT INTO State values(?)");

			pstmt.setString(1, StateName);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

 public void District(String DistrictName, int StateId, int headId, Connection conn) {
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "DataBaseName=Territory", "sa",
					"accolite");
			pstmt = conn.prepareStatement("INSERT INTO District values(?,?,?)");

			pstmt.setInt(2, StateId);
			pstmt.setString(1, DistrictName);
			pstmt.setInt(3, headId);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	private void closeResources() {
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

	/*
	 * public static void main(String[] args) {
	 * 
	 * Demo02PreparedStatements demo02 = new Demo02PreparedStatements(); try {
	 * Class.forName(Constants.JTDS_DRIVER); // insert
	 * demo02.insertUsingPreparedStatement(6,"Peter ", conn);
	 * System.out.println("Retrieving after the insert"); demo02.retirve(conn);
	 * 
	 * // update demo02.updateUsingPreparedStatements( 7, "Peter", conn);
	 * System.out.println("Retrieving after the update"); demo02.retirve(conn);
	 * // delete demo02.deleteUsingPreapredStatement(105, conn);
	 * System.out.println("Retrieving after delete"); demo02.retirve(conn); }
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

}
