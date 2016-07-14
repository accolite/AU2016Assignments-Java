package com.accolite.db;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class PresidentJDBC {
	DBHandel dbh;
	public PresidentJDBC(){
		dbh = new DBHandel();
		init();
	}
	private void init() {
		try {
			dbh.establishConnection();
			dbh.stmt = dbh.conn.createStatement();
//			System.out.println(dbh.stmt.execute("SELECT name FROM master.dbo.sysdatabases WHERE name = N'Government'"));
//			if(!dbh.stmt.execute("SELECT name FROM master.dbo.sysdatabases WHERE name = N'Government'") ||
//					!dbh.stmt.execute("SELECT name FROM master.dbo.sysdatabases WHERE name = N'Public'")){
				String createGovernmentIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'Government') CREATE DATABASE Government";
				dbh.stmt.executeUpdate(createGovernmentIfNotExists);
//				dbh.reEstablish();		
//				dbh.stmt = dbh.conn.createStatement();
				String createPublicIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'PublicDB') CREATE DATABASE PublicDB";
				dbh.stmt.executeUpdate(createPublicIfNotExists);
				dbh.reEstablish();		
				dbh.stmt = dbh.conn.createStatement();
				dbh.stmt.execute("use Government");
//				System.out.println(dbh.stmt.executeQuery("SELECT name FROM Government.SYS.TABLES WHERE name = N'President'").next());
				if(!dbh.stmt.executeQuery("SELECT name FROM Government.SYS.TABLES WHERE name = N'President'").next()){
					System.out.println("creating President");
					String createPresidentIfNotExists = "CREATE table President (pid int primary key not null, CountryName nvarchar(30) not null);";
					dbh.stmt.executeUpdate(createPresidentIfNotExists);
					dbh.stmt.executeUpdate("insert into dbo.President values (3551,'India')");
					dbh.stmt.executeUpdate("insert into dbo.President values (3549,'USA')");
				}
				if(!dbh.stmt.executeQuery("SELECT name FROM Government.SYS.TABLES WHERE name = N'State'").next()){
					System.out.println("creating State");
					String createStateIfNotExists = "CREATE table State (sid int not null, StateName nvarchar(30) not null,pid int references dbo.President(pid) not null);";
					dbh.stmt.executeUpdate(createStateIfNotExists);
					dbh.stmt.executeUpdate("insert into dbo.State values (1,'TN',3551)");
					dbh.stmt.executeUpdate("insert into dbo.State values (2,'AP',3551)");
					dbh.stmt.executeUpdate("insert into dbo.State values (3,'TL',3551)");
					dbh.stmt.executeUpdate("insert into dbo.State values (4,'Kl',3551)");
					dbh.stmt.executeUpdate("insert into dbo.State values (5,'Kn',3551)");
					dbh.stmt.executeUpdate("insert into dbo.State values (6,'Dellas',3549)");
					dbh.stmt.executeUpdate("insert into dbo.State values (7,'Florida',3549)");
					dbh.stmt.executeUpdate("insert into dbo.State values (8,'Newyork',3549)");
					dbh.stmt.executeUpdate("insert into dbo.State values (9,'Washigton',3549)");
					dbh.stmt.executeUpdate("insert into dbo.State values (10,'Texas',3549)");
				}
				if(!dbh.stmt.executeQuery("SELECT name FROM Government.SYS.TABLES WHERE name = N'District'").next()){
					System.out.println("creating District");
					String createDistrictIfNotExists = "CREATE table District (did int not null, DistrictName nvarchar(30) not null,"+
							"sid int not null,headID int null);";
					dbh.stmt.executeUpdate(createDistrictIfNotExists);
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Chennai',1,3540)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Vellore',1,3541)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Nelloor',2,3542)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Gundoor',2,3543)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Hydrabad',3,3544)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Vishakapatnam',3,3545)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Munnar',4,3546)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Cochin',4,3547)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Bangalore',5,3548)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Vijaya Wada',5,3550)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Irving',6,3552)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Mansfield',6,3553)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Orlando',7,3554)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Miami',7,3555)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Manhatten',8,3556)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Brooklyn',8,3557)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'Arlington',9,3558)");
					dbh.stmt.executeUpdate("insert into dbo.District values (2,'Wisconsin',9,3559)");
					dbh.stmt.executeUpdate("insert into dbo.District values (1,'El Paso',10,3560)");
				}
