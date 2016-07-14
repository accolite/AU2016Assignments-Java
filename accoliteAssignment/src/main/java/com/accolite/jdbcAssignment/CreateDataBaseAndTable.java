package com.accolite.jdbcAssignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;










public class CreateDataBaseAndTable {
	public void createDB() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL_WITHOUT_DB_NAME);
			stmt = conn.createStatement();
			
			String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'SUMEET_DATABASE1') CREATE DATABASE SUMEET_DATABASE1";
			stmt.executeUpdate(createDbIfNotExists);
			
			createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'SUMEET_DATABASE2') CREATE DATABASE SUMEET_DATABASE2";
			stmt.executeUpdate(createDbIfNotExists);
			
			//System.out.println("Dropping table if exits");
			String dropTable ="USE  SUMEET_DATABASE2 "+ "IF OBJECT_ID('dbo.citizens', 'x') IS NOT NULL DROP TABLE dbo.citizens; " ;
			stmt.executeUpdate(dropTable);

			//System.out.println("Creating table if not exists");
			String createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.citizens' AND type = 'x') "
					+ "BEGIN "
					+ "CREATE TABLE citizens(citizenID int not null primary key,districtID int not null,name varchar (255),age int not null,type int not null) "
					+ "END";

			stmt.executeUpdate(createTable);
			
			dropTable ="USE  SUMEET_DATABASE1 "+ "IF OBJECT_ID('dbo.district', 'U') IS NOT NULL DROP TABLE dbo.district; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.district' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE district(districtID int not null  primary key,headcitizenID int not null,name varchar (255),stateID int not null) "
					+ "END";

			stmt.executeUpdate(createTable);
			
			dropTable ="USE  SUMEET_DATABASE1 "+ "IF OBJECT_ID('dbo.state', 'U') IS NOT NULL DROP TABLE dbo.state; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.state' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE state(stateID int not null  primary key,name varchar (255),presidentID int not null) "
					+ "END";

			stmt.executeUpdate(createTable);
			
			
			dropTable ="USE  SUMEET_DATABASE1 "+ "IF OBJECT_ID('dbo.president', 'U') IS NOT NULL DROP TABLE dbo.president; " ;
			stmt.executeUpdate(dropTable);

			System.out.println("Creating table if not exists");
			createTable = "IF  NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'dbo.president' AND type = 'U') "
					+ "BEGIN "
					+ "CREATE TABLE president(presidentID int not null  primary key,name varchar (255)) "
					+ "END";

			stmt.executeUpdate(createTable);
			conn.close();
			
			


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

	public void insertDefaultData() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			// insert in citizen table
			pstmt = conn.prepareStatement("INSERT INTO SUMEET_DATABASE2.dbo.citizens values(?,?,?,?,?)");
				pstmt.setInt(1, 1);
				pstmt.setInt(2, 1);
				pstmt.setString(3, "sumeet");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 1);
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setInt(2, 1);
				pstmt.setString(3, "pawan");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 1);
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setInt(2, 1);
				pstmt.setString(3, "Akash");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 0);
				pstmt.addBatch();
				
				pstmt.setInt(1, 4);
				pstmt.setInt(2, 2);
				pstmt.setString(3, "surya");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 0);
				pstmt.addBatch();
				
				pstmt.setInt(1, 5);
				pstmt.setInt(2, 2);
				pstmt.setString(3, "saumyadeep");
				pstmt.setInt(4, 22);
				pstmt.setInt(5, 0);
				pstmt.addBatch();
				pstmt.executeBatch();
				
			// insert in district table
			pstmt = conn.prepareStatement("INSERT INTO SUMEET_DATABASE1.dbo.district values(?,?,?,?)");
				pstmt.setInt(1, 1);
				pstmt.setInt(2, 1);
				pstmt.setString(3, "xx");
				pstmt.setInt(4, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setInt(2, 2);
				pstmt.setString(3, "yy");
				pstmt.setInt(4, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setInt(2, 3);
				pstmt.setString(3, "vv");
				pstmt.setInt(4, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 4);
				pstmt.setInt(2, 4);
				pstmt.setString(3, "zz");
				pstmt.setInt(4, 2);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 5);
				pstmt.setInt(2, 5);
				pstmt.setString(3, "rr");
				pstmt.setInt(4, 2);
			
				pstmt.addBatch();
				pstmt.executeBatch();
			// insert into president table
			pstmt = conn.prepareStatement("INSERT INTO SUMEET_DATABASE1.dbo.president values(?,?)");
			
				pstmt.setInt(1, 1);
				pstmt.setString(2, "Sumeet");
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setString(2, "Pawan");
				
				pstmt.addBatch();
				pstmt.executeBatch();
				
			// insert into state table
			pstmt = conn.prepareStatement("INSERT INTO SUMEET_DATABASE1.dbo.state values(?,?,?)");
			
				pstmt.setInt(1, 1);
				pstmt.setString(2, "Bihar");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 2);
				pstmt.setString(2, "Jharkand");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setString(2, "UP");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 4);
				pstmt.setString(2, "Karnatka");
				pstmt.setInt(3, 1);
				
				pstmt.addBatch();
				
				pstmt.setInt(1, 5);
				pstmt.setString(2, "Telangana");
				pstmt.setInt(3, 1);
			
				pstmt.addBatch();
				pstmt.executeBatch();
	
		
			System.out.println("Record Successfully saved");
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void List_all_the_states() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			String sql;
			sql = "SELECT stateID, name FROM SUMEET_DATABASE1.dbo.state";
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

		
	

	public void List_all_the_districts() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			String sql;
			sql = "SELECT districtID, name FROM SUMEET_DATABASE1.dbo.district";
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

	public void Display_the_citizen_count_for_all_the_states() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			String sql;
			sql = "select count(citizenID) as total , stateID from SUMEET_DATABASE2.dbo.citizens c,SUMEET_DATABASE1.dbo.district d where d.districtID = c.citizenID group by (stateID);";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int total = rs.getInt("total");
				int stateID = rs.getInt("stateID");

				// Display values
				System.out.println(total+"\t"+stateID+"\t");
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

	public void Remove_a_district(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			String sql1,sql2;
			
			sql1 = "DELETE FROM SUMEET_DATABASE1.dbo.district WHERE districtID="+id+";";
			sql2 = "DELETE FROM SUMEET_DATABASE2.dbo.citizens WHERE districtID="+id+";";
			stmt.execute(sql1);
			stmt.execute(sql2);
			
			
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

	public void Remove_a_state(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			String sql1,sql2,sql3;
			
			sql1 = "DELETE FROM SUMEET_DATABASE1.dbo.state WHERE stateID="+id+";";
			stmt.execute(sql1);
			
			/*sql3 = "select districtID from SUMEET_DATABASE1.dbo.district where  stateID="+id+";";
			ResultSet rs = stmt.executeQuery(sql3);
			
			while (rs.next()) {
				int id4 = rs.getInt("districtID");
				
				String sql5 = "DELETE FROM SUMEET_DATABASE2.dbo.citizens WHERE districtID="+id4+";";
				stmt.execute(sql5);
			}*/
			
			sql2 = "DELETE FROM SUMEET_DATABASE1.dbo.district WHERE stateID="+id+";";
			stmt.execute(sql2);
			
			/*rs.close();*/
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

	public void List_of_citizens_under_state() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			 String sql;
		     Scanner sc = new Scanner(System.in);
		     System.out.println("enter the State ID: ");
		     int val = sc.nextInt();
		     sql = " Select SUMEET_DATABASE2.dbo.citizens.citizenID as"
		    		 +"citizenid,SUMEET_DATABASE2.dbo.citizens.name as citizenname"
		    		 +"from SUMEET_DATABASE1.dbo.district inner join "
		    		 +"SUMEET_DATABASE1.dbo.state on SUMEET_DATABASE1.dbo.district.stateId=SUMEET_DATABASE1.dbo.state.stateId inner join SUMEET_DATABASE2.dbo.citizens on SUMEET_DATABASE1.dbo.district.districtId=SUMEET_DATABASE2.dbo.citizens.districtId where SUMEET_DATABASE1.dbo.district.stateID="+ val;
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

	public void List_of_citizens_under_district() {
		// TODO Auto-generated method stub
				Connection conn = null;
				Statement stmt = null;
				try {
					//register driver
					Class.forName(Constant.JTDS_DRIVER);
					conn = DriverManager.getConnection(Constant.DB_URL);
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					//stmt = conn.createStatement();

					 String sql;
				     Scanner sc = new Scanner(System.in);
				     System.out.println("enter the District ID: ");
				     int val = sc.nextInt();
				     sql = "select citizenID,name  FROM SUMEET_DATABASE2.dbo.citizens WHERE districtID="+val+";";
				     ResultSet rs = stmt.executeQuery(sql);
				     while (rs.next()) {
				      int citizenId = rs.getInt("citizenID");
				      String name = rs.getString("name");

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

	public void Show_head_of_a_district(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			String sql;
			sql = "SELECT name FROM SUMEET_DATABASE2.dbo.citizen where citizenID = "+id+")";
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

	public void Change_Head_of_a_district() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			//register driver
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
		String sql, sql2;
	     Scanner sc = new Scanner(System.in);
	     System.out.println("enter the district ID: ");
	     int val = sc.nextInt();
	     
	    
	     System.out.println("enter the citizen id of new head: ");
	     int val2 = sc.nextInt();
	     int age = 0;
	     sql2 = " Select age from SUMEET_DATABASE2.dbo.citizen where SUMEET_DATABASE2.dbo.citizen.citizenID="+ val2;
	     ResultSet rs = stmt.executeQuery(sql2);
	     while (rs.next()) {
	       age = rs.getInt("age");
	     }
	     
	      if (age <= 60) {
	      
	      sql = " update SUMEET_DATABASE1.dbo.district set headcitizenID = "+val2+" where districtID="+ val;
	      stmt.execute(sql);
	      
	      String sql3;
	      sql3 = "update SUMEET_DATABASE2.dbo.citizen set type = 1 where citizenID="+ val2;
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

	public void List_technical_details() {
		// TODO Auto-generated method stub
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		try {
			Class.forName(Constant.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constant.DB_URL);
			dbmd = conn.getMetaData();
			
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  

		} catch (Exception e) {

		}
		
	}

	public void Create_or_restore_data_and_tables() {
		// TODO Auto-generated method stub
		
	}

}
