package com.accolite.JDBCassignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.accolite.util.Constants;

public class Queries {
	
	public Queries(){
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void Query1() {
		Statement stmt=null;
		Connection con=Queries.GetConnection(Constants.DB_URL1);
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ="SELECT db1.STATES.StateName FROM db1.STATES";
			stmt.executeUpdate(sqlQ);
			ResultSet rs=stmt.executeQuery(sqlQ);
			while(rs.next()){
				String StateName = rs.getString("StateName");
				System.out.println(StateName);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt != null) {
				try {
					stmt.close();
					Queries.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void Query2() {
		Statement stmt=null;
		Connection con=Queries.GetConnection(Constants.DB_URL1);
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ="SELECT db1.Districts.Name FROM db1.DISTRICTS";
			stmt.executeUpdate(sqlQ);
			ResultSet rs=stmt.executeQuery(sqlQ);
			while(rs.next()){
				String Name = rs.getString(1);
				System.out.println(Name);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt != null) {
				try {
					stmt.close();
					Queries.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query3() {
		Statement stmt1=null;
		Connection con1=Queries.GetConnection(Constants.DB_URL);
		
		try {
			stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT COUNT(*) AS CitizenCount,S1.StateName FROM db2.CITIZENS AS C1"+
				      "JOIN db1.DISTRICTS AS D1 ON C1.DistrictID=d1.DistictId"+
				      "JOIN db1.STATES AS S1 ON S1.StateID=D1.StateID"+
				      "GROUP BY S1.StateID ";
				   ResultSet rs=stmt1.executeQuery(sql);
				   System.out.println("CitizenCount    StateName");
				   while(rs.next()){
				    int Count = rs.getInt(1);
				    String StateName=rs.getString(2);
				    System.out.println(Count+" "+StateName);
				   }
				   rs.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt1 != null) {
				try {
					stmt1.close();
					Queries.CloseConnection(con1);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query4(String district) {
		Statement stmt1=null;
		Connection con1=Queries.GetConnection(Constants.DB_URL);
		
		try {
			stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			Scanner in = new Scanner(System.in);
			
			String sql = "SELECT DistrictID from db1.Districts where DistrictName=\"" +  district + ";\"";
			ResultSet rs = stmt1.executeQuery(sql);
		    int distid  = 0;
		    distid = rs.getInt(1);
		    sql  = "Delete from db1.DISTRICTS where db1.DISTRICTS.DistrictID =\"" + distid + ";\"";
		    stmt1.executeUpdate(sql);
		    sql  = "Delete from db2.CITIZENS where db1.DISTRICTS.DistrictID =\"" + distid + ";\"";
		    stmt1.executeUpdate(sql);
			
		   
		    rs.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt1 != null) {
				try {
					stmt1.close();
					Queries.CloseConnection(con1);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void Query5(String state) {
		  Statement stmt = null;
		  Connection con = Queries.GetConnection(Constants.DB_URL1);
		  try {
		   int stid=0;
		   stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   String sqlQ;
		   sqlQ="SELECT StateID FROM STATES WHERE NAME=\" " + state + " \" ";
		   ResultSet rs=stmt.executeQuery(sqlQ);
		   while(rs.next()){
		    stid=rs.getInt(1);
		   }
		   String ns=Integer.toString(stid);
		   sqlQ="SELECT Name FROM DISTRICTS WHERE StateID=\" " + ns + " \" ";
		   ResultSet rs1=stmt.executeQuery(sqlQ);
		   Queries f=new Queries();
		   while(rs1.next()){
		    String districtname=rs1.getString(1);
		    f.Query4(districtname);
		   }
		   sqlQ= "DELETE FROM STATES WHERE StateName=\" " + state + " \" ";
		   stmt.executeQuery(sqlQ);
		   System.out.println("Deleted");
		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   if (stmt != null) {
		    try {
		     stmt.close();
		     Queries.CloseConnection(con);
		    } catch (SQLException e) {
		     e.printStackTrace();
		    }
		   }
		  }
		 }
	public void Query6(String state) {
		  Statement stmt = null;
		  Connection con = Queries.GetConnection(Constants.DB_URL);
		  try {
		   stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   String sqlQ = "SELECT C1.Name, S1.StateName FROM DATABASE_1.CITIZEN AS C1"
		     + "JOIN DATABASE_1.DISTRICTS AS D1 ON C1.DistrictID=D1.DistrictID"
		     + "JOIN DATABASE_1.STATES AS S1 ON S1.StateID=D1.StateID" + "WHERE S1.NAME=\"" + state + "\"";
		   ResultSet rs = stmt.executeQuery(sqlQ);
		   System.out.println("CitizenName    StateName");
		   while (rs.next()) {
		    String Count = rs.getString(1);
		    String StateName = rs.getString(2);
		    System.out.println(Count + " " + StateName);
		   }
		   rs.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   if (stmt != null) {
		    try {
		     stmt.close();
		     Queries.CloseConnection(con);
		    } catch (SQLException e) {
		     e.printStackTrace();
		    }
		   }
		  }
		 }
	public void Query7() {
		Statement stmt1=null;
		Connection con1=Queries.GetConnection(Constants.DB_URL);
		
		try {
			stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter district name");
			String district = input.nextLine();
			String sql = "SELECT  db2.CITIZENS.CitizenName from db1.Districts "
					+ "join db2.CITIZENS on "
					+ "db1.DISTRICTS.DistrictID = db2.CITIZENS.DistrictID  where  db1.DISTRICTS.DistrictName=\""+
					district+ "\"";
			
			ResultSet rs = stmt1.executeQuery(sql);
		    while(rs.next())
		    	System.out.println(rs.getString(1) );
		    rs.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt1 != null) {
				try {
					stmt1.close();
					Queries.CloseConnection(con1);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void Query8(String S) {
		  Statement stmt = null;
		  Connection con = Queries.GetConnection(Constants.DB_URL);
		  try {
		   int headId=0;
		   stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   String sqlQ = "SELECT HeadCitizenID FROM db1.DISTRICTS WHERE db1.DISTRICTS.Name=\""
		     + S + "\"";
		   ResultSet rs = stmt.executeQuery(sqlQ);
		   while(rs.next()){
		    headId=rs.getInt(1);
		   }
		   sqlQ="SELECT Name FROM db2.DISTRICTS WHERE CitizenID=\""+ headId + "\"";
		   ResultSet rs1=stmt.executeQuery(sqlQ);
		   System.out.println("Head Name");
		   while (rs.next()) {
		    String Name = rs.getString(1);
		    System.out.println(Name);
		   }
		   rs.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  } finally {
		   if (stmt != null) {
		    try {
		     stmt.close();
		     Queries.CloseConnection(con);
		    } catch (SQLException e) {
		     e.printStackTrace();
		    }
		   }
		  }
		 }

	public void Query9(String distname, int change_dist_id) {
		Statement stmt1=null;
		Connection con1=Queries.GetConnection(Constants.DB_URL1);
		
		try {
			stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sql = "SELECT  db1.DISTRICTS.StateID from db1.DISTRICTS "
					+ "where  db1.DISTRICTS.DistrictName=\""+
					distname+ "\"";
			
			ResultSet rs = stmt1.executeQuery(sql);
		    int districtid = (rs.getInt(1) );
		    sql = "UPDATE db1.DISTRICTS " +
	                   "SET db1.DISTRICTS.DistrictID =" + change_dist_id +  "WHERE db1.DISTRICTS.DistrictsID="+ districtid+"\"";
		    stmt1.executeUpdate(sql);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt1 != null) {
				try {
					stmt1.close();
					Queries.CloseConnection(con1);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void Query10() {
		
	}

	public void Query11() {
		Statement stmt1=null;
		Connection con1=Queries.GetConnection(Constants.DB_URL);
		try {
			stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			
			String sql = "DROP TABLE db1.PRESIDENTS";
		    stmt1.executeUpdate(sql);
			sql = "DROP TABLE db1.STATES";
			stmt1.executeUpdate(sql);
			sql = "DROP TABLE db1.DISTRICTS";
			stmt1.executeUpdate(sql);
			sql = "DROP TABLE db2.CITIZENS";
			stmt1.executeUpdate(sql);
		    
		    CreateTables ct = new CreateTables();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt1 != null) {
				try {
					stmt1.close();
					Queries.CloseConnection(con1);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

		
	

	public static Connection GetConnection(String D) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(D, Constants.username, Constants.password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void CloseConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Scanner S = new Scanner(System.in);
		boolean flag = true;
		Queries Q = new Queries();
		while (flag) {
			System.out.println("Enter your choice\n");
			System.out.println("1.List all the states\n2.List all the districts");
			System.out.println("3.Display the citizen count for all the states\n4.Remove a district");
			System.out.println("5.Remove a state\n6.List of citizens under state");
			System.out.println("7.List of citizens under district\n8.Show head of a district");
			System.out.println("9.Change Head of a district\n10.List technical details");
			System.out.println("11.Create or restore data and tables\n12.Exit");
			int choice = S.nextInt();
			
			switch (choice) {
			case 1:
				Q.Query1();
				break;
			case 2:
				Q.Query2();
				break;
			case 3:
				Q.Query3();
				break;
			case 4:
				String districtname;
				Scanner inp = new Scanner(System.in);
				System.out.println("Enter District name");
			    districtname = inp.next(); 
				Q.Query4(districtname);
				break;
			case 5:
				String statename;
				Scanner inp1 = new Scanner(System.in);
				System.out.println("Enter State name");
			    statename = inp1.next(); 
				Q.Query5(statename);
				break;
			case 6:
				Scanner inp2 = new Scanner(System.in);
				statename = inp2.next(); 
				Q.Query6(statename);
				break;
			case 7:
				Q.Query7();
				break;
			case 8:
				String district;
				Scanner inp3 = new Scanner(System.in);
				System.out.println("Enter district name");
			    district = inp3.next(); 
				Q.Query8(district);
				break;
			case 9:
				System.out.println("Enter distname and distid to replace");
				Scanner inp4 = new Scanner(System.in);
				String distname = inp4.next() ;
				int change_dist_id = inp4.nextInt();
				Q.Query9(distname, change_dist_id);
				break;
			case 10:
				break;
			case 11:
				Q.Query11();
				break;
			case 12:
				flag = false;
				break;
			}
		}
	}
}