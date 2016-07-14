package JdbcConn;

import java.sql.*;
import JdbcUtil.Constants;

public class Creation {
	Connection conn = null;
	Statement stmt = null;
	String db1="Territory";
	String db2="Citizen";
	String dropTable=null;
	String createTable=null;
	Creation() {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	int CreateDb(String Db) {
		try {
			String sql = "create database " + Db;
			if (stmt.execute(sql)) {
				System.out.println("db already "+Db+" created");
				return 1;
			} else {
				System.out.println("db  created");
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}
	void table()
	{	
		
		  
		 try{  
		   dropTable ="USE  Territory; "+ "IF OBJECT_ID('dbo.State', 'U') "
				     + "IS NOT NULL DROP TABLE dbo.State; " ;
			   stmt.executeUpdate(dropTable);
			   createTable ="USE  Territory; "+ "CREATE TABLE State("
			     + "StateId int PRIMARY KEY IDENTITY(1,1),"
			     + "StateName varchar(50) not null);";
			   stmt.executeUpdate(createTable);
			   
	
			   
			   dropTable ="USE  Territory; "+ "IF OBJECT_ID('dbo.District', 'U') "
		     + "IS NOT NULL DROP TABLE dbo.District; " ;
	   stmt.executeUpdate(dropTable);
	   createTable ="USE  Territory; "+ "CREATE TABLE District("
	     + "DistrictId int PRIMARY KEY IDENTITY(1,1),"
	     + "DistrictName varchar(50) not null,"
	     + "head int,"
	     + "StateId int foreign key references dbo.State(StateId));";
	   stmt.executeUpdate(createTable);
	   
	 
		   
		   
		   			   
			   dropTable ="USE  Citizen; "+ "IF OBJECT_ID('dbo.Citizen', 'U') "
					     + "IS NOT NULL DROP TABLE dbo.Citizen; " ;
				   stmt.executeUpdate(dropTable);
				   createTable ="USE  Citizen; "+ "CREATE TABLE Citizen("
				     + "CitizenId int PRIMARY KEY IDENTITY(1,1),"
				     + "Name varchar(50) not null,"
				     + "head int not null,"
				     +"ParentId int,"
				     +"SpouseId int,"
				     +"age int not null,"
				     + "DistrictId int );";
				   stmt.executeUpdate(createTable);
			   
				   
				   dropTable ="USE  Territory; "+ "IF OBJECT_ID('dbo.President', 'U') "
			     + "IS NOT NULL DROP TABLE dbo.President; " ;
		   stmt.executeUpdate(dropTable);
		   createTable ="USE  Territory; "+ "CREATE TABLE President("
		     + "PresidentId int PRIMARY KEY IDENTITY(1,1),"
		     + "Name varchar(50) not null,"
		     + "country varchar(50) not null,"
		     + "CitizenId int );";
		   stmt.executeUpdate(createTable);
		   conn.close();
			
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	
		
	}
	void createTrigger()
	{try{
		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=AdventureWorks2014", "sa", "accolite");
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		dropTable ="USE  Citizen; "+ "IF OBJECT_ID('dbo.CreateCitizens', 'TR') "
			     + "IS NOT NULL DROP Trigger dbo.CreateCitizens"; 
		 stmt.executeUpdate(dropTable);

		String createTrigger =
			     "CREATE TRIGGER dbo.CreateCitizens "
			     + "ON dbo.Citizen "
			     + "AFTER INSERT "
			     +"AS "
			     +"IF EXISTS (SELECT *"
			     +" FROM dbo.Citizen c"
			     +" JOIN inserted AS i "
			     +"ON c.CitizenId = i.CitizenId"
			     +" JOIN Territory.dbo.District AS d "
			     +"ON d.DistrictId=i.DistrictId"
			     +" WHERE i.DistrictId is NOT NULL)"
			     +" BEGIN "
			     +"RAISERROR ('Improper District entered', 16, 1); "
			     +"ROLLBACK TRANSACTION; "
			     +"RETURN; " 
			     +"END;";
		   stmt.executeUpdate(createTrigger);

		dropTable ="USE  Citizen; "+ "IF OBJECT_ID('dbo.headCheck', 'TR') "
			     + "IS NOT NULL DROP Trigger dbo.headCheck"; 
		
		 stmt.executeUpdate(dropTable);
		String createTrigger2 =
				"Create Trigger dbo.headCheck "
				+"on dbo.Citizen "
				+"after INSERT "
			    +"AS declare @name nvarchar(10) declare @c int; set @c=1;"
				+"declare @head int  select @head=head from inserted i "
				+"declare @id int; select @name=Name from inserted i;select @id=CitizenId from inserted i;"
			    +"IF @head=1 and @c= (select count(*) from dbo.Citizen c where head=1) "
			    + "BEGIN "
			    + "RAISERROR ('there cant be no two president',17,1); "
			    +"ROLLBACK TRANSACTION; "
			    +"RETURN; " 
			     +"END;"
			    + "else begin insert into Territory.dbo.President values(@name,'india',@id); end;";
			     
		   stmt.executeUpdate(createTrigger2);
		   conn.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	
}
