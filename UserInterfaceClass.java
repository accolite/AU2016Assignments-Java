/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 14, 2016

*

*  @author :: Balaji P

* ***************************************************************************

*/
package com.accolite.JDBCAssignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;



import com.sun.glass.ui.Size;
import com.sun.org.apache.xml.internal.security.Init;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import sun.management.resources.agent;



// TODO: Auto-generated Javadoc
/**
 * The Class UserInterfaceClass.
 */
public class UserInterfaceClass {

	/** The connection. */
	private Connection connection = null;
	
	/** The result set. */
	ResultSet resultSet = null;
	
	/** The statement. */
	private Statement statement = null;
	
	/** The prepared statement. */
	private PreparedStatement preparedStatement = null;
	
	/** The sql. */
	String sql;
	
	/** The pcid. */
	private int pcid = 555;
	
	/** The ssid. */
	private int[] ssid = {507316,500028};
	
	/** The sname. */
	private String[] sname = {"telangana","andhra"};
	
	/** The ddid. */
	private int[] ddid = {12,15,18,23,25,29};
	
	/** The dname. */
	private String[] dname = {"Khammam","Hyderabad","Ranga Reddy","Krishna","west godavari","east godavari"};
	
	/** The dheadid. */
	private int[] dheadid = {129,154,186,231,254,297};
	
	/** The dsid. */
	private int[] dsid = {507316,507316,507316,500028,500028,500028};
	
	/** The cid. */
	private int[] cid = {121, 125, 129, 154, 156, 157, 183, 186, 189, 231, 234, 236, 252, 254, 258, 295, 296, 297,555};
	
	/** The cname. */
	private String[] cname = {"Balaji","Indu","Srinu","Santosh","Deepa","Srinivas","Bharath","Murali","Sharmila",
			"Namrath","Prabhakar","Anita","Shally","Vishal","Deeksha","Mitul","Mounika","Ravi","obama"};
	
	/** The cage. */
	private int[] cage = {25,52,54,53,81,66,34,43,32,37,76,34,54,87,12,65,45,47,44};
	
	/** The cdid. */
	private int[] cdid = {12,12,12,15,15,15,18,18,18,23,23,23,25,25,25,29,29,29,29};
	
	/** The sid. */
	private int[] sid = {0,129,125,0,157,156,186,183,0,0,0,0,258,0,252,0,297,296,0};

	/** The fid. */
	private int[] fid = {129,0,0,157,0,0,189,0,0,234,0,0,0,258,0,0,0,295,0};
	
