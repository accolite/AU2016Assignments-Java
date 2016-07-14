package com.accolite.jdbcAssignment.JdbcAssignmentPawan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;




public class queries {

	public static void List_all_the_states() {
		Connection conn = null;
		  Statement stmt = null;
		  try {
		   //register driver
		   Class.forName(Constants.JTDS_DRIVER);
		   conn = DriverManager.getConnection(Constants.DB1_URL, Constants.username, Constants.password);
		   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   //stmt = conn.createStatement();

		   String sql;
		   sql = "SELECT stateID, name FROM JdbcAssignmentDB1.dbo.state";
		   ResultSet rs = stmt.executeQuery(sql);
		   while (rs.next()) {
		    int stateid = rs.getInt("stateID");
		    String name = rs.getString("name");

		    // Display values
		    System.out.println(stateid+"\t"+name+"\t");
		   }
		   // STEP 6: Clean-up environment
		   rs.close();
		   stmt.close();
		   conn.close();
		  } catch (SQLException se) {
		   se.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   try {
		    if (stmt != null) {
		     stmt.close();
		    }
		    if (conn != null) {
		     conn.close();
		    }
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		
	}

	public static void List_all_the_districts() {
		// TODO Auto-generated method stub
		Connection conn = null;
		  Statement stmt = null;
		  try {
		   //register driver
		   Class.forName(Constants.JTDS_DRIVER);
		   conn = DriverManager.getConnection(Constants.DB1_URL, Constants.username, Constants.password);
		   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   //stmt = conn.createStatement();

		   String sql;
		   sql = "SELECT districtID, name FROM JdbcAssignmentDB1.dbo.district";
		   ResultSet rs = stmt.executeQuery(sql);
		   while (rs.next()) {
		    int stateid = rs.getInt("districtID");
		    String name = rs.getString("name");

		    // Display values
		    System.out.println(stateid+"\t"+name+"\t");
		   }
		   // STEP 6: Clean-up environment
		   rs.close();
		   stmt.close();
		   conn.close();
		  } catch (SQLException se) {
		   se.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   try {
		    if (stmt != null) {
		     stmt.close();
		    }
		    if (conn != null) {
		     conn.close();
		    }
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		
	}

	public static void Display_the_citizen_count_for_all_the_states() {
		Connection conn = null;
		  Statement stmt = null;
		  try {
		   //register driver
		   Class.forName(Constants.JTDS_DRIVER);
		   conn = DriverManager.getConnection(Constants.DB2_URL, Constants.username, Constants.password);
		   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   //stmt = conn.createStatement();

		   String sql;
		   sql = "select count(citizenID) as total , stateID from JdbcAssignmentDB2.dbo.citizen c,JdbcAssignmentDB1.dbo.district d where d.districtID = c.citizenID group by (stateID);";
		   ResultSet rs = stmt.executeQuery(sql);
		   System.out.println("State ID    Count");
		   while (rs.next()) {
		    int total = rs.getInt("total");
		    int stateID = rs.getInt("stateID");

		    // Display values
		    
		    System.out.println(stateID+"\t" + "\t" + total);
		   
		   }
		   // STEP 6: Clean-up environment
		   rs.close();
		   stmt.close();
		   conn.close();
		  } catch (SQLException se) {
		   se.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   try {
		    if (stmt != null) {
		     stmt.close();
		    }
		    if (conn != null) {
		     conn.close();
		    }
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		
		
	}

	public static void Remove_a_district() {
		
		PreparedStatement pstmt = null;
		 Connection conn = null;
		  Connection conn2 = null;
		   Statement stmt = null,stmt2=null;

		
		   try {
		    Scanner sc=new Scanner(System.in);
		    conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
		    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		       //stmt = conn.createStatement();
		    pstmt = conn.prepareStatement("DELETE FROM JdbcAssignmentDB1.dbo.District WHERE districtID=?");
		    System.out.println("enter district id to be deleted");
		    int d=sc.nextInt();
		    pstmt.setInt(1, d);
		      pstmt.executeUpdate();
		      pstmt = conn.prepareStatement("DELETE FROM JdbcAssignmentDB2.dbo.Citizen WHERE districtID=?");
		      pstmt.setInt(1, d);
		      pstmt.executeUpdate();
		       
		    
		   } catch (Exception e) {
		    e.printStackTrace();
		   } finally {
			   try {
				    if (pstmt != null)
				     pstmt.close();
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
		  
	}

	public static void Remove_a_state() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		 Connection conn = null;
		  Connection conn2 = null;
		   Statement stmt = null,stmt2=null;

		
		   try {
		    Scanner sc=new Scanner(System.in);
		    conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
		    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		       //stmt = conn.createStatement();
		    String sql1,sql2,sql3;
		    
		    int id=sc.nextInt();
		    sql1 = "DELETE FROM JdbcAssignmentDB1.dbo.state WHERE stateID="+id+";";
		    stmt.execute(sql1);
		    
		    /*sql3 = "select districtID from SUMEET_DATABASE1.dbo.district where  stateID="+id+";";
		    ResultSet rs = stmt.executeQuery(sql3);
		    
		    while (rs.next()) {
		     int id4 = rs.getInt("districtID");
		     
		     String sql5 = "DELETE FROM SUMEET_DATABASE2.dbo.citizens WHERE districtID="+id4+";";
		     stmt.execute(sql5);
		    }*/
		    
		    sql2 = "DELETE FROM JdbcAssignmentDB1.dbo.district WHERE stateID="+id+";";
		    stmt.execute(sql2);
		    
		   } catch (Exception e) {
		    e.printStackTrace();
		   } finally {
			   try {
				    if (pstmt != null)
				     pstmt.close();
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
		
	}

	public static void List_of_citizens_under_state() {
		Connection conn = null;
		  Statement stmt = null;
		  try {
		   //register driver
		   Class.forName(Constants.JTDS_DRIVER);
		   conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username, Constants.password);
		   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   //stmt = conn.createStatement();

		   String sql;
		   Scanner sc = new Scanner(System.in);
		   System.out.println("enter the State ID: ");
		   int val = sc.nextInt();
		   sql = " Select JdbcAssignmentDB2.dbo.Citizen.citizenID as citizenid,JdbcAssignmentDB2.dbo.Citizen.name as citizenname from JdbcAssignmentDB1.dbo.District inner join JdbcAssignmentDB1.dbo.State on JdbcAssignmentDB1.dbo.District.StateId=JdbcAssignmentDB1.dbo.State.stateId inner join JdbcAssignmentDB2.dbo.Citizen on JdbcAssignmentDB1.dbo.District.districtId=JdbcAssignmentDB2.dbo.Citizen.districtId where JdbcAssignmentDB1.dbo.District.stateID="+ val;
		   ResultSet rs = stmt.executeQuery(sql);
		   while (rs.next()) {
		    int citizenId = rs.getInt("citizenId");
		    String name = rs.getString("citizenname");

		    // Display values
		    System.out.println(citizenId+"\t"+name+"\t");
		   }
		   // STEP 6: Clean-up environment
		   rs.close();
		   stmt.close();
		   conn.close();
		  } catch (SQLException se) {
		   se.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   try {
		    if (stmt != null) {
		     stmt.close();
		    }
		    if (conn != null) {
		     conn.close();
		    }
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		
	}

	public static void List_of_citizens_under_district() {
		Connection conn = null;
		  Statement stmt = null;
		  try {
		   //register driver
		   Class.forName(Constants.JTDS_DRIVER);
		   conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username, Constants.password);
		   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   //stmt = conn.createStatement();

		   String sql;
		   Scanner sc = new Scanner(System.in);
		   System.out.println("enter the district ID: ");
		   int val = sc.nextInt();
		   sql = " Select JdbcAssignmentDB2.dbo.Citizen.citizenID as citizenid,JdbcAssignmentDB2.dbo.Citizen.name as citizenname from JdbcAssignmentDB2.dbo.Citizen where JdbcAssignmentDB2.dbo.Citizen.districtId="+ val;
		   ResultSet rs = stmt.executeQuery(sql);
		   while (rs.next()) {
		    int citizenId = rs.getInt("citizenId");
		    String name = rs.getString("citizenname");

		    // Display values
		    System.out.println(citizenId+"\t"+name+"\t");
		   }
		   // STEP 6: Clean-up environment
		   rs.close();
		   stmt.close();
		   conn.close();
		  } catch (SQLException se) {
		   se.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   try {
		    if (stmt != null) {
		     stmt.close();
		    }
		    if (conn != null) {
		     conn.close();
		    }
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		
		
	}

	public static void Show_head_of_a_district() {
		
		Connection conn = null;
		  Statement stmt = null;
		  try {
		   //register driver
		   Class.forName(Constants.JTDS_DRIVER);
		   conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username, Constants.password);
		   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   //stmt = conn.createStatement();

		   String sql;
		   Scanner sc = new Scanner(System.in);
		   System.out.println("enter the district ID: ");
		   int val = sc.nextInt();
		   sql = " Select JdbcAssignmentDB2.dbo.Citizen.citizenId as citizenid,JdbcAssignmentDB2.dbo.Citizen.name as citizenname from JdbcAssignmentDB1.dbo.District inner join JdbcAssignmentDB2.dbo.Citizen on JdbcAssignmentDB1.dbo.District.headCitizenID=JdbcAssignmentDB2.dbo.Citizen.citizenId where JdbcAssignmentDB1.dbo.District.districtId="+ val;
		   ResultSet rs = stmt.executeQuery(sql);
		   while (rs.next()) {
		    int citizenId = rs.getInt("citizenId");
		    String name = rs.getString("citizenname");

		    // Display values
		    System.out.println(citizenId+"\t"+name+"\t");
		   }
		   // STEP 6: Clean-up environment
		   rs.close();
		   stmt.close();
		   conn.close();
		  } catch (SQLException se) {
		   se.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   try {
		    if (stmt != null) {
		     stmt.close();
		    }
		    if (conn != null) {
		     conn.close();
		    }
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		
		  
	}

	public static void Change_Head_of_a_district() {
		Connection conn = null;
		  Statement stmt = null;
		  try {
		   //register driver
		   Class.forName(Constants.JTDS_DRIVER);
		   conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username, Constants.password);
		   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   //stmt = conn.createStatement();

		   String sql, sql2;
		   Scanner sc = new Scanner(System.in);
		   System.out.println("enter the district ID: ");
		   int val = sc.nextInt();
		   
		  
		   System.out.println("enter the citizen id of new head: ");
		   int val2 = sc.nextInt();
		   int age = 0;
		   sql2 = " Select age from JdbcAssignmentDB2.dbo.Citizen where JdbcAssignmentDB2.dbo.Citizen.citizenID="+ val2;
		   ResultSet rs = stmt.executeQuery(sql2);
		   while (rs.next()) {
		     age = rs.getInt("age");
		   }
		   
		   if (age <= 60) {
			   
			   sql = " update JdbcAssignmentDB1.dbo.district set headCitizenID = "+val2+" where districtID="+ val;
			   stmt.execute(sql);
			   
			   String sql3;
			   sql3 = "update JdbcAssignmentDB2.dbo.citizen set type = 'VIP' where citizenID="+ val2;
			   stmt.execute(sql3);
			   System.out.println("updated successfully");
			   // STEP 6: Clean-up environment
			   rs.close();
			   stmt.close();
			   conn.close();
			  } 			   
		   else {
			   System.out.println("sorry! His age is greater than 60 ");
		   }
			   
		   
		  }
		   catch (Exception e) {
		    e.printStackTrace();
		   }
		  
		
		
	}

	public static void List_technical_details() {
		// TODO Auto-generated method stub
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME, Constants.username, Constants.password);
			dbmd = conn.getMetaData();
			
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

		} catch (Exception e) {

		}
	}

	public static void Create_or_restore_data_and_tables() {
		// TODO Auto-generated method stub
		
	}

}
