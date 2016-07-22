import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.au.workshop.util.Constants;

public class Assignment {

static ResultSet rs, rs2;
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		int id, age, choice = 1;
		String first, last;
		Assignment d1 = new Assignment();
		
		//System.out.println("\n 1. List of states\n 2. List of Districts\n 3. Display citizen count of all states\n 4. Remove a districts\n 5. Remove a state\n 6. List of citizens under state\n 7. List of citizens under district\n 8. Head of the district\n 9. Change head of the district\n 10. Technical details:");
		System.out.print("Enter your choice :");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n 1. List of states\n 2. List of Districts\n 3. Display citizen count of all states\n 4. Remove a districts\n 5. Remove a state\n 6. List of citizens under state\n 7. List of citizens under district\n 8. Head of the district\n 9. Change head of the district\n 10. Technical details:");
			choice = sc.nextInt();
		switch(choice) {
		//show list of states
		
		case 1:
			System.out.println("\n\nList of States :");
			try {
			//register driver
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				conn = DriverManager.getConnection(Constants.DB_URL1,Constants.username, Constants.password);
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
				String sql;
				sql = "SELECT Name FROM StateData";
				rs = stmt.executeQuery(sql);
				rs.beforeFirst();
				String name;
				
				while (rs.next()) {
					// Retrieve by column name
					name = rs.getString("Name");
	
					// Display values
					System.out.println(name);
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
			break;
		
			
		case 2:	
			//List of all districts
			System.out.println("\n\nList of Districts :");
			try {
			//register driver
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				conn = DriverManager.getConnection(Constants.DB_URL1,Constants.username, Constants.password);
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				String sql;
				sql = "SELECT Name FROM District";
				rs = stmt.executeQuery(sql);
				rs.beforeFirst();
				String name;
				
				while (rs.next()) {
					// Retrieve by column name
					name = rs.getString("Name");
	
					// Display values
					System.out.println(name);
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
			break;
		
		
		case 3:	
			//display citizen count of each state
			try {
			//register driver
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username, Constants.password);
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				String sql;
				int ids[] = new int[5], i = 0, count;
				//sql = "select t1.CitizenID, t1.FName, t2.Name from [citizens].[dbo].[Citizen] as t1 inner join [psd].[dbo].[StateData] as t2 on t1.StateID = t2.StateID";
				sql = "select StateID from [psd].[dbo].[StateData]";
				rs = stmt.executeQuery(sql);
				rs.beforeFirst();
				String name;
				while (rs.next()) {
					// Retrieve by column name
					 ids[i] = rs.getInt("StateID");
					 i++;
				}
				for(i = 0; i < 5; i++) {
					sql = "select * from [citizens].[dbo].[Citizen] as t1 where t1.StateID = " + ids[i] + ";";
					rs = stmt.executeQuery(sql);
					count = rs.getRow();
					System.out.println("State " + ids[i] + " has " + count + " people.");
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
			break;
			
			
		case 4:
		//remove district
			try {
				//register driver
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				
				
				//stmt = conn.createStatement();
	
				//Display the list of states
				conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username, Constants.password);
				
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				id = 0;
				Scanner s = new Scanner(System.in);
				String sql, state;
				System.out.println("Enter district name : ");
				state = s.next();
				//sql = "select t1.CitizenID, t1.FName, t2.Name from [citizens].[dbo].[Citizen] as t1 inner join [psd].[dbo].[StateData] as t2 on t1.StateID = t2.StateID";
				sql = "select t1.DistrictID from [psd].[dbo].[District] as t1 where t1.Name = '" + state + "';";
				rs = stmt.executeQuery(sql);
				rs.beforeFirst();
				
				while(rs.next()) {
					id = rs.getInt("DistrictID");
				}
				
				sql = "Update [psd].[dbo].[District] as t1 SET t1.Flag = 0 WHERE t1.DistrictID = " + id + ";";
				rs = stmt.executeQuery(sql);
				rs.beforeFirst();
				
				sql = "Update [citizens].[dbo].[Citizen] as t1 set t1.Flag = 0 where t1.DistrictID = " + id + ";";
				rs = stmt.executeQuery(sql);
	
				System.out.println("District is removed");
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
			break;
			
		
			
		case 5:
			//remove state
				try {
					//register driver
					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username, Constants.password);
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					Scanner s = new Scanner(System.in);
					String sql, state;
					int ids;
					id = 0;
					System.out.println("Enter state name : ");
					state = s.next();
					//sql = "select t1.CitizenID, t1.FName, t2.Name from [citizens].[dbo].[Citizen] as t1 inner join [psd].[dbo].[StateData] as t2 on t1.StateID = t2.StateID";
					sql = "select t1.DistrictID from [psd].[dbo].[StateData] as t1 where t1.Name = '" + state + "';";
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					
					while(rs.next()) {
						id = rs.getInt("StateID");
					}
					
					sql = "Update [psd].[dbo].[District] as t1 SET t1.Flag = 0 WHERE t1.StateID = " + id + ";";
					rs = stmt.executeQuery(sql);
					sql = "select t1.DistrictID FROM [psd].[dbo].[District] as t1 WHERE t1.StateID = " + id + ";";
					rs = stmt.executeQuery(sql);
					sql = "Update [citizens].[dbo].[Citizen] as t1 set t1.Flag = 0 where t1.StateID = " + id + ";";
					rs = stmt.executeQuery(sql);
					
					System.out.println("State is removed");
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
				break;	
		
		case 6:
		//people under state
				try {
					//register driver
					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					
					//stmt = conn.createStatement();

					//Display the list of states
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username, Constants.password);
					
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					
					
					Scanner s = new Scanner(System.in);
					String sql, state;
					System.out.println("Enter state name : ");
					state = s.next();
					//sql = "select t1.CitizenID, t1.FName, t2.Name from [citizens].[dbo].[Citizen] as t1 inner join [psd].[dbo].[StateData] as t2 on t1.StateID = t2.StateID";
					sql = "select t1.StateID from [psd].[dbo].[StateData] as t1 where t1.Name = '" + state + "';";
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					id = 0;
					while(rs.next())
						id = rs.getInt("StateID");
					sql = "select t1.FName, t1.LName from [citizens].[dbo].[Citizen] as t1 where t1.StateID = " + id;
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					while (rs.next()) {
						// Retrieve by column name
						 System.out.println(rs.getString("FName") + " " + rs.getString("LName"));
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
				break;
				
		case 7:		
				//people under district
				try {
					//register driver
					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username, Constants.password);
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					
					id = 0;
					Scanner s = new Scanner(System.in);
					String sql, state;
					System.out.println("Enter district name : ");
					state = s.next();
					//sql = "select t1.CitizenID, t1.FName, t2.Name from [citizens].[dbo].[Citizen] as t1 inner join [psd].[dbo].[StateData] as t2 on t1.StateID = t2.StateID";
					sql = "select t1.DistrictID from [psd].[dbo].[District] as t1 where t1.Name = '" + state + "';";
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					
					while(rs.next()) {
						id = rs.getInt("DistrictID");
					}
					sql = "select t1.FName, t1.LName from [citizens].[dbo].[Citizen] as t1 where t1.DistrictID = " + id + ";";
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					while (rs.next()) {
						// Retrieve by column name
						 System.out.println(rs.getString("FName") + " " + rs.getString("LName"));
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
				break;
				
				
		case 8:		
				//show head of district
				try {
					//register driver
					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					
					//stmt = conn.createStatement();

					//Display the list of states
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username, Constants.password);
					
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					
					id = 0;
					Scanner s = new Scanner(System.in);
					String sql, state;
					System.out.println("Enter district name : ");
					state = s.next();
					//sql = "select t1.CitizenID, t1.FName, t2.Name from [citizens].[dbo].[Citizen] as t1 inner join [psd].[dbo].[StateData] as t2 on t1.StateID = t2.StateID";
					sql = "select t1.HeadID from [psd].[dbo].[District] as t1 where t1.Name = '" + state + "';";
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					
					while(rs.next()) {
						id = rs.getInt("HeadID");
					}
					sql = "select t1.FName, t1.LName from [citizens].[dbo].[Citizen] as t1 where t1.CitizenID = " + id + ";";
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					while (rs.next()) {
						// Retrieve by column name
						 System.out.println(rs.getString("FName") + " " + rs.getString("LName"));
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
				break;
				
		case 9:
				//change head of district
				try {
					//register driver
					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					
					//stmt = conn.createStatement();

					//Display the list of states
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username, Constants.password);
					
					stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					
					id = 0;
					int id2 = 0;
					Scanner s = new Scanner(System.in);
					String sql, state;
					System.out.println("Enter district name : ");
					state = s.next();
					//sql = "select t1.CitizenID, t1.FName, t2.Name from [citizens].[dbo].[Citizen] as t1 inner join [psd].[dbo].[StateData] as t2 on t1.StateID = t2.StateID";
					sql = "select t1.HeadID, t1.DistrictID from [psd].[dbo].[District] as t1 where t1.Name = '" + state + "';";
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					
					while(rs.next()) {
						id = rs.getInt("HeadID");
						id2 = rs.getInt("DistrictID");
					}
					sql = "select t1.FName, t1.LName, t1.CitizenID from [citizens].[dbo].[Citizen] as t1 where t1.CitizenID <> " + id + " AND t1.DistrictID = " + id2 + " AND t1.Age <= 60;";
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					while (rs.next()) {
						// Retrieve by column name
						 System.out.println(rs.getString("FName") + " " + rs.getString("LName"));
						 id = rs.getInt("CitizenID");
						 break;
					}
					sql = "Update [psd].[dbo].[District]  SET HeadID = " + id + " WHERE DistrictID = " + id2 + " ;";
					// STEP 6: Clean-up environment
					rs = stmt.executeQuery(sql);
					rs.beforeFirst();
					
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
				break;
				
				
		case 10:		
				//get technical details
				
				try {
					DatabaseMetaData dbmd = null;
					ResultSetMetaData rsmd = null;
					ResultSet rs;
					
					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.username,Constants.password);
					dbmd = conn.getMetaData();
					
					System.out.println("Driver Name: "+ dbmd.getDriverName());  
					System.out.println("Driver Version: "+ dbmd.getDriverVersion());  
					System.out.println("UserName: "+ dbmd.getUserName()); 
				} catch (Exception e) {

				}
				break;
				
		
		case 11:
				System.out.println("Incorrect choice");
				break;
		}
		if(choice == 11)
			break;
				
	}
	}

}
