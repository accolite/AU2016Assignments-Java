package com.au.jdbcassignment.JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.au.jdbcassignment.util.Constants;

public class Assignment {
	
	static void getListOfStates()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			String sql;
			
			sql = "SELECT Name FROM CountryDatabase.dbo.State";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String stateName = rs.getString("Name");

				// Display values
				System.out.println(stateName);
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

	}
	
	
	static void getListOfDistricts()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			String sql;
			
			sql = "SELECT Name FROM CountryDatabase.dbo.District";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String stateName = rs.getString("Name");

				// Display values
				System.out.println(stateName);
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

	}
	
	
	static void citizenCountForStates()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			String sql;
			
			sql = "select CountryDatabase.dbo.State.Name StateName,count(CitizenDatabase.dbo.Citizen.CitizenID) Population from CitizenDatabase.dbo.Citizen join CountryDatabase.dbo.District on CitizenDatabase.dbo.Citizen.districtID = CountryDatabase.dbo.District.DistrictID join CountryDatabase.dbo.State on CountryDatabase.dbo.District.stateID =CountryDatabase.dbo.State.stateID group by CountryDatabase.dbo.State.Name,CountryDatabase.dbo.State.stateID";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String stateName = rs.getString("StateName");
				String count = rs.getString("Population");
				

				// Display values
				System.out.println(stateName +"\t"+ count);
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

	}
	
	static void citizenUnderState()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter State Name:");
			String state=sc.nextLine();
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			String sql;
			
			sql = "select CitizenDatabase.dbo.Citizen.CitizenID Citizenid,CitizenDatabase.dbo.Citizen.Name Name from CountryDatabase.dbo.State JOIN CountryDatabase.dbo.District ON CountryDatabase.dbo.District.StateID = CountryDatabase.dbo.State.StateID and CountryDatabase.dbo.State.Name='"+state+"'"+"JOIN CitizenDatabase.dbo.Citizen ON CitizenDatabase.dbo.Citizen.DistrictID = CountryDatabase.dbo.District.DistrictID";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				int citizenID = rs.getInt("Citizenid");
				String name = rs.getString("Name");
				

				// Display values
				System.out.println(citizenID +"\t"+ name);
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

	}
	

	static void citizenUnderDistrict()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter District Name:");
			String district=sc.nextLine();
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			String sql;
			
			sql = "select CitizenDatabase.dbo.Citizen.CitizenID Citizenid,CitizenDatabase.dbo.Citizen.Name Name from CitizenDatabase.dbo.Citizen JOIN CountryDatabase.dbo.District ON CitizenDatabase.dbo.Citizen.DistrictID = CountryDatabase.dbo.District.DistrictID and CountryDatabase.dbo.District.Name='"+district+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				int citizenID = rs.getInt("Citizenid");
				String name = rs.getString("Name");
				

				// Display values
				System.out.println(citizenID +"\t"+ name);
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

	}
	
    
    static void headOfDistrict()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter District Name:");
			String district=sc.nextLine();
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			String sql;
			
			sql = "select CitizenDatabase.dbo.Citizen.Name Head from CitizenDatabase.dbo.Citizen JOIN CountryDatabase.dbo.District ON CitizenDatabase.dbo.Citizen.CitizenID = CountryDatabase.dbo.District.HeadID where CountryDatabase.dbo.District.Name='"+district+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String name = rs.getString("Head");
				

				// Display values
				System.out.println(name);
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

	}
	
	static void technicalDetails()
	{
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		try {
				Class.forName(Constants.JTDS_DRIVER);
				conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
				dbmd = conn.getMetaData();
					
				System.out.println("Driver Name: "+dbmd.getDriverName());  
				System.out.println("Driver Version: "+dbmd.getDriverVersion());  
				System.out.println("UserName: "+dbmd.getUserName());  
				System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
				System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion()); 
					
			}catch (Exception e) {
				e.printStackTrace();
			}

	}
	
	static void changeHeadOfDistrict()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter District Name:");
			String district=sc.nextLine();
			
			System.out.println("Enter 'to be Head' Name:");
			String toBeHead=sc.nextLine();
			
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			String sql;
			
			sql = "update CountryDatabase.dbo.District set CountryDatabase.dbo.District.HeadID = (select CitizenDatabase.dbo.Citizen.CitizenID from CitizenDatabase.dbo.Citizen citizen join CountryDatabase.dbo.District district on citizen.DistrictID=district.DistrictID where citizen.Name='"+toBeHead+"'"+ "and district.Name='"+district+ "' and citizen.Age < 60) where district.Name='"+district+"'";
			int updatedCount = stmt.executeUpdate(sql);
			
			System.out.println("Updated Row Count:"+updatedCount);
			
			//  Clean-up environment
			stmt.close();
			conn.close();
			sc.close();
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
	
	static void removeDistrict()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter District Name:");
			String district=sc.nextLine();
			
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			//String sql;
			
			stmt.executeUpdate("update CitizenDatabase.dbo.Citizen set status=0 where DistrictID IN (select dbo.District.districtID  from dbo.District where dbo.districtName='"+district+"'");

			stmt.executeUpdate("update CountryDatabase.dbo.District  set status=0 where CountryDatabase.dbo.District.Name='"+district+"'");
			
			
		    System.out.println(district+" removed");
			
			//Clean-up environment
			stmt.close();
			conn.close();
			sc.close();
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
	
	static void removeState()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter State Name:");
			String state=sc.nextLine();
			
			Class.forName(Constants.JTDS_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			
			stmt = conn.createStatement();

			//String sql;
			
			String Query3 = "update CitizenDatabase.dbo.Citizen set status=0 where DistrictID IN (select CountryDatabase.dbo.District.DistrictID  from CountryDatabase.dbo.District where stateId IN (select CountryDatabase.dbo.State.stateID from CountryDatabase.dbo.State where CountryDatabase.dbo.State.stateName='"+state+"'))";
			   String Query4="update Database2.dbo.District  set districtFlag=0 where stateID IN (select Database2.dbo.State.stateID  from Database2.dbo.State where Database2.dbo.State.stateName='"+state+"')";
			   String Query5="update Database2.dbo.State  set stateFlag=0 where Database2.dbo.State.stateName='"+state+"'";
			
			stmt.executeUpdate(Query3);
			stmt.executeUpdate(Query4);
			stmt.executeUpdate(Query5);
		    System.out.println(state+" removed");
			
			//Clean-up environment
			stmt.close();
			conn.close();
			sc.close();
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. List all the states \n2. List all the districts\n3. Display the citizen count for all the states\n4. Remove a district\n5. Remove a state\n6. List of citizens under state\n7. List of citizens under district\n8. Show head of a district\n9. Change Head of a district\n10. List technical details\n11. Create or restore data and tables");
			System.out.println("Enter Your option:(-1 to exit)");
			int option=sc.nextInt();
			if(option==-1)
				break;
			switch(option)
			{
				case 1:System.out.println("--------------------------------------\n--------------------------------------------------");
					   System.out.println("List All states");getListOfStates();
				       System.out.println("--------------------------------------\n--------------------------------------------------");
				       break;
				case 2:System.out.println("--------------------------------------\n--------------------------------------------------");
					   System.out.println("List all the districts");getListOfDistricts();
					   System.out.println("--------------------------------------\n--------------------------------------------------");
					   break;
				case 3:System.out.println("--------------------------------------\n--------------------------------------------------");
					   System.out.println("Display the citizen count for all the states");citizenCountForStates();
			           System.out.println("--------------------------------------\n--------------------------------------------------");
			           break;
				case 4:System.out.println("--------------------------------------\n--------------------------------------------------");
					   System.out.println("Remove a district");removeDistrict();
		               System.out.println("--------------------------------------\n--------------------------------------------------");
		               break;
				case 5:System.out.println("--------------------------------------\n--------------------------------------------------");
				       System.out.println("Remove a state");removeState();
	                   System.out.println("--------------------------------------\n--------------------------------------------------");
	                   break;
				case 6:System.out.println("--------------------------------------\n--------------------------------------------------");
					   System.out.println("List of citizens under state");citizenUnderState();
				       System.out.println("--------------------------------------\n--------------------------------------------------");
				       break;
				case 7:System.out.println("--------------------------------------\n--------------------------------------------------");
					   System.out.println("List of citizens under District");citizenUnderDistrict();
				       System.out.println("--------------------------------------\n--------------------------------------------------");
				       break;
				case 8:System.out.println("--------------------------------------\n--------------------------------------------------");
					   System.out.println("Show head of a district");headOfDistrict();
					   System.out.println("--------------------------------------\n--------------------------------------------------");
					   break;
				case 9:System.out.println("--------------------------------------\n--------------------------------------------------");
				       System.out.println("Change Head of a district");changeHeadOfDistrict();
				       System.out.println("--------------------------------------\n--------------------------------------------------");
				       break;
				case 10:System.out.println("--------------------------------------\n--------------------------------------------------");
					   System.out.println("List technical details");technicalDetails();
				       System.out.println("--------------------------------------\n--------------------------------------------------"); 
				       break;
				default : System.out.println("Choose valid option");
			}
		}
		sc.close();
		
	}

}