//				dbh.reEstablish();		
//				dbh.stmt = dbh.conn.createStatement();
				dbh.stmt.execute("use PublicDB");
				if(!dbh.stmt.executeQuery("SELECT name FROM PublicDB.SYS.TABLES WHERE name = N'Citizen'").next()){
					System.out.println("creating Citizen");
					String createDistrictIfNotExists = "CREATE table Citizen (cid int primary key not null, Name nvarchar(30) not null,"+
							"age int not null, did int null,headID int null, pid int null, relativeID int null, relation nvarchar(30) null)";
					dbh.stmt.executeUpdate(createDistrictIfNotExists);
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3551,'Lokesh',21,1,3540,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3540,'Jegan',21,1,3540,3551,3539,'wife')");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3539,'Andrea',21,1,3540,3551,3540,'Husband')");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3541,'Gokul',22,2,3541,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3542,'Gokul Kumar',24,1,3542,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3543,'Ashoke',25,2,3543,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3544,'Balaji',26,1,3544,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3545,'Srithar',27,2,3545,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3546,'Pradeep',22,1,3546,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3547,'Sharuk',23,2,3547,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3548,'Sai',24,1,3548,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3550,'Karthi',25,2,3550,3551,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3549,'Jhon Snow',26,1,3552,3549,3561,'Wife')");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3552,'Ron',22,1,3552,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3553,'Rick',26,2,3553,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3554,'Morty',27,1,3554,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3555,'Saitama',28,2,3555,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3556,'Goku',29,1,3556,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3557,'Tony Stark',21,2,3557,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3558,'Turing',27,1,3558,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3559,'Sherlock',24,2,3559,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3560,'Watson',24,1,3560,3549,NULL,NULL)");
					dbh.stmt.executeUpdate("insert into dbo.Citizen values (3561,'Khaleesi',26,1,3560,3549,3549,'Husband')");
				}
				//code to create backup
