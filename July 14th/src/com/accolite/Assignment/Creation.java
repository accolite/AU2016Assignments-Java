package com.accolite.Assignment;

import java.sql.*;
import org.au.workshop.util.Constants;

public class Creation {

	Statement stmt=null,stmt2=null;
	Connection conn = null;
	
	public Creation() {
		super();
		try{
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
		stmt = conn.createStatement();
		stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		String createDbIfNotExists,dropTable,createTable,sql;
		
//		createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'TEST1') CREATE DATABASE TEST1";
//		stmt.executeUpdate(createDbIfNotExists);
//		
//		System.out.println("Dropping table if exits");
//		dropTable ="USE  TEST1 "+ "IF OBJECT_ID('dbo.President', 'U') IS NOT NULL DROP TABLE dbo.President; " ;
//		stmt.executeUpdate(dropTable);
//		
//		dropTable ="USE  TEST1 "+ "IF OBJECT_ID('dbo.State', 'U') IS NOT NULL DROP TABLE dbo.State; " ;
//		stmt.executeUpdate(dropTable);
//		
//		dropTable ="USE  TEST1 "+ "IF OBJECT_ID('dbo.District', 'U') IS NOT NULL DROP TABLE dbo.District; " ;
//		stmt.executeUpdate(dropTable);
//	
//		createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'TEST2') CREATE DATABASE TEST2";
//		stmt.executeUpdate(createDbIfNotExists);
//
//		System.out.println("Dropping table if exits");
//		dropTable ="USE  TEST2 "+ "IF OBJECT_ID('dbo.Citizen', 'U') IS NOT NULL DROP TABLE dbo.Citizen; " ;
//		stmt.executeUpdate(dropTable);
		
		
		createTable = "USE TEST1 "
		+"CREATE TABLE President(Pid int unique not null,Name varchar (50),CountryName varchar(50)) ";
		stmt.executeUpdate(createTable);
		
		createTable ="USE TEST1 "
				+ "CREATE TABLE State(Sid int not null,name varchar (50),Pid int not null) ";
		stmt.executeUpdate(createTable);
		
		createTable ="USE TEST1 "
				+ "CREATE TABLE District(Did int not null,name varchar (50),Hid int,Sid int) ";
		stmt.executeUpdate(createTable);
		
		createTable ="USE TEST2 "
				+ "CREATE TABLE Citizen(Cid int unique not null,name varchar(50),age int not null,Headid int ,Pid int,Relation int) ";
		stmt.executeUpdate(createTable);
		
		ResultSet rs;
		sql = "INSERT INTO TEST1.dbo.President VALUES(3,'Modi','India')";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.President VALUES(8,'Obama','USA')";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.State VALUES(101,'Tamil Nadu',3)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.State VALUES(102,'Karnataka',3)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.State VALUES(103,'Dallas',8)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.State VALUES(104,'Texas',8)";
		rs=stmt2.executeQuery(sql);
						
		sql = "INSERT INTO TEST1.dbo.District VALUES(1001,'Chennai',1,101)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.District VALUES(1002,'Madurai',2,101)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.District VALUES(1003,'Banglore',4,102)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.District VALUES(1004,'Vijayawada',5,102)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.District VALUES(1005,'LosAngeles',9,103)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.District VALUES(1006,'Florida',10,103)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.District VALUES(1007,'LasVegas',11,104)";
		rs=stmt2.executeQuery(sql);
		
		sql = "INSERT INTO TEST1.dbo.District VALUES(1008,'Manhaten',12,104)";
		rs=stmt2.executeQuery(sql);

		
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(1,'Sridhar',25,1,3,2)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(2,'Jegan',22,2,3,1)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(3,'Modi',45,2,3,6)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(4,'Lokesh',25,4,3,5)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(5,'Pradeep',25,5,3,4)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(6,'Savithri',35,2,3,3)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(7,'Dinesh',30,2,3,2)");
		
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(8,'Obama',45,9,8,13)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(9,'Khan',25,9,8,10)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(10,'Salman',25,10,8,9)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(11,'Vijay',25,11,8,12)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(12,'Ajith',25,12,8,11)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(13,'Elizabeth',35,9,8,8)");
		rs=stmt2.executeQuery("INSERT INTO TEST2.dbo.Citizen VALUES(14,'Roger',25,9,8,8)");
//		stmt2.executeQuery("INSERT INTO TEST2.Citizen VALUES(15,'Sridhar',25,1,8,2)");
		
	
//		rs=stmt2.executeQuery("CREATE DATABASE TEST1_snapshot_name "
//				+"ON "
//				+"(NAME ='TEST1_Data',"
//				+"FILENAME ='D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST1_Data.ss')"
//				+"AS SNAPSHOT OF TEST1");
//		
//		rs=stmt2.executeQuery("CREATE DATABASE TEST2_snapshot_name "
//				+"ON "
//				+"(NAME ='TEST2_Data',"
//				+"FILENAME ='D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST2_Data.ss')"
//				+"AS SNAPSHOT OF TEST2");

		stmt.executeUpdate("BACKUP DATABASE TEST1 " 
			     +"TO DISK = \'D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST1_Data'");
		stmt.executeUpdate("BACKUP DATABASE TEST2 " 
			     +"TO DISK = \'D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST2_Data'");
		
		
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
		}finally {
			//TakeSnapshot();
			closeResources();
		}
	}

	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
			if (stmt2 != null)
				stmt2.close();
		} catch (SQLException se2) {
			se2.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Creation create = new Creation();
		System.out.println("Database and table Created");
	}

}
