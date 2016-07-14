package com.accolite.Assignment;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.au.workshop.util.Constants;

public class InteractiveApplication {
	Statement stmt;
	Connection conn;
	ResultSet rs;
	DatabaseMetaData dbmd;
	
	public InteractiveApplication() {
		super();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			stmt=null;
			conn=null;
			rs=null;
			dbmd=null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ListStates(){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("Select Sid,Name from TEST1.dbo.State");
			System.out.println("State ID\tName\n----------------------------");
			rs.beforeFirst();
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("sid");
				String name = rs.getString("Name");
				System.out.println(id+"\t"+name);
			}
			rs.close();
			closeResources();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ListDistricts(){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("Select Did,Name from TEST1.dbo.District");
			System.out.println("District ID\tName\n----------------------------");
			rs.beforeFirst();
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("Did");
				String name = rs.getString("Name");
				System.out.println(id+"\t"+name);
			}
			rs.close();
			closeResources();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Citizen_Count(){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("Select st.name as name,count(ct.Cid) as count  from TEST1.dbo.State st,TEST1.dbo.District dt,TEST2.dbo.Citizen ct	where st.Sid=dt.sid and dt.Hid=ct.Headid group by(st.name)");
			System.out.println("State Name\tCitizen Count\n----------------------------");
			rs.beforeFirst();
			while (rs.next()) {
				// Retrieve by column name
				String name = rs.getString("name");
				int id = rs.getInt("count");
				System.out.println(name+"\t"+id);
			}
			rs.close();
			closeResources();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void List_Citizen_State(int sid){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("Select st.sid as id,st.name as name,ct.name as cname  from TEST1.dbo.State st,TEST1.dbo.District dt,TEST2.dbo.Citizen ct	where st.sid="+sid+" and st.Sid=dt.sid and dt.Hid=ct.Headid");
			System.out.println("StateID\tState Name\tCitizen Count\n----------------------------");
			rs.beforeFirst();
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String cname = rs.getString("cname");
	//			boolean vip=isVIP(id);
	//			if(vip==true)
	//				System.out.println("****"+id+"\t"+name+"\t"+cname);
	//			else
				System.out.println(id+"\t"+name+"\t"+cname);

			}
			rs.close();
			closeResources();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	public boolean isVIP(int id){
		try{
		conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs=stmt.executeQuery("Select * from TEST2.dbo.Citizen ct where ct.Cid="+id+" and (ct.Relation=ct.pid or ct.Headid=ct.Cid)");
		rs.beforeFirst();
		if(rs.next())
			return true;
		return false;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
			}
		
	}
	
	public void List_Citizen_District(int Did){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("Select dt.Did as id,dt.name as name,ct.name as cname  from TEST1.dbo.District dt,TEST2.dbo.Citizen ct	where dt.Did="+Did+" and dt.Hid=ct.Headid");
			System.out.println("District ID\tDistrict Name\tCitizen Name\n----------------------------");
			rs.beforeFirst();
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String cname = rs.getString("cname");
		//		boolean vip=isVIP(id);
	//			if(vip==true)
//					System.out.println("****"+id+"\t"+name+"\t"+cname);
//				else
				System.out.println(id+"\t"+name+"\t"+cname);

//				System.out.println(id+"\t"+name+"\t"+cname);
			}
			rs.close();
			closeResources();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void District_Head(int Did){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("Select dt.Did as id,dt.name as name,ct.Cid as cid,ct.name as cname  from TEST1.dbo.District dt,TEST2.dbo.Citizen ct where dt.Did="+Did+" and dt.Hid=ct.Cid");
			System.out.println("District ID\tDistrict Name\tDistrict Head Id\tDistrict Head Name\n--------------------------------------");
			rs.beforeFirst();
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
			    int cid=rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(id+"\t"+name+"\t"+cid+"\t"+cname);
			}
			rs.close();
			closeResources();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void RemoveState(int sid){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate("DELETE FROM TEST1.dbo.State where sid="+sid);
			closeResources();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void RemoveDistrict(int did){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate("DELETE FROM TEST1.dbo.District where did="+did);
			closeResources();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void Change_District_Head(int Did,int Hid){
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("select * from TEST2.dbo.Citizen where Headid="+Hid+" and age<60");
			if(rs.next())
				{
				ResultSet rs1=stmt.executeQuery("Select Hid from TEST1.dbo.District where Did="+Did);
				rs1.next();
				int id = rs1.getInt("Hid");
				stmt.executeUpdate("UPDATE TEST2.dbo.Citizen set Headid="+Hid+" where Headid="+id);
				stmt.executeUpdate("UPDATE TEST1.dbo.District set Hid="+Hid+" where Did="+Did);
				System.out.println("District Head Changed");
				
				}
			else
				System.out.println("Invalid Candidate: Age>=60");
			closeResources();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void List_Meta_Data(){
		try{
			conn = DriverManager.getConnection(Constants.DB_URL1,Constants.USER,Constants.PASSWORD);
			dbmd = conn.getMetaData();
			System.out.println("Metadata for 1st Database");
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			conn.close();
			conn = DriverManager.getConnection(Constants.DB_URL2,Constants.USER,Constants.PASSWORD);
			dbmd = conn.getMetaData();
			System.out.println("Metadata for 2nd Database");
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			closeResources();
		}catch (Exception e) {
			System.out.println("Connection Failed");
	}
	}
	
	public void Restore_Db(){
		try{
			closeResources();
		conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.USER,Constants.PASSWORD);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		stmt.executeUpdate("use master "
		+"RESTORE DATABASE [TEST1] "
		+"FROM  DISK = N'D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST1_Data.bak'"
		+"WITH  FILE = 1,"  
		+"MOVE N'TEST1' TO N'D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST1_Data.mdf',"  
		+"MOVE N'TEST1_Log' TO N'D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST1_Log.ldf'"); 
	
		stmt.executeUpdate("use master "
				+"RESTORE DATABASE [TEST2] "
				+"FROM  DISK = N'D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST2_Data.bak'"
				+"WITH  FILE = 1,"  
				+"MOVE N'TEST2' TO N'D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST2_Data.mdf',"  
				+"MOVE N'TEST2_Log' TO N'D:\\Training\\Eclipse_Workspace\\Country\\Database\\TEST2_Log.ldf'"); 
			
		closeResources();
		}
		catch (Exception e) {
		System.out.println("Restore Failed");
		}
	}
	
	
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
//			if (stmt2 != null)
//				stmt2.close();
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
	public static void main(String[] args){
		int choice=0;
		Scanner sc=new Scanner(System.in);
		InteractiveApplication ia=new InteractiveApplication();
		while(choice!=12){
			System.out.println("\n1. List all the states\n2. List all the districts\n3. Display the citizen count for all the states\n4. Remove a State\n5. Remove a District\n6. List of citizens under state\n7. List of citizens under district\n8. Show head of a district\n9. Change Head of a district\n10. List technical details\n11. Create or restore data and tables\n12.End");
			System.out.println("Enter ur Choice:");
			choice=sc.nextInt();
			switch(choice){
				case 1:{
					ia.ListStates();
					break;
				}
				case 2:{
					ia.ListDistricts();
					break;
				}
				case 3:{
					ia.Citizen_Count();
					break;
				}
				case 4:{
					System.out.println("Enter the State id:");
					int sid=sc.nextInt();
					ia.RemoveState(sid);
					break;
				}
				case 5:{
					System.out.println("Enter the District id:");
					int Did=sc.nextInt();
					ia.RemoveDistrict(Did);
					break;
				}
				case 6:{
					System.out.println("Enter the State id:");
					int sid=sc.nextInt();
					ia.List_Citizen_State(sid);
					break;
				}
				case 7:{
					System.out.println("Enter the District id:");
					int Did=sc.nextInt();
					ia.List_Citizen_District(Did);
					break;
				}
				case 8:{
					System.out.println("Enter the District id:");
					int Did=sc.nextInt();
					ia.District_Head(Did);
					break;
				}
				case 9:{
					System.out.println("Enter the District id:");
					int Did=sc.nextInt();
					System.out.println("Enter the New Head id:");
					int hid=sc.nextInt();
					ia.Change_District_Head(Did,hid);
					break;
			}
				case 10:{
					ia.List_Meta_Data();
					break;
				}
				case 11:{
					ia.Restore_Db();
					break;
				}
				default:{
					choice=12;
					break;
				}
			}
		}
		System.out.println("Thank You");
	
	}

	
	
}