//				dbh.reEstablish();		
//				dbh.stmt = dbh.conn.createStatement();
//				dbh.stmt.execute("use Government");
//				dbh.stmt.executeUpdate("BACKUP DATABASE Government " 
//				        +"TO DISK = N'C:\\Program Files\\Microsoft SQL Server\\MSSQL12.MSSQLSERVER\\MSSQL\\DATA'");
//				dbh.reEstablish();		
//				dbh.stmt = dbh.conn.createStatement();
//				dbh.stmt.execute("use PublicDB");
//				dbh.stmt.executeUpdate("BACKUP DATABASE PublicDB " 
//				        +"TO DISK = N'C:\\Program Files\\Microsoft SQL Server\\MSSQL12.MSSQLSERVER\\MSSQL\\DATA'");
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeResources();
	}
	public static void main(String[]args){
		PresidentJDBC pdb = new PresidentJDBC();
		Scanner in = new Scanner(System.in);
		boolean doLoop = true;
		while(doLoop){
			System.out.println("1. List all the states\n"+
								"2. List all the districts\n"+
								"3. Display the citizen count for all the states\n"+
								"4. Remove a district\n"+
								"5. Remove a state\n"+
								"6. List of citizens under state\n"+
								"7. List of citizens under district\n"+
								"8. Show head of a district\n"+
								"9. Change Head of a district\n"+
								"10. List technical details\n"+
								"11. Create or restore data and tables\n");
			switch(in.nextInt()){
				case 1: pdb.listStates();
					break;
				case 2: pdb.listDistricts();
					break;
				case 3: pdb.citizenCountForStates();
					break;
				case 4: System.out.println("Enter district name:");
						pdb.removeDistrict(in.next());
					break;
				case 5: System.out.println("Enter state name:");
						pdb.removeState(in.next());
					break;
				case 6: System.out.println("Enter state name:");
						pdb.listCitizensinState(in.next());
					break;
				case 7: System.out.println("Enter district name:");
						pdb.listCitizensinDistrict(in.next());
					break;
				case 8: System.out.println("Enter district name:");
						pdb.showDistrictHead(in.next());
					break;
				case 9: System.out.println("Enter district name:");
						String district=in.next();
						System.out.println("Enter Head's ssn:");
						pdb.changeDistrictHead(district,in.nextInt());
					break;
				case 10: pdb.listTechnicalDetails();
					break;
				case 11: pdb.restore();
					break;
				default: doLoop=false;
			}
		}
	}

	private void restore() {
			
	}

	private void listTechnicalDetails() {
		dbh.reEstablish();
		try {
			ResultSetMetaData rsmd=null;
			DatabaseMetaData dbmd = dbh.conn.getMetaData();
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
			dbh.stmt=dbh.conn.createStatement();
			rsmd=dbh.stmt.executeQuery("select*from Government.dbo.President").getMetaData();
			System.out.println("Table Name "+rsmd.getTableName(1));
			System.out.println("Column count "+rsmd.getColumnCount());
			dbh.stmt=dbh.conn.createStatement();
			rsmd=dbh.stmt.executeQuery("select*from Government.dbo.State").getMetaData();
			System.out.println("Table Name "+rsmd.getTableName(1));
			System.out.println("Column count "+rsmd.getColumnCount());
			dbh.stmt=dbh.conn.createStatement();
			rsmd=dbh.stmt.executeQuery("select*from Government.dbo.District").getMetaData();
			System.out.println("Table Name "+rsmd.getTableName(1));
			System.out.println("Column count "+rsmd.getColumnCount());
			dbh.stmt=dbh.conn.createStatement();
			rsmd=dbh.stmt.executeQuery("select*from PublicDB.dbo.Citizen").getMetaData();
			System.out.println("Table Name "+rsmd.getTableName(1));
			System.out.println("Column count "+rsmd.getColumnCount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
	}

	private void changeDistrictHead(String district, int cid) {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select * from Government.dbo.District as d inner join "+
			"PublicDB.dbo.Citizen as c on d.headId=c.headId and c.age < 60 and c.cid = "+cid+" and d.DistrictName like '"+district+"'");
			if(rs.next()){
				dbh.stmt.close();
				dbh.stmt=dbh.conn.createStatement();
				rs=dbh.stmt.executeQuery("Select headID from Government.dbo.District where DistrictName like '"+district+"'");
				int headID=0;
				if(rs.next())
					headID=rs.getInt("headID");
				dbh.pstmt=dbh.conn.prepareStatement("Update Government.dbo.District set headID=? where DistrictName like ?");
				dbh.pstmt.setInt(1, cid);
				dbh.pstmt.setString(2, district);
				dbh.pstmt.executeUpdate();
				dbh.pstmt.close();
				dbh.pstmt=dbh.conn.prepareStatement("Update PublicDB.dbo.Citizen set headID=? where headID=?");
				dbh.pstmt.setInt(1, cid);
				dbh.pstmt.setInt(2, headID);
				dbh.pstmt.executeUpdate();
			}else System.out.println("Invalid Candidate");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
	}

	private void showDistrictHead(String name) {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select c.cid as cid,c.relativeID as rid,c.Name as Name from Government.dbo.District as d inner join "+
			"PublicDB.dbo.Citizen as c on d.headID=c.cid and d.DistrictName like '"+name+"'");
			System.out.println("-------------------");
			System.out.println("|Head Name\t|");
			System.out.println("-------------------");
			while(rs.next()){
				System.out.println("|"+//(isVIP(rs.getInt("cid"))||isVIP(rs.getInt("rid"))?"*** ":" ")+
			rs.getString("Name")+"|");
			}
			System.out.println("---------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
	}

	private void listCitizensinDistrict(String name) {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select c.cid as cid,c.relativeID as rid, c.Name as Name from Government.dbo.District as d inner join "+
			"PublicDB.dbo.Citizen as c on d.headID=c.headID and d.DistrictName like '"+name+"'");
			System.out.println("-------------------");
			System.out.println("|Citizen Name\t|");
			System.out.println("-------------------");
			while(rs.next()){
				System.out.println("|"+//(isVIP(rs.getInt("cid"))||isVIP(rs.getInt("rid"))?"*** ":" ")+
			rs.getString("Name")+"|");
			}
			System.out.println("---------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
	}

	private void listCitizensinState(String name) {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select c.cid as cid,c.relativeID as rid, c.Name as Name from Government.dbo.State as s inner join "+
			"Government.dbo.District as d on s.sid=d.sid and s.StateName like '"+name+"' inner join PublicDB.dbo.Citizen as c on d.headID=c.headID");
			System.out.println("-------------------");
			System.out.println("|Citizen Name\t|");
			System.out.println("-------------------");
			while(rs.next()){
				System.out.println("|"+//(isVIP(rs.getInt("cid"))||isVIP(rs.getInt("rid"))?"*** ":" ")+
			rs.getString("Name")+"|");
			}
			System.out.println("---------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
	}

	private void removeState(String name) {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select sid from Government.dbo.State where StateName like '"+name+"'");
			int sid=0;
			if(rs.next())
				sid=rs.getInt("sid");
			dbh.pstmt=dbh.conn.prepareStatement("delete from Government.dbo.State where StateName like ?");
			dbh.pstmt.setString(1, name);
			dbh.pstmt.executeUpdate();
			dbh.pstmt.close();
			removeDistrict(sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();		
	}
	private void removeDistrict(int sid) {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select headID from Government.dbo.District where sid="+sid);
			int headID=0;
			if(rs.next())
				headID=rs.getInt("headID");
			dbh.pstmt=dbh.conn.prepareStatement("delete from Government.dbo.District where sid=?");
			dbh.pstmt.setInt(1, sid);
			dbh.pstmt.executeUpdate();
			dbh.pstmt.close();
			dbh.pstmt=dbh.conn.prepareStatement("update PublicDB.dbo.Citizen set headID=NULL where headID = ?");
			dbh.pstmt.setInt(1, headID);
			dbh.pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
	}
	private void removeDistrict(String name) {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select headID from Government.dbo.District where DistrictName like '"+name+"'");
			int headID=0;
			if(rs.next())
				headID=rs.getInt("headID");
			dbh.pstmt=dbh.conn.prepareStatement("delete from Government.dbo.District where DistrictName like ?");
			dbh.pstmt.setString(1, name);
			dbh.pstmt.executeUpdate();
			dbh.pstmt.close();
			dbh.pstmt=dbh.conn.prepareStatement("update PublicDB.dbo.Citizen set headID=NULL where headID = ?");
			dbh.pstmt.setInt(1, headID);
			dbh.pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
	}

	private void citizenCountForStates() {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select s.StateName, count(c.cid) as ccount from Government.dbo.State as s inner join "+
			"Government.dbo.District as d on s.sid=d.sid inner join PublicDB.dbo.Citizen as c on d.headID=c.headID group by s.StateName");
			System.out.println("----------------------------------");
			System.out.println("|StateName\tCitizen Count\t|");
			System.out.println("----------------------------------");
			while(rs.next()){
				System.out.println("|"+rs.getString("StateName")+"\t"+rs.getInt("ccount")+"|");
			}
			System.out.println("---------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();		
	}

	private void listDistricts() {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select DistrictName from Government.dbo.District");
			System.out.println("---------------------");
			System.out.println("|DistrictName\t|");
			System.out.println("---------------------");
			while(rs.next()){
				System.out.println("|"+rs.getString("DistrictName")+"\t|");
			}
			System.out.println("---------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();	
	}

	private void listStates() {
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select StateName from Government.dbo.State");
			System.out.println("---------------------");
			System.out.println("|StateName\t|");
			System.out.println("---------------------");
			while(rs.next()){
				System.out.println("|"+rs.getString("StateName")+"\t|");
			}
			System.out.println("---------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
	}
	private boolean isVIP(int id){
		dbh.reEstablish();
		try {
			dbh.stmt=dbh.conn.createStatement();
			ResultSet rs=dbh.stmt.executeQuery("Select pid from Government.dbo.President where pid="+id);
			if(rs.next())return true;
			dbh.stmt.close();
			dbh.stmt=dbh.conn.createStatement();
			rs=dbh.stmt.executeQuery("Select headID from Government.dbo.District where headID="+id);
			if(rs.next())return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbh.closeResources();
		return false;
	}
}
