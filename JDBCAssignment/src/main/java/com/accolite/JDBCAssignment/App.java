package com.accolite.JDBCAssignment;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.accolite.JDBCAssignment.utils.Constants;

public class App {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt = null;
	ResultSet rs;
	Set<Integer> vips;
	public static void main(String[] args) {
		App app = new App();
		app.init();
		Scanner in = new Scanner(System.in);
		int choice;
		do{
			int districtID,stateID,citizenID;
			System.out.println("1. List all the states");
	        System.out.println("2. List all the districts");
	        System.out.println("3. Display the citizen count for all the states");
	        System.out.println("4. Remove a district");
	        System.out.println("5. Remove a state");
	        System.out.println("6. List of citizens under state");
	        System.out.println("7. List of citizens under district");
	        System.out.println("8. Show head of a district");
	        System.out.println("9. Change Head of a district");
	        System.out.println("10. List technical details");
	        System.out.println("11. Create or restore data and tables");
	        System.out.println("12. Exit");
	        
	        choice = in.nextInt();
	        switch (choice) {
			case 1:
				app.listAllStates();
				break;
			case 2:
				app.listAllDistricts();
				break;
			case 3:
				app.displayCitizenCount();
				break;				
			case 4:
				System.out.println("Enter district to remove : ");
				districtID = in.nextInt();
				app.removeDistrict(districtID);
				break;
			case 5:
				System.out.println("Enter state to remove : ");
				stateID = in.nextInt();
				app.removeState(stateID);
				break;
			case 6:
				System.out.println("Enter State : ");
				stateID = in.nextInt();
				app.listCitizensUnderState(stateID);
				break;			
			case 7:
				System.out.println("Enter District : ");
				districtID = in.nextInt();
				app.listCitizensUnderDistrict(districtID);
				break;
			case 8:
				System.out.println("Enter District : ");
				districtID = in.nextInt();
				app.showHeadOfDistrict(districtID);
				break;
			case 9:
				System.out.println("Enter District : ");
				districtID = in.nextInt();
				System.out.println("Enter Citizen : ");
				citizenID = in.nextInt();
				app.changeHeadOfDistrict(districtID,citizenID);
				break;				
			case 10:
				app.listTechnicalDetails();
				break;
			case 11:
				app.factoryReset();
				break;
			case 12:
				return;
			default:
				break;
			}
		}while(choice != 12);
	}

	private void factoryReset() {
		init();
		
	}

	private void changeHeadOfDistrict(int districtID, int citizenID) {
		int headID;
		int newHeadAge;
		int newHeadOriginState;
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			
			pstmt = conn.prepareStatement("SELECT districtHead FROM DB1.dbo.districts WHERE districtID = ?");
			pstmt.setInt(1, districtID);
			
			rs = pstmt.executeQuery();
			rs.next();
			headID  = rs.getInt(1);
			
			
			pstmt = conn.prepareStatement("SELECT districtID,age FROM DB2.dbo.citizens WHERE citizenID = ?");
			pstmt.setInt(1, citizenID);
			
			rs = pstmt.executeQuery();
			rs.next();
			newHeadAge  = rs.getInt("age");
			newHeadOriginState = rs.getInt("districtID");
			
			if(newHeadAge > 60){
				System.out.println("Too old !");
				return;
			}
			if(newHeadOriginState != districtID){
				System.out.println("Not Same District");
				return;
			}

			vips.remove(headID);
			
			pstmt = conn.prepareStatement("UPDATE DB1.dbo.districts SET districtHead = ? WHERE districtID = ?");
			pstmt.setInt(1, citizenID);
			pstmt.setInt(2, districtID);
			pstmt.executeUpdate();
			
			vips.add(citizenID);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		
	}