	/** The mid. */
	private int[] mid = {125,0,0,156,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	/**
	 * President enterdata.
	 */
	private void presidentEnterdata(){
		try {
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement("use adb1 Insert into adb1.dbo.president (citizenid) values (?)");
			preparedStatement.setInt(1, pcid);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * District enter data.
	 */
	private void districtEnterData(){
		int size = 0;
		size = ddid.length;
		try {
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement("use adb1 Insert into adb1.dbo.district (districtid,districtname,headid,stateid) values (?,?,?,?)");
		} catch (Exception e) {
			// TODO: handle exception
		}
		for(int i = 0; i< size; i++){
			try {
				preparedStatement.setInt(1, ddid[i]);
				preparedStatement.setString(2, dname[i]);
				preparedStatement.setInt(3, dheadid[i]);
				preparedStatement.setInt(4, dsid[i]);
				preparedStatement.addBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			preparedStatement.executeBatch();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * State enter data.
	 */
	private void stateEnterData(){
		int size = ssid.length;
		try {
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement("use adb1 Insert into adb1.dbo.state (stateid,statename) values (?,?)");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i< size; i++){
			try {
				preparedStatement.setInt(1, ssid[i]);
				preparedStatement.setString(2, sname[i]);
				
				preparedStatement.addBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			//int[] i = 
			preparedStatement.executeBatch();
			//System.out.println(i);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Citizen enter data.
	 */
	private void citizenEnterData(){
		int size = cid.length;
		try {
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement("use db2 Insert into db2.dbo.citizen (citizenid,citizenname,age,districtid,spouseid,fatherid,motherid) values (?,?,?,?,?,?,?)");

		} catch (SQLException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i< size; i++){
			try {
				preparedStatement.setInt(1, cid[i]);
				preparedStatement.setString(2, cname[i]);
				preparedStatement.setInt(3, cage[i]);
				preparedStatement.setInt(4, cdid[i]);
				preparedStatement.setInt(5, sid[i]);
				preparedStatement.setInt(6, fid[i]);
				preparedStatement.setInt(7, mid[i]);
				
				preparedStatement.addBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			//int[] i = 
			preparedStatement.executeBatch();
			//System.out.println(i);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * User interface class.
	 */
	public UserInterfaceClass(){	
		Init();
	}
	
	/**
	 * Inits the.
	 */
	public void Init(){
		try {
			Class.forName(Constants.JTDS_DRIVER);
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			statement = connection.createStatement();
			//creating adb1
			String sql1 = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'adb1') CREATE DATABASE adb1";
			//Creating db2
			String sql2 = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'DB2') CREATE DATABASE DB2";
			
			//int i = 
			statement.executeUpdate(sql1);
			//System.out.println(i);
			//i = 
			statement.executeUpdate(sql2);
			//System.out.println(i);
			
			//dropping president table 
			sql1 = "USE  adb1 "+ "IF OBJECT_ID('dbo.president', 'U') IS NOT NULL DROP TABLE dbo.president; " ;
			//i = 
			statement.executeUpdate(sql1);
			//System.out.println(i);
			
			//Creating president table
			sql1 = "IF  NOT EXISTS (SELECT * FROM adb1.sys.tables WHERE name = N'dbo.president' AND type = 'U') "
					+ "BEGIN "
					+ "USE adb1 "
					+ "CREATE TABLE president(citizenid int ) "
					+ "END";
			statement.executeUpdate(sql1);
			
			
			//dropping State Table
			sql1 = "USE  adb1 "+ "IF OBJECT_ID('dbo.state', 'U') IS NOT NULL DROP TABLE dbo.state; " ;
			statement.executeUpdate(sql1);
			//Creating state table
			sql1 = "IF  NOT EXISTS (SELECT * FROM adb1.sys.tables WHERE name = N'dbo.state' AND type = 'U') "
					+ "BEGIN "
					+ "USE adb1 "
					+ "CREATE TABLE state(stateid int not null, statename varchar(50) ) "
					+ "END";
			statement.executeUpdate(sql1);
			
			//dropping district table
			sql1 = "USE  adb1 "+ "IF OBJECT_ID('dbo.district', 'U') IS NOT NULL DROP TABLE dbo.district; " ;
			statement.executeUpdate(sql1);
			//Creating state table
			sql1 = "IF  NOT EXISTS (SELECT * FROM adb1.sys.tables WHERE name = N'dbo.district' AND type = 'U') "
					+ "BEGIN "
					+ "USE adb1 "
					+ "CREATE TABLE district(districtid int not null, districtname varchar(50), headid int ,stateid int ) "
					+ "END";
			statement.executeUpdate(sql1);
			
			presidentEnterdata();
			districtEnterData();
			stateEnterData();
			
			//deleting citizen table
			sql1 = "USE  db2 "+ "IF OBJECT_ID('dbo.citizen', 'U') IS NOT NULL DROP TABLE dbo.citizen; " ;
			statement.executeUpdate(sql1);
			//Creating citizen table
			sql1 = "IF  NOT EXISTS (SELECT * FROM DB2.sys.tables WHERE name = N'dbo.citizen' AND type = 'U') "
					+ "BEGIN "
					+ "USE DB2 "
					+ "CREATE TABLE citizen(citizenid int not null, citizenname varchar(50), districtid int , age int, spouseid int, fatherid int, motherid int) "
					+ "END";
			statement.executeUpdate(sql1);
			
			//stateEnterData();
			citizenEnterData();
			
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}

	}
	
	/**
	 * Removes the state.
	 */
	public void removeState(){
		int i;
		try{
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter state id to remove");
			i = Integer.parseInt(bReader.readLine());
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement("use adb1 delete from dbo.state where dbo.state.stateid=?");
			preparedStatement.setInt(1, i);
			preparedStatement.executeUpdate();
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * All states.
	 */
	public void allStates(){
		sql = "use adb1 select stateid,statename from adb1.dbo.state";
		Connection connection;
		try {
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("state id: "+resultSet.getInt(1)+" \tstate name: "+resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * Citizen count.
	 */
	public void citizenCount(){
		sql = "select count(stateid),stateid from db2.dbo.citizen as c join (select districtid,s.stateid from adb1.dbo.district as d join adb1.dbo.state as s on d.stateid = s.stateid) as sd"
				+" on c.districtid = sd.districtid group by sd.stateid";
		try {
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("count: "+resultSet.getInt(1)+" \tstate: "+resultSet.getInt(2));
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * List citizen in state.
	 */
	public void listCitizenInState(){
		int i;
		try{
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter state id to remove");
			i = Integer.parseInt(bReader.readLine());
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement("select c.citizenname,c.districtid from db2.dbo.citizen as c join (select districtid from adb1.dbo.district as d join adb1.dbo.state as s on d.stateid = s.stateid where s.stateid = ?) as sd"
+" on c.districtid = sd.districtid ");
			preparedStatement.setInt(1, i);
			resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("citizen name: "+resultSet.getString(1)+" \tdistrict id: "+resultSet.getInt(2));
			}
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes the district.
	 */
	public void removeDistrict(){
		int i;
		try{
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter district id to remove");
			i = Integer.parseInt(bReader.readLine());
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement("use adb1 delete from dbo.district where dbo.district.districtid=?");
			preparedStatement.setInt(1, i);
			preparedStatement.executeUpdate();
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Head dist.
	 */
	public void headDist(){
		String sql = "select c.citizenname, hid.headid from db2.dbo.citizen as c join (select d.headid from adb1.dbo.district as d join adb1.dbo.state as s on d.stateid = s.stateid where d.districtid = ?) as hid on hid.headid = c.citizenid";
		int i;
		try{
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter district id to find head");
			i = Integer.parseInt(bReader.readLine());
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, i);
			resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("citizen name: "+resultSet.getString(1)+" \thead id: "+resultSet.getInt(2));
			}
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * List citizen in district.
	 */
	public void listCitizenInDistrict(){
		int i;
		try{
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter district id to list");
			i = Integer.parseInt(bReader.readLine());
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement("select c.citizenname,c.districtid from db2.dbo.citizen as c join (select districtid,s.stateid from adb1.dbo.district as d join adb1.dbo.state as s on d.stateid = s.stateid) as sd"
					 +" on c.districtid = sd.districtid where c.districtid = ? ");
			preparedStatement.setInt(1, i);
			resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("citizen name: "+resultSet.getString(1)+" \tdistrict id: "+resultSet.getInt(2));
			}
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * All districts.
	 */
	public void allDistricts(){
		sql = "select districtid,districtname from adb1.dbo.district as d join adb1.dbo.state as s on d.stateid = s.stateid";
		try {
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("district id: "+resultSet.getInt(1)+" \tdistrict name: "+resultSet.getString(2));
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert citizen.
	 */
	public void insertCitizen(){
		int i;
		String string;
		BufferedReader brReader = new BufferedReader(new InputStreamReader(System.in));
		String sql = "use db2 INSERT INTO [dbo].[citizen] ([citizenid] ,[citizenname] ,[districtid] ,[age] ,[spouseid] ,[fatherid],[motherid])"
    +" VALUES(?,?,?,?,?,?,?)";
		try{
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement(sql);
			boolean flag = true;
			while(flag == true){
				System.out.println("enter citizen id: as number");
				try {
					preparedStatement.setInt(1, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter citizen name: as string");
				try {
					preparedStatement.setString(2, (brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter district id: as number");
				try {
					preparedStatement.setInt(3, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter age: as number");
				try {
					preparedStatement.setInt(4, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter spouse id: as number if no spouse enter 0");
				try {
					preparedStatement.setInt(5, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter father id: as number");
				try {
					preparedStatement.setInt(6, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter mother id: as number");
				try {
					preparedStatement.setInt(7, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			
			preparedStatement.executeUpdate();
			connection.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert state.
	 */
	public void insertState(){
		int i;
		String string;
		BufferedReader brReader = new BufferedReader(new InputStreamReader(System.in));
		String sql = "use adb1 INSERT INTO [dbo].[state] ([stateid] ,[statename]  )"
    +" VALUES(?,?)";
		
		try{
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement(sql);
			boolean flag = true;
		
			
			while(flag == true){
				System.out.println("enter state id: as number");
				try {
					preparedStatement.setInt(1, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter state name: as string");
				try {
					preparedStatement.setString(2, (brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			
			preparedStatement.executeUpdate();
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert dist.
	 */
	public void insertDist(){
		int i;
		String string;
		BufferedReader brReader = new BufferedReader(new InputStreamReader(System.in));
		String sql = "use adb1 INSERT INTO [dbo].[district] ([districtid] ,[districtname] ,[headid] ,[stateid] )"
    +" VALUES(?,?,?,?)";
		
		try{
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement(sql);
			boolean flag = true;
			while(flag == true){
				System.out.println("enter district id: as number");
				try {
					preparedStatement.setInt(1, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter district name: as string");
				try {
					preparedStatement.setString(2, (brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = true;
			while(flag == true){
				System.out.println("enter head id: as number");
				try {
					preparedStatement.setInt(3, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			flag = false;
			while(flag == true){
				System.out.println("enter state id: as number");
				try {
					preparedStatement.setInt(4, Integer.parseInt(brReader.readLine()));
					flag = false;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please enter a valid input");
				}
			}
			
			
			preparedStatement.executeUpdate();
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * List details.
	 */
	public void listDetails(){
		try {
			DatabaseMetaData dbmd = null;
			Class.forName(Constants.JTDS_DRIVER);
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			dbmd = connection.getMetaData();
			
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

		} catch (Exception e) {

		}
	}
	
	/**
	 * Change head.
	 */
	public void changeHead(){
		int distid, newid;
		int age = 0;
		BufferedReader brReader = new BufferedReader(new InputStreamReader(System.in));
		String sql = "use adb1 update dbo.district set dbo.district.headid = ? where dbo.district.districtid = ?";
		String sql2 = "use db2 select age from dbo.citizen where dbo.citizen.citizenid = ? and dbo.citizen.districtid = ?";
		
		try{
			System.out.println("Enter district id:");
			distid = Integer.parseInt(brReader.readLine());
			System.out.println("Enter new id");
			newid = Integer.parseInt(brReader.readLine());
			connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newid);
			preparedStatement.setInt(2, distid);
			resultSet = preparedStatement.executeQuery();
			try{
			while(resultSet.next()){
				age = resultSet.getInt(1);
			}
				}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			if(age > 0 && age < 60){
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, newid);
				preparedStatement.setInt(2, distid);
				preparedStatement.executeUpdate();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		UserInterfaceClass uInterfaceClass = new UserInterfaceClass();
		
		/*try {
			Connection connection = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			PreparedStatement preparedStatement = connection.prepareStatement("use AdventureWorks2014 select * from dbo.employees");
			ResultSet rSet = preparedStatement.executeQuery();
			
			while(rSet.next()){
				System.out.println(rSet.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("here main");
		int i = 0;
		boolean flag = true;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		try{
		while(flag){
			
			System.out.println("Select an option 1. List all States \n"
					+ "2. List all districts\n"
					+ "3. Display the citizen count for all the states\n"
					+ "4. Remove a district\n"
					+ "5. Remove a state\n"
					+ "6. List of citizens under state\n"
					+ "7. List of citizens under district\n"
					+ "8. Show head of a district\n"
					+ "9. Change Head of a district\n"
					+ "10. List technical details\n"
					+ "11. Create or restore data and tables\n"
					+ "12. Enter a citizen\n"
					+ "13. Inset district\n"
					+ "14. Insert State\n"
					+ " 15.Exit");
			i = Integer.parseInt(bReader.readLine());
			switch(i){
				case 1: uInterfaceClass.allStates();
					break;
				case 2:uInterfaceClass.allDistricts();
					break;
				case 3: uInterfaceClass.citizenCount();
					break;
				case 4: uInterfaceClass.removeDistrict();
					break;
				case 5: uInterfaceClass.removeState();
					break;
				case 6: uInterfaceClass.listCitizenInState();
					break;
				case 7: uInterfaceClass.listCitizenInDistrict();
					break;
				case 8: uInterfaceClass.headDist();
					break;
				case 9: uInterfaceClass.changeHead();
					break;
				case 10: uInterfaceClass.listDetails();
					break;
				case 11: uInterfaceClass.Init();
					break;
				case 12: uInterfaceClass.insertCitizen();
					break;
				case 13: uInterfaceClass.insertDist();
					break;
				case 14: uInterfaceClass.insertState();
				break;
				case 15: flag = false;
					break;
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
		}
		
	}

