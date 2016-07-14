package org.au.Assignment5;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.au.util.Constants;

import com.mysql.jdbc.ResultSetMetaData;

public class Queries {

	static Connection connection = null;

	public static void listAllTheStates() throws SQLException {
		try {
			connection = DriverManager.getConnection(Constants.DB_URL2,Constants.userName,Constants.password);
			Statement statement = connection.createStatement();
			String Query1 = "select stateName from State";
			ResultSet result = statement.executeQuery(Query1);
			System.out.println("State Names");
			while (result.next()) {
				System.out.println(result.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public static void listAllTheDistricts() throws SQLException {
		try {
			connection = DriverManager.getConnection(Constants.DB_URL2,Constants.userName,Constants.password);
			Statement statement = connection.createStatement();
			String Query2 = "select districtName from District";
			ResultSet result = statement.executeQuery(Query2);
			System.out.println("District Names");
			while (result.next()) {
				System.out.println(result.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}

	public static void citizenCountForStates() throws SQLException {

		try {
			connection = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			Statement statement = connection.createStatement();
			String Query3 = "select state.stateID,state.stateName,count(citizen.citizenID) from Citizen citizen join Database2.dbo.District district "+					
			"on citizen.districtID = district.districtID join Database2.dbo.State state "+
					"on district.stateID =state.stateID group by state.stateName,state.stateID";
			
			ResultSet result = statement.executeQuery(Query3);
			System.out.println("Citizen count for each state is as follows:");
			System.out.println("SNO"+"\t"+"State Name"+"\t"+"Population");
			while (result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}

	public static void removeDistrict() throws SQLException {
		try {
			Scanner scan=new Scanner(System.in);
			connection = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			Statement statement = connection.createStatement();
			String districtName=scan.next();
			String Query3 = "update Database1.dbo.Citizen set citizenFlag=0 where districtID IN (select Database2.dbo.District.districtID  from Database2.dbo.District where districtName='"+districtName+"')";
			String Query4="update Database2.dbo.District  set districtFlag=0 where Database2.dbo.District.districtName='"+districtName+"'";
			
			int result = statement.executeUpdate(Query3);
			result=statement.executeUpdate(Query4);
			}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public static void removeState() throws SQLException {
		try {
			Scanner scan=new Scanner(System.in);
			connection = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			Statement statement = connection.createStatement();
			String stateName=scan.next();
			String Query3 = "update Database1.dbo.Citizen set citizenFlag=0 where districtID IN (select Database2.dbo.District.districtID  from Database2.dbo.District where stateId IN (select Database2.dbo.State.stateID from Database2.dbo.State where Database2.dbo.State.stateName='"+stateName+"'))";
			String Query4="update Database2.dbo.District  set districtFlag=0 where stateID IN (select Database2.dbo.State.stateID  from Database2.dbo.State where Database2.dbo.State.stateName='"+stateName+"')";
			String Query5="update Database2.dbo.State  set stateFlag=0 where Database2.dbo.State.stateName='"+stateName+"'";
			int result = statement.executeUpdate(Query3);
			result=statement.executeUpdate(Query4);
			}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public static void citizensUnderState() throws SQLException
	{
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter state name to display names");
			String stateName=scan.next();
			connection = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			String Query6 = "select citizen.firstname,citizen.lastname,state.stateName from Database1.dbo.Citizen citizen join Database2.dbo.District district on citizen.districtID=district.districtID join Database2.dbo.State state on district.stateID=state.stateID where state.stateName='"+stateName+"'";
//			PreparedStatement statement = connection.prepareStatement(Query6);
//			statement.setString(1, stateName);
//			ResultSet result = statement.executeQuery();
			Statement statement=connection.createStatement();
			ResultSet result= statement.executeQuery(Query6);
			System.out.println("First Name"+"\t"+"Last Name");
			while (result.next()) {
				System.out.print(result.getString(1));
				System.out.println(result.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public static void citizensUnderDistrict() throws SQLException
	{
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter district name to display names");
			String districtName=scan.next();
			connection = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			String Query6 = "select citizen.firstname,citizen.lastname,district.districtName from Database1.dbo.Citizen citizen join Database2.dbo.District district on citizen.districtID=district.districtID  where district.districtName='"+districtName+"'";
//			PreparedStatement statement = connection.prepareStatement(Query6);
//			statement.setString(1, stateName);
//			ResultSet result = statement.executeQuery();
			Statement statement=connection.createStatement();
			ResultSet result= statement.executeQuery(Query6);
			System.out.println("First Name"+"\t"+"Last Name");
			while (result.next()) {
				System.out.print(result.getString(1));
				System.out.println(result.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public static void showHeadOfDistrict() throws SQLException
	{
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter district name to display head name");
			String districtName=scan.next();
			connection = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			String Query6 ="select citizen.firstname,citizen.lastname,District.districtName from Database1.dbo.Citizen citizen join Database2.dbo.District on citizen.districtID=District.districtID and citizen.citizenID=District.headID where district.districtName='"+districtName+"'";
//			PreparedStatement statement = connection.prepareStatement(Query6);
//			statement.setString(1, stateName);
//			ResultSet result = statement.executeQuery();
			Statement statement=connection.createStatement();
			ResultSet result= statement.executeQuery(Query6);
			System.out.println("First Name"+"\t"+"Last Name");
			while (result.next()) {
				System.out.print(result.getString(1));
				System.out.println(result.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	@SuppressWarnings("null")
	public static void listTechnicalDetails()
	{
		DatabaseMetaData metaData = null;
		ResultSetMetaData resultData = null;
		try {
			connection = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			metaData = connection.getMetaData();
			System.out.println("Driver Name: "+metaData.getDriverName());  
			System.out.println("Driver Version: "+metaData.getDriverVersion());  
			System.out.println("UserName: "+metaData.getUserName());    
			System.out.println("UserName: "+metaData.getURL());  
			System.out.println("UserName: "+metaData.getMaxRowSize());  
			System.out.println("UserName: "+metaData.getDatabaseProductName());
			System.out.println("UserName: "+metaData.getDatabaseProductVersion());
			System.out.println("Database Product Name: "+metaData.getDatabaseProductName());  
			System.out.println("Database Product Version: "+metaData.getDatabaseProductVersion());  
			//System.out.println("Total columns: "+resultData.getTableName(1));
			System.out.println("Column Name of 1st column: "+resultData.getColumnName(1));  
			System.out.println("Column Type Name of 1st column: "+resultData.getColumnTypeName(1));  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void changeHeadOfDistricts() throws SQLException
	{
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter district name and head's first name and  last name to change:");
			String districtName=scan.next();
			String firstName = scan.next();
			String lastName = scan.next();
			connection = DriverManager.getConnection(Constants.DB_URL1,Constants.userName,Constants.password);
			String Query6 ="update Database2.dbo.District set Database2.dbo.District.headID = (select citizen.citizenID from Database1.dbo.Citizen citizen join Database2.dbo.District district on citizen.districtID=district.districtID where citizen.firstname='"+firstName+"'"+ "and citizen.lastname='"+lastName+"'"+" and district.districtName='"+districtName+ "' and citizen.age < 60) where district.districtName='"+districtName+"'";
					//PreparedStatement statement = connection.prepareStatement(Query6);
//			statement.setString(1, stateName);
//			ResultSet result = statement.executeQuery();
			Statement statement=connection.createStatement();
			int result= statement.executeUpdate(Query6);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	public static void main(String[] args) throws SQLException {

		System.out.println("choose any of the following");
		System.out.println("1.List all the states" + "\n" + "2. List all the districts" + "\n"
				+ "3. Display the citizen count for all the states" + "\n" + "4. Remove a district" + "\n"
				+ "5. Remove a state" + "\n" + "6. List of citizens under state" + "\n"
				+ "7. List of citizens under district" + "\n" + "8. Show head of a district" + "\n"
				+ "9. Change Head of a district" + "\n" + "10. List technical details" + "\n"
				+ "11. Create or restore data and tables");

		Scanner scan = new Scanner(System.in);

		try {
			do{
				String read = scan.next();
				int input = Integer.parseInt(read);
			switch (input) {
			case 1:
				listAllTheStates();
				break;
			case 2:
				listAllTheDistricts();
				break;
			case 3:
				citizenCountForStates();
				break;
			case 4:
				removeDistrict();
				break;
			case 5:
				removeState();
				break;
			case 6:
				citizensUnderState();
				break;
			case 7:
				citizensUnderDistrict();
				break;
			case 8:
				showHeadOfDistrict();
				break;
			case 9:
				changeHeadOfDistricts();
				break;
			case 10:
				listTechnicalDetails();
				break;
			default:
				break;
			}
			System.out.println("To continue enter y else n");
			}	while(scan.next().equalsIgnoreCase("y"));
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
			connection.close();
		}
	}

}
