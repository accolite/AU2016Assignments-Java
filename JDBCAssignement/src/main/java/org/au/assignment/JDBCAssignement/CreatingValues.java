package org.au.assignment.JDBCAssignement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreatingValues {
	
			 static Connection conn = null;
		 static Connection conn2 = null;
		 static Statement stmt = null,stmt2=null;
		 public CreatingValues() {
		  // TODO Auto-generated constructor stub
		 }
		 public static void main (String[] args) {
		  int choice;
		  Scanner scan=new Scanner(System.in);
		  while(true){
		  choice=scan.nextInt();
		  switch(choice)
		  {
		  case 1:AllDistrictsList ald=new AllDistrictsList();
		  		ald.listingAllDistricts();
		    break;
		  case 2:AllStatesList alc=new AllStatesList();
		  		alc.listingAllStates();
		  		break;
		  case 10: TechnicalDetails ct=new TechnicalDetails();
		  ct.listTechnicalData();
		    break;
		  case 11:
			  return;
		  }
		  }
		 }
		 
		 public static  void createTableIfNotExists()
		 {
		  try {
		   Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		   conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
		   stmt = conn.createStatement();
		   System.out.println("Creating table if not exists");
		   String createTable3 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.President' AND type = 'U') "
		     +"USE 1StDatabase "
		     + "BEGIN "
		     + "CREATE TABLE President(PresidentId int not null,name varchar(255)) "
		     + "END";
		   
		   stmt.executeUpdate(createTable3);
		   String createTable1 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.District' AND type = 'U') "+"USE 1stDatabase "
		     + "BEGIN "
		     + "CREATE TABLE District(districtId int not null,HeadId int not null,name varchar (255),StateId int not null) "
		     + "END";
		   stmt.executeUpdate(createTable1);
		   String createTable2 = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.State' AND type = 'U') "+"USE 1stDatabase "
		     + "BEGIN "
		     + "CREATE TABLE State(stateId int not null,name varchar (255),PresidentId int not null) "
		     + "END";
		   stmt.executeUpdate(createTable2);
		   //conn.close();
		   //conn=DriverManager.getConnection(Constants.DB_URL_database2,Constants.username,Constants.password);
		   String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.Citizen' AND type = 'U') "+"USE 2ndDatabase "
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


