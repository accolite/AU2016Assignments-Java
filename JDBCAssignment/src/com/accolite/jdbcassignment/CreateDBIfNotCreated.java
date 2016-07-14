package com.accolite.jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



//import org.au.workshop.util.Constants;

public class CreateDBIfNotCreated {
	static Connection conn = null;
	static Connection conn2 = null;
	static Statement stmt = null,stmt2=null;
	public CreateDBIfNotCreated() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int choice;
		System.out.println("Enter choice");
		System.out.println("0 "+"PopulateValues ");
		System.out.println("1 "+"ListAllStates");
		System.out.println("2 "+"ListAllDistricts");
		System.out.println("3 "+"DisplayCitizenCount");
		System.out.println("4 "+"RemoveADistrict ");
		System.out.println("6 "+"ListOfCitizensUnderState");
		System.out.println("7 "+"ListOfCitizensUnderDistrict");
		System.out.println("8 "+"ShowHeadOfADistrict");
		System.out.println("9 "+":ChangeHead");
		System.out.println("10 "+"TechnicalDetails");
		System.out.println("11 "+"CreateTableIfnotExists");
		Scanner scan=new Scanner(System.in);
		choice=scan.nextInt();
		switch(choice)
		{
		case 0: //populateValues();
				PopulateValues Pv=new PopulateValues();
				Pv.populateValuesIntoTables();
				break;
		case 1:ListAllStates lb=new ListAllStates();
				lb.listingAllStates();
				break;
		case 2:ListAllDistricts ld=new ListAllDistricts();
				ld.listingAllDistricts();
				break;
		case 3:DisplayCitizenCount dcc=new DisplayCitizenCount();
				dcc.displayingCitizenCount();
				break;
		case 4:RemoveADistrict rad=new RemoveADistrict();
		rad.RemovingADistrict();
		break;
		case 6:ListOfCitizensUnderState locus=new ListOfCitizensUnderState();
		locus.displayingCitizenList();
				
		case 7:ListOfCitizensUnderDistrict locud=new ListOfCitizensUnderDistrict();
		locud.displayingCitizenListDistrict();
		break;
		case 8:ShowHeadOfADistrict shoad=new ShowHeadOfADistrict();
			  shoad.displayingHeadOfADistrict();
			  break;
		case 9:ChangeHead ch=new ChangeHead();
		ch.ChangingHead();
		case 10:TechnicalDetails tds=new TechnicalDetails();
				tds.listTechnicalData();
				
		break;

				
		case 11: createTableIfNotExists();
				break;
		}
	}
	
	public  static void createTableIfNotExists()
	{
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_datatbase1,Constants.username,Constants.password);
			stmt = conn.createStatement();
			System.out.println("Creating table if not exists");
			String createTable3 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.President' AND type = 'U') "
					+"USE database1 "
					+ "BEGIN "
					+ "CREATE TABLE President(PresidentId int not null,name varchar(255)) "
					+ "END";
			
			stmt.executeUpdate(createTable3);
			String createTable1 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.District' AND type = 'U') "+"USE database1 "
					+ "BEGIN "
					+ "CREATE TABLE District(districtId int not null,HeadId int not null,name varchar (255),StateId int not null) "
					+ "END";
			stmt.executeUpdate(createTable1);
			String createTable2 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.State' AND type = 'U') "+"USE database1 "
					+ "BEGIN "
					+ "CREATE TABLE State(stateId int not null,name varchar (255),PresidentId int not null) "
					+ "END";
			stmt.executeUpdate(createTable2);
			//conn.close();
			//conn=DriverManager.getConnection(Constants.DB_URL_database2,Constants.username,Constants.password);
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.Citizen' AND type = 'U') "+"USE database2 "
					+ "BEGIN "
					+ "CREATE TABLE Citizen(citizenId int not null,districtId int not null,name varchar (255),age int,type varchar(255)) "
					+ "END";
			stmt.executeUpdate(createTable);
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