	private void showHeadOfDistrict(int districtID) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			
			pstmt = conn.prepareStatement("SELECT * FROM DB2.dbo.citizens  WHERE citizenID = (SELECT districtHead FROM DB1.dbo.districts WHERE districtID = ?)");
			pstmt.setInt(1, districtID);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(vips.contains(rs.getInt("citizenID"))){
					System.out.print("---");
				}
				System.out.println(rs.getString("citizenName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void listTechnicalDetails() {
		try {

			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			DatabaseMetaData dbmd = conn.getMetaData();
			
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			System.out.println(dbmd.getDriverVersion());
		} catch (Exception e) {

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void listCitizensUnderDistrict(int districtID) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			
			pstmt = conn.prepareStatement("SELECT * FROM DB2.dbo.citizens WHERE districtID = ?");
			pstmt.setInt(1, districtID);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(vips.contains(rs.getInt("citizenID"))){
					System.out.print("---");
				}
				System.out.println(rs.getString("citizenName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void listCitizensUnderState(int stateID) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			
			pstmt = conn.prepareStatement("SELECT * FROM DB2.dbo.citizens AS C,DB1.dbo.districts AS D WHERE C.districtID = D.districtID AND stateID = ?");
			pstmt.setInt(1, stateID);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(vips.contains(rs.getInt("citizenID"))){
					System.out.print("---");
				}
				System.out.println(rs.getString("citizenName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void removeState(int stateID) {
		int state;
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			
			pstmt = conn.prepareStatement("DELETE FROM DB1.dbo.states WHERE stateID = ?");
			pstmt.setInt(1, stateID);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("UPDATE DB1.dbo.districts SET stateID = NULL WHERE stateID = ?");
			pstmt.setInt(1, stateID);
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void removeDistrict(int districtID) {
		int headID;
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			
			pstmt = conn.prepareStatement("SELECT districtHead FROM DB1.dbo.districts WHERE districtID = ?");
			pstmt.setInt(1, districtID);
			
			rs = pstmt.executeQuery();
			rs.next();
			headID  = rs.getInt(1);
			System.out.println(headID);
			pstmt = conn.prepareStatement("DELETE FROM DB1.dbo.districts WHERE districtID = ?");
			pstmt.setInt(1, districtID);
			pstmt.executeUpdate();
			vips.remove(headID);
			
			pstmt = conn.prepareStatement("UPDATE DB2.dbo.citizens SET districtID = NULL WHERE districtID = ?");
			pstmt.setInt(1, districtID);
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void displayCitizenCount() {
		conn = null;
		stmt = null;
		try {
			//register driver
			Class.forName(Constants.JTDS_DRIVER);			
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT S.stateName, COUNT(C.CitizenID) as cnt from DB1.dbo.states AS S , DB1.dbo.districts AS D , DB2.dbo.citizens AS C WHERE S.stateID=D.stateID AND D.districtID = C.districtID GROUP BY(S.stateName)";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String stateName = rs.getString("stateName");				
				System.out.println(stateName);
				int cnt = rs.getInt("cnt");				
				System.out.println(cnt);
			}

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

	private void listAllDistricts() {
		conn = null;
		stmt = null;
		try {
			//register driver
			Class.forName(Constants.JTDS_DRIVER);			
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * from DB1.dbo.districts";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String districtName = rs.getString("districtName");				
				System.out.println(districtName);
			}

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

	private void listAllStates() {
		conn = null;
		stmt = null;
		try {		
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * from DB1.dbo.states";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String stateName = rs.getString("stateName");				
				System.out.println(stateName);
			}

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
	private void init(){
		conn = null;
		stmt = null;
		String dropTable;
		String createTable;
		String createDbIfNotExists;
		String insertData;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			/*
			 * Creating DB1
			 */
			
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			stmt = conn.createStatement();
			createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'DB1') CREATE DATABASE DB1";
			stmt.executeUpdate(createDbIfNotExists);

			//System.out.println("Dropping table if exits");
			dropTable ="USE  DB1 "+ "IF OBJECT_ID('dbo.president', 'U') IS NOT NULL DROP TABLE dbo.president; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.president' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE president(citizenid int not null, primary key(citizenID)) "
					+ "END";
			stmt.executeUpdate(createTable);

			//System.out.println("Dropping table if exits");
			dropTable ="USE  DB1 "+ "IF OBJECT_ID('dbo.states', 'U') IS NOT NULL DROP TABLE dbo.states; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.states' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE states (stateID int not null,stateName varchar(200) not null, primary key(stateID)) "
					+ "END";
			stmt.executeUpdate(createTable);
			
			//System.out.println("Dropping table if exits");
			dropTable ="USE  DB1 "+ "IF OBJECT_ID('dbo.districts', 'U') IS NOT NULL DROP TABLE dbo.districts; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.districts' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE districts(districtID int not null,districtName varchar(200) not null , districtHead int not null , stateID int, primary key(districtID))" 
					+ "END";
			stmt.executeUpdate(createTable);
			
			/*
			 * Creating DB2
			 */
			
			createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'DB2') CREATE DATABASE DB2";
			stmt.executeUpdate(createDbIfNotExists);

			//System.out.println("Dropping table if exits");
			dropTable ="USE  DB2 "+ "IF OBJECT_ID('dbo.citizens', 'U') IS NOT NULL DROP TABLE dbo.citizens; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.citizens' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE citizens(citizenID int not null,citizenName varchar(200) not null, districtID int , age int not null , primary key(citizenID)) "
					+ "END";
			stmt.executeUpdate(createTable);

			/*
			 * Populating Data
			 */
			
			insertData = "INSERT INTO DB1.dbo.states VALUES(1,'Karnataka'),(2,'Goa'),(3,'Manipur')";
			stmt.executeUpdate(insertData);
			
			insertData = "INSERT INTO DB1.dbo.districts VALUES(1,'Hubli',1,1),(2,'Mysore',2,1),(3,'Kodaikanal',3,1),(4,'Baga',4,2),(5,'Imphal',5,3),(6,'Bishnupur',6,3)";
			stmt.executeUpdate(insertData);
			
			insertData = "INSERT INTO DB2.dbo.citizens VALUES(1,'Travis Becker',1,1),(2,'Kathleen Farmer',2,1),(3,'Alexis Alexander',3,1),(4,'Garrett Diaz',4,2),(5,'Ross Dixon',5,3),(6,'Phil French',6,3),(7,'President Willis',6,3),(8,'Fiona Willis',6,3),(9,'Average Joe',6,3),(10,'Average Joe2',1,3),(11,'Average Joe3',1,63)";
			stmt.executeUpdate(insertData);
			
			insertData = "INSERT INTO DB1.dbo.president VALUES(7),(8)";
			stmt.executeUpdate(insertData);
			
			/*
			 * VIP
			 */
			
			vips = new HashSet<Integer>();
			vips.add(7);
			vips.add(8);
			vips.add(1);
			vips.add(2);
			vips.add(3);
			vips.add(4);
			vips.add(5);
			vips.add(6);
		} catch (SQLException se) {
			System.out.println(se.getErrorCode());
			if (se.getErrorCode() == 1801) {
				// Database already exists error
				System.out.println(se.getMessage());
			} else {
				// Some other problems, e.g. Server down, no permission, etc
				se.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}