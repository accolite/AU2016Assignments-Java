package com.accolite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.accolite.util.Constants;

public class Queries {

	public Queries(int i) {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Queries() {
	}

	public void Query1() {
		Statement stmt = null;
		Connection con = Queries.GetConnection(Constants.DB_URL1);
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ = "SELECT StateName FROM dbo.STATES";
			ResultSet rs = stmt.executeQuery(sqlQ);
			System.out.println("StateName");
			while (rs.next()) {
				String StateName = rs.getString(1);
				System.out.println(StateName);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					Queries.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void Query2() {
		Statement stmt = null;
		Connection con = Queries.GetConnection(Constants.DB_URL1);
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ = "SELECT Name FROM .dbo.DISTRICTS";
			ResultSet rs = stmt.executeQuery(sqlQ);
			System.out.println("District Name");
			while (rs.next()) {
				String Name = rs.getString(1);
				System.out.println(Name);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					Queries.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query3() {
		Statement stmt = null;
		Connection con = Queries.GetConnection(Constants.DB_URL);
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ = "SELECT COUNT(*) AS dbo.CITIZENCount,S1.StateName FROM DATABASE_2.dbo.CITIZEN AS C1"
					+ "JOIN DATABASE_1.dbo.DISTRICTS AS D1 ON C1.DistrictID=d1.DistictId"
					+ "JOIN DATABASE_1.dbo.STATES AS S1 ON S1.StateID=d1.StateID" + "GROUP BY S1.StateID ";
			ResultSet rs = stmt.executeQuery(sqlQ);
			System.out.println("dbo.CITIZENCount    StateName");
			while (rs.next()) {
				int Count = rs.getInt(1);
				String StateName = rs.getString(2);
				System.out.println(Count + " " + StateName);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					Queries.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query4(String district) {
		Statement stmt1 = null;
		Connection con1 = Queries.GetConnection(Constants.DB_URL);
		try {
			stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT DistrictID from dbo.DISTRICTS where DistrictName=\"" + district + ";\"";
			ResultSet rs = stmt1.executeQuery(sql);
			int distid = 0;
			distid = rs.getInt(1);
			sql = "Delete from DATABASE_1.dbo.DISTRICTS where DATABASE_1.dbo.DISTRICTS.DistrictID =\"" + distid + ";\"";
			stmt1.executeUpdate(sql);
			sql = "Delete from DATABASE_1.dbo.CITIZENS where DATABASE_1.dbo.DISTRICTS.DistrictID =\"" + distid + ";\"";
			stmt1.executeUpdate(sql);

			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt1 != null) {
				try {
					stmt1.close();
					Queries.CloseConnection(con1);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query5(String S) {
		Statement stmt = null;
		Connection con = Queries.GetConnection(Constants.DB_URL1);
		try {
			int stid = 0;
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ;
			sqlQ = "SELECT StateID FROM dbo.STATES WHERE NAME=\" " + S + " \" ";
			ResultSet rs = stmt.executeQuery(sqlQ);
			while (rs.next()) {
				stid = rs.getInt(1);
			}
			sqlQ = "SELECT Name FROM dbo.DISTRICTS WHERE StateID=\" " + stid + " \" ";
			ResultSet rs1 = stmt.executeQuery(sqlQ);
			Queries f = new Queries();
			while (rs1.next()) {
				String d = rs1.getString(1);
				f.Query4(d);
			}
			sqlQ = "DELETE FROM dbo.STATES WHERE StateName=\" " + S + " \" ";
			stmt.executeQuery(sqlQ);
			System.out.println("Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					Queries.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query6(String S) {
		Statement stmt = null;
		Connection con = Queries.GetConnection(Constants.DB_URL);
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ = "SELECT C1.Name, S1.StateName FROM DATABASE_1.dbo.CITIZEN AS C1"
					+ "JOIN DATABASE_1.dbo.dbo.DISTRICTS AS D1 ON C1.DistrictID=D1.DistrictID"
					+ "JOIN DATABASE_1.dbo.STATES AS S1 ON S1.StateID=D1.StateID" + "WHERE S1.NAME=\"" + S + "\"";
			ResultSet rs = stmt.executeQuery(sqlQ);
			System.out.println("dbo.CITIZENName    StateName");
			while (rs.next()) {
				String Count = rs.getString(1);
				String StateName = rs.getString(2);
				System.out.println(Count + " " + StateName);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					Queries.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query7() {
		Statement stmt1 = null;
		Connection con1 = Queries.GetConnection(Constants.DB_URL);
		try {
			stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			Scanner input = new Scanner(System.in);
			System.out.println("Enter district name");
			String district = input.nextLine();
			String sql = "SELECT  DATABASE_2.dbo.CITIZENS.Name from DATABASE_1.dbo.DISTRICTS "
					+ "join DATABASE_2.dbo.CITIZENS on "
					+ "DATABASE_1.dbo.DISTRICTS.DistrictID = DATABASE_2.dbo.CITIZENS.DistrictID  where  DATABASE_1.dbo.DISTRICTS.Name=\""
					+ district + "\"";
			ResultSet rs = stmt1.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getString(1));
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt1 != null) {
				try {
					stmt1.close();
					Queries.CloseConnection(con1);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void Query8(String S) {
		Statement stmt = null;
		Connection con = Queries.GetConnection(Constants.DB_URL);
		try {
			int headId = 0;
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ = "SELECT HeadCitizenID FROM DATABASE_1.DISTRICTS WHERE DATABASE_1.DISTRICTS.Name=\"" + S + "\"";
			ResultSet rs = stmt.executeQuery(sqlQ);
			while (rs.next()) {
				headId = rs.getInt(1);
			}
			sqlQ = "SELECT Name FROM DATABASE_2.DISTRICTS WHERE CitizenID=\"" + headId + "\"";
			ResultSet rs1 = stmt.executeQuery(sqlQ);
			System.out.println("Head Name");
			while (rs.next()) {
				String Name = rs.getString(1);
				System.out.println(Name);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
					Queries.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query9(String distname, int change_dist_id) {
		Statement stmt1 = null;
		Connection con1 = Queries.GetConnection(Constants.DB_URL1);

		try {
			stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String sql = "SELECT  DATABASE_1.dbo.DISTRICTS.StateID from DATABASE_1.dbo.DISTRICTS "
					+ "where  DATABASE_1.dbo.DISTRICTS.DistrictName=\"" + distname + "\"";

			ResultSet rs = stmt1.executeQuery(sql);
			int districtid = (rs.getInt(1));
			sql = "UPDATE DATABASE_1.dbo.DISTRICTS " + "SET DATABASE_1.dbo.DISTRICTS.DistrictID ="
					+ change_dist_id + "WHERE DATABASE_1.dbo.DISTRICTS.dbo.DISTRICTSID=" + districtid + "\"";
			stmt1.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt1 != null) {
				try {
					stmt1.close();
					Queries.CloseConnection(con1);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void Query10() {

	}

	public void Query11() {

	}

	public static Connection GetConnection(String D) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(D, Constants.username, Constants.password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void CloseConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Scanner S = new Scanner(System.in);
		int i = 1;
		Queries Q = new Queries();
		Queries ForDriverRegistering = new Queries(0);
		while (i == 1) {
			System.out.println("Enter your choice\n");
			System.out.println("1.List all the STATES\n2.List all the DISTRICTS");
			System.out.println("3.Display the CITIZEN count for all the STATES\n4.Remove a district");
			System.out.println("5.Remove a state\n6.List of dbo.CITIZENs under state");
			System.out.println("9.Change Head of a district\n10.List technical details");
			System.out.println("11.Create or restore data and tables\n12.Exit");
			int choice = S.nextInt();
			switch (choice) {
			case 1:
				Q.Query1();
				break;
			case 2:
				Q.Query2();
				break;
			case 3:
				Q.Query3();
				break;
			case 4:
				System.out.println("Enter the district");
				String q4 = S.next();
				Q.Query4(q4);
				Q.Query4(q4);
				break;
			case 5:
				System.out.println("Enter the state to be Deleted");
				String q5 = S.next();
				Q.Query5(q5);
				break;
			case 6:
				System.out.println("Enter the State");
				String q6 = S.next();
				Q.Query6(q6);
				break;
			case 7:
				break;
			case 8:
				System.out.println("Enter the District Name");
				String q8 = S.next();
				Q.Query6(q8);
				break;
			case 9:
				System.out.println("Enter the head name and the district id to be changed ");
				String q9=S.next();
				int qi9=S.nextInt();
				Q.Query9(q9,qi9);
				break;
			case 10:
				Q.Query10();
				break;
			case 11:
				Q.Query11();
				break;
			case 12:
				i = 0;
				break;
			}
		}
	}
}
