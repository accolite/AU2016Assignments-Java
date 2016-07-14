/*
1. List all the states
2. List all the districts
3. Display the citizen count for all the states
4. Remove a district
5. Remove a state
6. List of citizens under state
7. List of citizens under district
8. Show head of a district
9. Change Head of a district
10. List technical details
11. Create or restore data and tables
*/

package com.accolite.JdbcAssignment;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FrontFace {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		char c;
		do {
			int ch = inp.nextInt();
			switch (ch) {
			case 1:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL1);
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					String sql;
					sql = "select Stateid,statename from dbo.states";
					rs = stmt.executeQuery(sql);
					System.out.println("States Data:");
					while (rs.next()) {
						// Retrieve by column name
						int id = rs.getInt("StateID");
						String name = rs.getString("StateName");

						// Display values
						System.out.println("ID: " + id + " Name: " + name);
					}
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			case 2:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL1);
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					String sql;
					sql = "select districtid,districtname from dbo.district";
					rs = stmt.executeQuery(sql);
					System.out.println("District Data:");
					while (rs.next()) {
						// Retrieve by column name
						int id = rs.getInt("DistrictID");
						String name = rs.getString("DistrictName");

						// Display values
						System.out.println("ID: " + id + " Name: " + name);
						
					}
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			case 3:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					String sql;
					sql = "select d.districtstateid,count(c.citizenid) as coun from database2.dbo.citizen as c,"
							+ "database1.dbo.district as d where c.citizendistrictheadid="
							+ "d.districtheadid group by d.districtstateid";
					rs = stmt.executeQuery(sql);
					System.out.println("District Data:");
					while (rs.next()) {
						// Retrieve by column name
						int id = rs.getInt("DistrictStateID");
						int count = rs.getInt("coun");

						// Display values
						System.out.println("ID: " + id + " Count: " + count);
					}
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL1);
					System.out.println("Enter the DistrictID to be deleted:");
					int did = inp.nextInt();
					pstmt = conn.prepareStatement("delete from dbo.district  where districtid=?");
					pstmt.setInt(1, did);
					int i = pstmt.executeUpdate();
					if (i == 1) {
						System.out.println("District Deleted.");
					} else {
						System.out.println("District not found.");
					}
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL1);
					System.out.println("Enter the StateID to be deleted:");
					int did = inp.nextInt();
					pstmt = conn.prepareStatement("delete from dbo.states  where stateid=?");
					pstmt.setInt(1, did);
					int i = pstmt.executeUpdate();
					if (i == 1) {
						System.out.println("State Deleted.");
					} else {
						System.out.println("State not found.");
					}
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
					System.out.println("Enter the StateID to be checked for all citizens:");
					int did = inp.nextInt();
					pstmt = conn.prepareStatement("select c.citizenid,c.citizenname from database2.dbo.citizen as c,"
							+ "database1.dbo.district as d where c.citizendistrictheadid="
							+ "d.districtheadid and d.districtstateid=?");
					pstmt.setInt(1, did);
					rs = pstmt.executeQuery();
					System.out.println("Citizen Data:");
					while (rs.next()) {
						// Retrieve by column name
						int id = rs.getInt("CitizenID");
						String str = rs.getString("CitizenName");

						// Display values
						System.out.println("ID: " + id + " Name: " + str);
					}
					pstmt.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
					System.out.println("Enter the DistrictID to be checked for all citizens:");
					int did = inp.nextInt();
					pstmt = conn.prepareStatement("select c.citizenid,c.citizenname from database2.dbo.citizen as c,"
							+ "database1.dbo.district as d where c.citizendistrictheadid="
							+ "d.districtheadid and d.districtid=?");
					pstmt.setInt(1, did);
					rs = pstmt.executeQuery();
					System.out.println("Citizen Data:");
					while (rs.next()) {
						// Retrieve by column name
						int id = rs.getInt("CitizenID");
						String str = rs.getString("CitizenName");

						// Display values
						System.out.println("ID: " + id + " Name: " + str);
					}
					pstmt.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 8:
				try {
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
					System.out.println("Enter the DistrictID:");
					int did = inp.nextInt();
					pstmt = conn.prepareStatement("select c.citizenid,c.citizenname from database2.dbo.citizen "
							+ "as c where c.citizenid in" + "(select d.districtheadid"
							+ "from database1.dbo.district as d" + "where d.districtid= ? )");
					pstmt.setInt(1, did);
					rs = pstmt.executeQuery();
					System.out.println("District Head data:");
					while (rs.next()) {
						// Retrieve by column name
						int id = rs.getInt("CitizenID");
						String str = rs.getString("CitizenName");

						// Display values
						System.out.println("ID: " + id + " Name: " + str);
					}
					pstmt.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 9:

				break;
			case 10:
				System.out.println("Technical Details:");
				try {
					conn = DriverManager.getConnection(Constants.DB_URL1);
					DatabaseMetaData dbmd = null;
					dbmd = conn.getMetaData();
					System.out.println("Driver Name: "+dbmd.getDriverName());  
					System.out.println("Driver Version: "+dbmd.getDriverVersion());  
					System.out.println("UserName: "+dbmd.getUserName());  
					System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
					System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
					
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 11:
				break;
			default:
				break;
			}
			System.out.println("Do You Want to Continue(y)");
			c = inp.next().charAt(0);
		} while (c != 'n');
		System.out.println("out");
	}

}
