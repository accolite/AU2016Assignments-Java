package JdbcConn;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JdbcConn.Creation;
import JdbcConn.Insert;
import JdbcUtil.Constants;

public class Main {
	static Connection conn = null;
	DatabaseMetaData dbmd = null;

	Main() {
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void closeResources() {

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	private void q1() {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String s = "Use Territory  select s.StateName from State as s;";
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				// Retrieve by column name
				String sn = rs.getString("StateName");
				System.out.println(sn);
			}
			// STEP 6: Clean-up environment
			rs.close();
			closeResources();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void q2() {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String s = "Use Territory  select d.DistrictName from District as d;";
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				// Retrieve by column name
				String sn = rs.getString("DistrictName");
				System.out.println(sn);
			}
			// STEP 6: Clean-up environment
			rs.close();
			closeResources();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void q3() {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String s = "Use Citizen  select d.StateID,d.StateName,sum(cc.population)"
				+ " from (select c.DistrictId,count(*) as population"
				+ " from Citizen as c group by( c.DistrictId)) cc "
				+ "inner join Territory.dbo.District as d "
				+ "on cc.DistrictId=d.DistrictId "
				+ "group by d.StateId;";
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				// Retrieve by column name
				String sn = rs.getString("StateName");
				int id = rs.getInt("StateId");
				int sum=rs.getInt("population");

				System.out.println(sn);
			}
			// STEP 6: Clean-up environment
			rs.close();
			closeResources();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void q7() {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String s = "Use Citizen select count(*) as population_district, DistrictId as Id  from Citizen group by DistrictId";
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				// Retrieve by column name
				int sn = rs.getInt("population_district");int sn1 = rs.getInt("Id");
				System.out.println(sn+ " "+sn1);
				
			}
			// STEP 6: Clean-up environment
			rs.close();
			closeResources();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void q8() {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String s = "Use Citizen select CitizenId,Name  from Citizen where head=2 ";
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				// Retrieve by column name
				
				int sn1 = rs.getInt("CitizenId");				String sn = rs.getString("Name");

				System.out.println(sn1+" "+sn);
			
			}
			// STEP 6: Clean-up environment
			rs.close();
			closeResources();
		} catch (Exception e) {
			e.printStackTrace();
		}}
		private void q9() {
			try {
				conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
				dbmd = conn.getMetaData();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				System.out.println("Driver Name: "+dbmd.getDriverName());  
				System.out.println("Driver Version: "+dbmd.getDriverVersion());  
				System.out.println("UserName: "+dbmd.getUserName());  
				System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
				System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
				// STEP 6: Clean-up environment
				
				closeResources();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		private void q10() {
			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ResultSetMetaData rsmd = null;
				try{
				
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "DataBaseName=Citizen","sa","accolite");
					pstmt = conn.prepareStatement("SELECT * FROM Citizen");
					rs = pstmt.executeQuery();
					
					rsmd=rs.getMetaData();
					
					System.out.println("Total columns: "+rsmd.getColumnCount());  
					System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
					System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
					
				}catch(Exception e){
					
				}
				
				closeResources();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void main(String args[]) {
		Creation create = new Creation();
		Main m1 = new Main();

		
		  //int a=create.CreateDb("Territory"); //int
		//  b=create.CreateDb("Citizen"); //create.table();
		//  create.createTrigger(); 
		  Insert i=new Insert(); // i.State("Andra",
		  //conn);
		 // i.District("nellore", 1, 1, conn);
		//  i.District("vellore", 2, 2, conn);
		 // i.Citizen("sarala",1,2,3,18,1,conn);
		// i.Citizen("abi",2,1,3,18,1,conn);
		// i.Citizen("kumar",0,2,3,18,2,conn);
		 i.Citizen("padmaja",0,2,3,1,2,conn);
		 
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int key = 0, value = 0;
		System.out.println("enter choice 1 to 9 10 to quit");
		choice = sc.nextInt();
		m1.closeResources();

		while (choice != 10) 
		{
			switch (choice) {
			case 1:
				System.out.println("states");
				m1.q1();
				break;
			case 2:
				System.out.println("district");
				m1.q2();
				break;
			case 3:
				System.out.println("sum all state");
				m1.q3();
				break;
			case 7:
				System.out.println("sum district");
				m1.q7();
			case 8:
				System.out.println("8. Show head of a district");
				m1.q8();
			case 9:
				System.out.println("8. metadata of db and citizen table");
				m1.q9();
			default:
				break;

			}
			choice =sc.nextInt();
		}
	}
}
