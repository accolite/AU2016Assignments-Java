/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 14, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package org.au.workshop.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.au.workshop.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class PresidentDBApplication.
 */
public class PresidentDBApplication 
{

	/** The set. */
	Set<Integer> set = new HashSet<Integer>();
	
	/**
	 * Instantiates a new president DB application.
	 */
	public PresidentDBApplication() 
	{
	}
	
	/**
	 * Inits the.
	 */
	public void  init()
	{
		// Init Begins
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, "sa", "accolite");
			stmt = conn.createStatement();
			
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT * FROM master.dbo.sysdatabases WHERE name = N'DB1') CREATE DATABASE DB1";
			stmt.executeUpdate(createDbIfNotExists);
			System.out.println("Created Database DB1");
			
			String dropTable ="USE  DB1 "+ "IF OBJECT_ID('dbo.PresidentVIP', 'U') IS NOT NULL DROP TABLE dbo.PresidentVIP; " ;
			stmt.executeUpdate(dropTable);
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.President' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE PresidentVIP( CitizenID int, Relation varchar (255), DependentID int ) "
					+ "END";
			stmt.executeUpdate(createTable);
			System.out.println("Created Table PresidentVIP");
			
			dropTable ="USE  DB1 "+ "IF OBJECT_ID('dbo.DistrictDetails', 'U') IS NOT NULL DROP TABLE dbo.DistrictDetails; " ;
			stmt.executeUpdate(dropTable);
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.DistrictDetails' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE DistrictDetails( DistID int, StateID int, DistName varchar (255), DistHead int, PRIMARY KEY (DistID) ) "
					+ "END";
			stmt.executeUpdate(createTable);
			System.out.println("Created Table DistrictDetails");
			
			dropTable ="USE  DB1 "+ "IF OBJECT_ID('dbo.StateDetails', 'U') IS NOT NULL DROP TABLE dbo.StateDetails; " ;
			stmt.executeUpdate(dropTable);
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.StateDetails' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE StateDetails( StateID int, StateName varchar (255), PRIMARY KEY (StateID)  ) "
					+ "END";
			stmt.executeUpdate(createTable);
			System.out.println("Created Table StateDetails");
			
			createDbIfNotExists = "IF  NOT EXISTS (SELECT * FROM master.dbo.sysdatabases WHERE name = N'DB2') CREATE DATABASE DB2";
			stmt.executeUpdate(createDbIfNotExists);
			System.out.println("Created Database DB2");
			
			dropTable ="USE  DB2 "+ "IF OBJECT_ID('dbo.Citizen', 'U') IS NOT NULL DROP TABLE dbo.Citizen; " ;
			stmt.executeUpdate(dropTable);
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.Citizen' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE Citizen( CitizenID int, CitizenName varchar (255), Age int, DistID int, PRIMARY KEY (CitizenID)  ) "
					+ "END";
			stmt.executeUpdate(createTable);
			System.out.println("Created Table Citizen");
			
			String insertStatement = "";
			
			insertStatement = "USE  DB1 " + "INSERT INTO dbo.PresidentVIP ( CitizenID, Relation, DependentID ) VALUES (1, 'wife', 6), (2, 'self', 2), (3, 'self', 3),(4, 'self', 4),(5, 'self', 5), (6, 'self', 6), (7, 'self', 7),(8, 'self', 8), (9, 'self', 9), (0, 'PRESIDENT NAME', 0)";
			stmt.executeUpdate(insertStatement);
			
			insertStatement = "INSERT INTO dbo.StateDetails ( StateId, StateName ) values (1, 'Maharashtra'), (2, 'West Bengal'), (3, 'Karnataka') ";
			stmt.executeUpdate(insertStatement);
			
			insertStatement = "INSERT INTO dbo.DistrictDetails ( DistID, StateId, DistName, DistHead ) values ( 1, 1, 'Nashik', 1), ( 2, 1, 'Nagpur', 2), ( 3, 1, 'Ratnagiri', 3) ";
			stmt.executeUpdate(insertStatement);
			insertStatement = "INSERT INTO dbo.DistrictDetails ( DistID, StateId, DistName, DistHead ) values ( 4, 2, 'Mushidawad', 4), ( 5, 2, 'Purulia', 5), ( 6, 2, 'Malda', 6) ";
			stmt.executeUpdate(insertStatement);
			insertStatement = "INSERT INTO dbo.DistrictDetails ( DistID, StateId, DistName, DistHead ) values ( 7, 3, 'Belgaum', 7), ( 8, 3, 'Bellary', 8), ( 9, 3, 'Yadgir', 9) ";
			stmt.executeUpdate(insertStatement);
			
			insertStatement = "USE  DB2 " + "INSERT INTO dbo.Citizen ( CitizenID, CitizenName, Age, DistID ) values ( 1, 'Udit', 21, 1), ( 10, 'Manjeet', 24, 1), ( 11, 'Ashay', 21, 2), ( 12, 'Prasanna', 65, 3), ( 2, 'Aniruddha', 21, 2), ( 3, 'Sumedh', 21, 3) ";
			stmt.executeUpdate(insertStatement);
			insertStatement = "USE  DB2 " + "INSERT INTO dbo.Citizen ( CitizenID, CitizenName, Age, DistID ) values ( 4, 'Soumyadeep', 40, 4), ( 5, 'Sudipto', 26, 5), ( 6, 'Adele', 20, 6) ";
			stmt.executeUpdate(insertStatement);
			insertStatement = "USE  DB2 " + "INSERT INTO dbo.Citizen ( CitizenID, CitizenName, Age, DistID ) values ( 7, 'Krishnan', 27, 7), ( 8, 'Arun', 28, 8), ( 9, 'Rajnikant', 40, 9) ";
			stmt.executeUpdate(insertStatement);
			
			ResultSet rs = null;
			try 
			{
				rs = stmt.executeQuery( "USE DB1 SELECT * FROM PresidentVIP" );
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Was unable to get President's Dependents");
				e.printStackTrace();
			}
			while (rs.next()) 
			{
				// Retrieve by column name
				if( !set.contains( rs.getInt("CitizenID") ))
					set.add(rs.getInt("CitizenID"));
				set.add( rs.getInt("DependentID") );
			}
			
		} 
		catch (SQLException se) 
		{
			System.out.println(se.getErrorCode());
			if (se.getErrorCode() == 1801) 
			{
				// Database already exists error
				System.out.println(se.getMessage());
			} else 
			{
				// Some other problems, e.g. Server down, no permission, etc
				se.printStackTrace();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws SQLException 
	{
		PresidentDBApplication PDB = new PresidentDBApplication();
		PDB.init();	
		Scanner in = new Scanner( System.in );
		int choice;
		int parameter = 0;
		Statement stmt = null;
		Connection conn = null;
		try 
		{
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, "sa", "accolite");
			stmt = conn.createStatement();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		while (true) 
		{
			System.out.println("\n1. List all the states\n2. List all the districts\n3. Display the citizen count for all the states\n4. Remove a district\n5. Remove a state\n6. List of citizens under state\n7. List of citizens under district\n8. Show head of a district\n9. Change Head of a district\n10. List technical details\n11. Create or restore data and tables");
			choice = in.nextInt();
			
			switch( choice )
			{
				case 1:
					PDB.ListStates( conn, stmt);
					break;
				case 2:
					PDB.ListDistricts( conn, stmt );
					break;
				case 3:
					PDB.DisplayCitizenCount( conn, stmt );
					break;
				case 4:
					System.out.println("Enter a DistrictID to be removed");
					parameter = in.nextInt();
					PDB.removeDistrict( conn, stmt, parameter );
					break;
				case 5:
					System.out.println("Enter a StateID to be removed");
					parameter = in.nextInt();
					PDB.removeState( conn, stmt, parameter );
					break;
				case 6:
					System.out.println("Enter a StateID");
					parameter = in.nextInt();
					PDB.DisplayCitizenState( conn, stmt, parameter );
					break;
				case 7:
					System.out.println("Enter a DistrictID");
					parameter = in.nextInt();
					PDB.DisplayCitizenDistrict( conn, stmt, parameter );
					break;
				case 8:
					System.out.println("Enter a DistrictID whose head is to be displayed");
					parameter = in.nextInt();
					PDB.DisplayDistrictHead( conn, stmt, parameter );
					break;
				case 9:
					System.out.println("Enter the districtID whose district head is to be changed");
					parameter = in.nextInt();
					System.out.println("Enter the citizenID");
					int parameter1 = in.nextInt();
					PDB.ChangeDistrictHead( conn, stmt, parameter, parameter1 );
					break;
				case 10:
					DatabaseMetaData dbmd = conn.getMetaData();
					System.out.println("Driver Name: "+dbmd.getDriverName());  
					System.out.println("Driver Version: "+dbmd.getDriverVersion());  
					System.out.println("UserName: "+dbmd.getUserName());  
					System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
					System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
					System.out.println( dbmd.getStringFunctions());
					break;
				case 11:
					PDB.init();
					break;
				case 12:
					conn.close();
					break;
			}
		}
	}
	
	/**
	 * Change district head.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @param parameter the parameter
	 * @param parameter1 the parameter 1
	 */
	private void ChangeDistrictHead(Connection conn, Statement stmt, int parameter, int parameter1) 
	{
		PreparedStatement pstmt = null;
		int DistHead = 0;
		int status = 0;
		ResultSet rs;
		try
		{
			pstmt = conn.prepareStatement("USE DB2 SELECT * FROM Citizen WHERE CitizenID = ?");
			pstmt.setInt(1, parameter1 );
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				if( rs.getInt(3) > 60 )
				{
					System.out.println("Citizen is too old");
					return;
				}
				if( rs.getInt(4) != parameter )
				{
					System.out.println("Candidate not from same district");
					return;
				}
			}
			pstmt = conn.prepareStatement("USE DB1 DELETE FROM PresidentVIP WHERE CitizenID = ?");
			pstmt.setInt(1, DistHead);
			status = pstmt.executeUpdate();
			pstmt = conn.prepareStatement("USE DB1 UPDATE DistrictDetails SET DistHead = ? WHERE DistID = ?");
			pstmt.setInt(1, parameter1);
			pstmt.setInt(2, parameter);
			status = pstmt.executeUpdate();
			String insertStatement = "";
			insertStatement = "USE  DB1 " + "INSERT INTO dbo.PresidentVIP ( CitizenID, Relation, DependentID ) VALUES (" + parameter1 + ",'self'," + parameter1 + ")";
			stmt.executeUpdate(insertStatement);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			closeResources(  pstmt, conn );
		}// TODO Auto-generated method stub
		
	}

	/**
	 * Display district head.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @param parameter the parameter
	 */
	private void DisplayDistrictHead(Connection conn, Statement stmt, int parameter)
	{
		PreparedStatement pstmt = null;
		int DistHead = 0;
		int status = 0;
		try
		{
			pstmt = conn.prepareStatement("USE DB1 SELECT * FROM DistrictDetails WHERE DistId = ?");
			pstmt.setInt(1, parameter);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				DistHead = rs.getInt(4);
			}
			pstmt = conn.prepareStatement("USE DB2 SELECT * FROM Citizen WHERE CitizenID = ?");
			pstmt.setInt(1, DistHead );
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				System.out.println( "District Head is " +  rs.getString(2) );
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			closeResources(  pstmt, conn );
		}
		
	}

	/**
	 * Removes the state.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @param parameter the parameter
	 */
	private void removeState(Connection conn, Statement stmt, int parameter) 
	{
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int DistHead = 0;
		int status = 0;
		try
		{
			pstmt = conn.prepareStatement("USE DB1 DELETE FROM StateDetails WHERE StateID = ?");
			pstmt.setInt(1, parameter);
			status = pstmt.executeUpdate();
			pstmt = conn.prepareStatement("USE DB1 UPDATE DistrictDetails SET StateID = NULL WHERE StateID = ?");
			pstmt.setInt(1, parameter);
			status = pstmt.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			closeResources(  pstmt, conn );
		}
	}

	/**
	 * Close resources.
	 *
	 * @param pstmt the pstmt
	 * @param conn the conn
	 */
	private void closeResources( PreparedStatement pstmt, Connection conn ) 
	{
		try 
		{
			if (pstmt != null)
				pstmt.close();
		} 
		catch (SQLException se2) 
		{
			se2.printStackTrace();
		}
	}

	/**
	 * Removes the district.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @param parameter the parameter
	 * @throws SQLException the SQL exception
	 */
	private void removeDistrict(Connection conn, Statement stmt, int parameter) throws SQLException 
	{
		PreparedStatement pstmt = null;
		int DistHead = 0;
		int status = 0;
		try
		{
			pstmt = conn.prepareStatement("USE DB1 SELECT * FROM DistrictDetails WHERE DistId = ?");
			pstmt.setInt(1, parameter);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				DistHead = rs.getInt(4);
			}
			pstmt = conn.prepareStatement("USE DB1 DELETE FROM PresidentVIP WHERE CitizenID = ?");
			pstmt.setInt(1, DistHead);
			status = pstmt.executeUpdate();
			pstmt = conn.prepareStatement("USE DB2 UPDATE Citizen SET DistID = NULL WHERE DistID = ?");
			pstmt.setInt(1, parameter);
			status = pstmt.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			closeResources(  pstmt, conn );
		}
			
	} 
		

	/**
	 * Display citizen district.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @param parameter the parameter
	 * @throws SQLException the SQL exception
	 */
	private void DisplayCitizenDistrict(Connection conn, Statement stmt, int parameter) throws SQLException 
	{
		// TODO Auto-generated method stub
		String query = "SELECT  DB2.dbo.Citizen.CitizenID as 'ID', DB2.dbo.Citizen.CitizenName AS 'Name', DB1.dbo.DistrictDetails.DistID AS 'Dist' FROM DB1.dbo.DistrictDetails INNER JOIN DB1.dbo.StateDetails ON DB1.dbo.DistrictDetails.StateID = DB1.dbo.StateDetails.StateID INNER JOIN DB2.dbo.Citizen ON DB1.dbo.DistrictDetails.DistID = DB2.dbo.Citizen.DistID WHERE DistrictDetails.DistID = " + parameter;
		ResultSet rs = null;
		try 
		{
			rs = stmt.executeQuery( query );
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Failed to fetch any citizens by state");
			e.printStackTrace();
		}
		while (rs.next()) 
		{
			// Retrieve by column name
			int ID = rs.getInt("ID");
			String First = rs.getString("Dist");
			String Second = rs.getString("Name");
			if( set.contains( ID) )
				First = "********" + First + "*********";
			System.out.println( First + " " + Second );
		}
		
	}

	/**
	 * Display citizen state.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @param Parameter the parameter
	 * @throws SQLException the SQL exception
	 */
	private void DisplayCitizenState(Connection conn, Statement stmt, int Parameter) throws SQLException 
	{
		String query = "SELECT  DB2.dbo.Citizen.CitizenID as 'ID', DB2.dbo.Citizen.CitizenName AS 'Name', DB1.dbo.StateDetails.StateName AS 'State' FROM DB1.dbo.DistrictDetails INNER JOIN DB1.dbo.StateDetails ON DB1.dbo.DistrictDetails.StateID = DB1.dbo.StateDetails.StateID INNER JOIN DB2.dbo.Citizen ON DB1.dbo.DistrictDetails.DistID = DB2.dbo.Citizen.DistID WHERE StateDetails.StateID = " + Parameter;
		ResultSet rs = null;
		try 
		{
			rs = stmt.executeQuery( query );
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Failed to fetch any citizens by state");
			e.printStackTrace();
		}
		while (rs.next()) 
		{
			// Retrieve by column name
			int ID = rs.getInt("ID");
			String First = rs.getString("State");
			String Second = rs.getString("Name");
			if( set.contains( ID) )
				First = "********" + First + "*********";
			System.out.println( First + " " + Second );
		}
		
		
	}

	/**
	 * Display citizen count.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @throws SQLException the SQL exception
	 */
	private void DisplayCitizenCount(Connection conn, Statement stmt) throws SQLException 
	{
		String query = "SELECT DB1.dbo.StateDetails.StateName AS 'StateName', count(*) AS 'CitizenCountPerState' FROM DB1.dbo.DistrictDetails "
				+ "INNER JOIN DB1.dbo.StateDetails ON DB1.dbo.DistrictDetails.StateID = DB1.dbo.StateDetails.StateID "
				+ "INNER JOIN DB2.dbo.Citizen ON DB1.dbo.DistrictDetails.DistID = DB2.dbo.Citizen.DistID GROUP BY DB1.dbo.StateDetails.StateName ";
		ResultSet rs = null;
		try 
		{
			rs = stmt.executeQuery( query );
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Was unable to print the Citizen count");
			e.printStackTrace();
		}
		while (rs.next()) 
		{
			// Retrieve by column name
			String first = rs.getString("StateName");
			System.out.println( first);
			first = rs.getString("CitizenCountPerState");
			System.out.println( first);
		}
		
	}

	/**
	 * List districts.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @throws SQLException the SQL exception
	 */
	private void ListDistricts(Connection conn, Statement stmt) throws SQLException 
	{
		String query = "USE DB1 SELECT DISTINCT DistName from DistrictDetails";
		ResultSet rs = null;
		try 
		{
			rs = stmt.executeQuery( query );
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Was unable to print the districts");
			e.printStackTrace();
		}
		while (rs.next()) 
		{
			// Retrieve by column name
			String first = rs.getString("DistName");
			// Display values
			System.out.println( first);
		}
		
	}

	/**
	 * List states.
	 *
	 * @param conn the conn
	 * @param stmt the stmt
	 * @throws SQLException the SQL exception
	 */
	private void ListStates( Connection conn, Statement stmt) throws SQLException 
	{
		String query = "USE DB1 SELECT DISTINCT StateName from StateDetails";
		ResultSet rs = null;
		try 
		{
			rs = stmt.executeQuery( query );
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Was unable to print the states");
			e.printStackTrace();
		}
		while (rs.next()) 
		{
			// Retrieve by column name
			String first = rs.getString("StateName");
			// Display values
			System.out.println( first);
		}
		
	} 

}
