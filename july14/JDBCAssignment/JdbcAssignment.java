/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 14, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.jdbcAssignment;

import java.sql.*;
import java.util.Scanner;

import com.accolite.jbdcExample.util.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class JdbcAssignment.
 */
public class JdbcAssignment {
	
	/** The initiator class */
	JdbcAssignmentInitialInsert initiate;
	
	/** The connection. */
	Connection connection;
	
	/**
	 * List states. --QUESTION 1
	 */
	public void listStates(){
		try{
			setup();
			Statement statement = connection.createStatement();
			String select = "USE Database1; SELECT stateName FROM States;" ;

			ResultSet rs = statement.executeQuery(select);
			System.out.println("States");
			while (rs.next()) {
				String first = rs.getString(1);
				System.out.println(first);
			}
			rs.close();
			statement.close();
			teardown();
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * List districts --QUESTION 2
	 */
	public void listDistricts(){
		try{
			setup();
			Statement statement = connection.createStatement();
			String select = "USE Database1; SELECT districtName FROM Districts;" ;

			ResultSet rs = statement.executeQuery(select);
			System.out.println("Districts");
			while (rs.next()) {
				String first = rs.getString(1);
				System.out.println(first);
			}
			rs.close();
			statement.close();
			teardown();
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * List count of citizens --QUESTION3
	 */
	public void listCountCitizens(){
		try{
			setup();
			Statement statement = connection.createStatement();
			String select = "USE Database2; SELECT COUNT(1) FROM Citizens WHERE districtId IS NOT NULL;" ;

			ResultSet rs = statement.executeQuery(select);
			System.out.println("Count(Citizens)");
			while (rs.next()) {
				String first = rs.getString(1);
				System.out.println(first);
			}
			rs.close();
			statement.close();
			teardown();
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Removes the district --QUESTION4
	 *
	 * @param a the a
	 */
	public void removeDistrict(String a){
		try{
			setup();
			Statement statement = connection.createStatement();
			String delete = "USE Database1; DELETE FROM Database1.dbo.Districts WHERE districtName LIKE \'%"+a+"%\';" ;
			//System.out.println(delete);
			statement.executeUpdate(delete);
			statement.close();
			teardown();
			setup();
			String update = "USE Database2; UPDATE Citizens SET districtId=null WHERE districtId NOT IN"
					+ "(SELECT districtId from Database1.dbo.Districts)" ;
			statement = connection.createStatement();
			statement.executeUpdate(update);
			statement.close();
			teardown();

			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Removes the state. --QUESTION5
	 *
	 * @param a the a
	 */
	public void removeState(String a){
		try{
			setup();
			Statement statement = connection.createStatement();
			String delete = "USE Database1; DELETE FROM States WHERE stateName LIKE \'%"+a+"%\';" ;
			//System.out.println(delete);
			statement.executeUpdate(delete);
			
			statement = connection.createStatement();
			delete = "USE Database1; DELETE FROM Districts WHERE stateId NOT IN"
					+ "(SELECT stateId FROM States);" ;
			//System.out.println(delete);
			statement.executeUpdate(delete);
			statement.close();
			teardown();
			
			setup();

			String update = "USE Database2; UPDATE Citizens SET districtId=NULL WHERE districtId NOT IN"
					+ "(SELECT districtId from Database1.dbo.Districts)" ;
			statement = connection.createStatement();
			statement.executeUpdate(update);
			statement.close();
			teardown();
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * List citizens of state. --QUESTION6
	 *
	 * @param a the a
	 */
	public void listCitizensofState(String a){
		try{
			setup();
			Statement statement = connection.createStatement();
			String select = "USE Database2; SELECT Name FROM Citizens "
					+ "WHERE districtId in (SELECT districtId FROM Database1.dbo.Districts WHERE stateId"
					+ " in (SELECT stateId FROM Database1.dbo.States where stateName LIKE \'%"+a+"%\'));";
 
			ResultSet rs = statement.executeQuery(select);
			System.out.println("Citizens");
			while (rs.next()) {
				String first = rs.getString(1);
				System.out.println(first);
			}
			rs.close();
			statement.close();
			teardown();
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * List citizens of district --QUESTION7
	 *
	 * @param a the a
	 */
	public void listCitizensofDistrict(String a){
		try{
			setup();
			Statement statement = connection.createStatement();
			String select = "USE Database2; SELECT Name FROM Citizens "
					+ "WHERE districtId in (SELECT districtId FROM Database1.dbo.Districts WHERE districtName "
					+ "LIKE \'%"+a+"%\');";
 
			ResultSet rs = statement.executeQuery(select);
			System.out.println("Citizens");
			while (rs.next()) {
				String first = rs.getString(1);
				System.out.println(first);
			}
			rs.close();
			statement.close();
			teardown();
			
			/***
			 * Handling all exceptions
			 */
			
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Head of district --QUESTION8
	 *
	 * @param a the a
	 */
	public void headOfDistrict(String a){
		try{
			setup();
			Statement statement = connection.createStatement();
			String select = "USE Database2; SELECT Name FROM Citizens "
					+ "WHERE citizenId in (SELECT districtHead FROM Database1.dbo.Districts WHERE districtName "
					+ "LIKE \'%"+a+"%\');";
 
			ResultSet rs = statement.executeQuery(select);
			System.out.println("District Head");
			while (rs.next()) {
				String first = rs.getString(1);
				System.out.println(first);
			}
			rs.close();
			statement.close();
			teardown();
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Change district head. --QUESTION9
	 *
	 * @param a the a
	 * @param b the b
	 */
	public void changeDistrictHead(String a, String b){
		try{
			setup();
			Statement statement = connection.createStatement();
			String select = "USE Database2; SELECT citizenId FROM Database2.dbo.Citizens WHERE Name "
					+ "LIKE \'%"+b+"%\' AND age<60";
			ResultSet rs = statement.executeQuery(select);
			int required=-1;
			while (rs.next()) {
				required = rs.getInt(1);
			}
			
			rs.close();
			if(required!=-1){
				String update = "UPDATE Database1.dbo.Districts SET districtHead = "+String.valueOf(required)
					+ " WHERE districtName "
					+ "LIKE \'%"+a+"%\';";
			
				statement.executeUpdate(update);
			}else{
				System.out.println("Cannot update with age>60");
			}
			statement.close();
			teardown();
			
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * List technical --QUESTION10
	 */
	public void listTechnical(){
		try{
			setup();
			DatabaseMetaData dbmd = connection.getMetaData();
			
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

			teardown();
			/***
			 * Handling all exceptions
			 */
		}catch(SQLException se){
			System.out.println(se.getSQLState()+" due to "+se.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Restore backup.
	 */
	public void restoreBackup(){
		try{
			initiate= new JdbcAssignmentInitialInsert();
			initiate.inititateCall();
		}
			catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(connection!=null)
					teardown();
			}catch(SQLException se){
				System.out.println(se.getSQLState()+" due to "+se.getMessage());
			}
		}
	}
	
	/**
	 * Instantiates a new jdbc assignment.
	 */
	public JdbcAssignment(){
		initiate = new JdbcAssignmentInitialInsert();
		initiate.inititateCall();
	}

	/**
	 * Setup.
	 *
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public void setup() throws SQLException,Exception{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		connection = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.USERNAME, Constants.PASSWORD);
	}

	/**
	 * Teardown.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void teardown() throws SQLException{ 
		connection.close();
	}
	
	
	/**
	 * The main DRIVER
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		JdbcAssignment jdbcAssignment = new JdbcAssignment();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Option");
		System.out.println("1. List all the states\n"
+ "2. List all the districts\n"
+ "3. Display the citizen count for all the states\n"
+ "4. Remove a district\n"
+ "5. Remove a state\n"
+ "6. List of citizens under state\n"
+ "7. List of citizens under district\n"
+ "8. Show head of a district\n"
+ "9. Change Head of a district\n"
+ "10. List technical details\n"
+ "11. Create or restore data and tables\n"
+ "12. Quit");
		boolean cnt=true;
		while(cnt){
			int option = in.nextInt();
			switch(option){
				case 1:
					jdbcAssignment.listStates();
					break;
				case 2:
					jdbcAssignment.listDistricts();
					break;
				case 3:
					jdbcAssignment.listCountCitizens();
					break;
				case 4:
					System.out.println("Enter district name");
					String a = in.next();
					jdbcAssignment.removeDistrict(a);
					break;
				case 5:
					System.out.println("Enter state name");
					String a1 = in.next();
					jdbcAssignment.removeState(a1);
					break;
				case 6:
					System.out.println("Enter state name");
					String a2 = in.next();
					jdbcAssignment.listCitizensofState(a2);
					break;
				case 7:
					System.out.println("Enter district name");
					String a3 = in.next();
					jdbcAssignment.listCitizensofDistrict(a3);
					break;
				case 8:
					System.out.println("Enter district name");
					String a4 = in.next();
					jdbcAssignment.headOfDistrict(a4);
					break;
				case 9:
					System.out.println("Enter district name");
					String a5 = in.next();
					System.out.println("Enter name of new district head");
					String b5 = in.next();
					jdbcAssignment.changeDistrictHead(a5, b5);
					break;
				case 10:
					jdbcAssignment.listTechnical();
					break;
				case 11:
					System.out.println("Confirm restore? y/n");
					String a6 = in.next();
					if(a6.equals("y")){
						System.out.println("Here");
						jdbcAssignment.restoreBackup();
					}
					break;
				case 12:
					System.out.println("Close? y/n");
					if(in.next()=="y")
						cnt = false;
					break;
				default:
					System.out.println("Enter valid option");
			}
		}
		in.close();
	}
}
