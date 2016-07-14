package com.au.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.au.util.Constants;

public class Query {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public Query(){
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	 public void setup(){
		 Connection conn = null;
		 Statement stmt = null;
			try {
				//register driver
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				
				conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
				
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
                String sql;
				sql = "CREATE DATABASE IF NOT EXISTS Datab1 ";
				stmt.execute(sql);
				
				sql = "CREATE DATABASE IF NOT EXISTS Datab2 ";

				stmt.execute(sql);
		
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
	
	public void Query1() {
		Statement stmt=null;
		Connection con=Query.GetConnection(Constants.DB_URLD1);
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ="SELECT StateName FROM STATES";
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
					Query.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void Query2() {
		Statement stmt=null;
		Connection con=Query.GetConnection(Constants.DB_URLD1);
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sqlQ="SELECT Name FROM DISTRICTS";
			stmt.executeUpdate(sqlQ);
			ResultSet rs=stmt.executeQuery(sqlQ);
			while(rs.next()){
				String Name = rs.getString("Name");
				System.out.println(Name);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt != null) {
				try {
					stmt.close();
					Query.CloseConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void Query3() {
		  Statement stmt1=null;
		  Connection con1=Query.GetConnection(Constants.DB_URL);
		  
		  try {
		   stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		   String sql = "SELECT COUNT(*) AS CitizenCount,S1.StateName FROM DataB2.CITIZEN AS C1"+
		          "JOIN DataB1.DISTRICTS AS D1 ON C1.DistrictID=d1.DistictId"+
		          "JOIN DataB1.STATES AS S1 ON S1.StateID=d1.StateID"+
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
		     Query.CloseConnection(con1);
		     
		    } catch (SQLException e) {
		     e.printStackTrace();
		    }
		   }
		  }
	}
	

	 public void Query4(String district) {
	  Statement stmt1=null;
	  Connection con1=Query.GetConnection(Constants.DB_URL);
	  
	  try {
	   stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	   
	   Scanner in = new Scanner(System.in);
	   
	   String sql = "SELECT DistrictID from Datab1.DISTRICTS where DistrictName=\"" +  district + ";\"";
	   ResultSet rs = stmt1.executeQuery(sql);
	      int distid  = 0;
	      distid = rs.getInt(1);
	      sql  = "Delete from Datab1.DISTRICTS where Datab1.DISTRICTS.DistrictID =\"" + distid + ";\"";
	      stmt1.executeUpdate(sql);
	      sql  = "Delete from Datab2.CITIZENS where Datab1.DISTRICTS.DistrictID =\"" + distid + ";\"";
	      stmt1.executeUpdate(sql);
	   
	     
	      rs.close();
	    
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }finally{
	   if (stmt1 != null) {
	    try {
	     stmt1.close();
	     Query.CloseConnection(con1);
	     
	    } catch (SQLException e) {
	     e.printStackTrace();
	    }
	   }
	  }
	 }


	public void Query5(String state) {
	    Statement stmt = null;
	    Connection con = Query.GetConnection(Constants.DB_URLD1);
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
	     Query f=new Query();
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
	       Query.CloseConnection(con);
	      } catch (SQLException e) {
	       e.printStackTrace();
	      }
	     }
	    }
	   }
	 public void Query6(String state) {
	    Statement stmt = null;
	    Connection con = Query.GetConnection(Constants.DB_URL);
	    try {
	     stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	     String sqlQ = "SELECT C1.Name, S1.StateName FROM Datab2.CITIZEN AS C1"
	       + "JOIN Datab1.DISTRICTS AS D1 ON C1.DistrictID=D1.DistrictID"
	       + "JOIN Datab1.STATES AS S1 ON S1.StateID=D1.StateID" + "WHERE S1.NAME=\"" + state + "\"";
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
	       Query.CloseConnection(con);
	      } catch (SQLException e) {
	       e.printStackTrace();
	      }
	     }
	    }
	   }
	 public void Query7() {
	  Statement stmt1=null;
	  Connection con1=Query.GetConnection(Constants.DB_URL);
	  
	  try {
	   stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	   
	   Scanner input = new Scanner(System.in);
	   System.out.println("Enter district name");
	   String district = input.nextLine();
	   String sql = "SELECT  Datab2.CITIZENS.CitizenName from Datab1.Districts "
	     + "join db2.CITIZENS on "
	     + "Datab1.DISTRICTS.DistrictID = Datab2.CITIZENS.DistrictID  where  Datab1.DISTRICTS.DistrictName=\""+
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
	     Query.CloseConnection(con1);
	     
	    } catch (SQLException e) {
	     e.printStackTrace();
	    }
	   }
	  }

}

	public void Query8(int did) {
		Connection con1=Query.GetConnection(Constants.DB_URLD1);
		Connection con2=Query.GetConnection(Constants.DB_URLD2);
		try {
			pstmt = con1.prepareStatement("SELECT * FROM DISTRICTS");
			rs = pstmt.executeQuery();
			while (rs.next()) {
			         if(rs.getInt(1)==did){
			        	int hid= rs.getInt(4);
			        	pstmt = con2.prepareStatement("SELECT * FROM CITIZENS");
			        	rs = pstmt.executeQuery();
			        	while (rs.next()) {
					         if(rs.getInt(1)==hid){
					        	 System.out.println(rs.getInt(2));
					        	 break;
					         }
			 			break;
			         }
			}
			         
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	}

	public void Query9(int did,int cid) {
		Connection con1=Query.GetConnection(Constants.DB_URLD1);
		try {
			pstmt = con1.prepareStatement("SELECT * FROM DISTRICTS");
			rs = pstmt.executeQuery();
			while (rs.next()) {
			         if(rs.getInt(1)==did){
			        	 DbTable3 db=new DbTable3();
			        	 db.updateDb1(did,rs.getString(2), cid, rs.getInt(4));
			        	 rs = pstmt.executeQuery();
			        	 break;
			         }
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public void Query10() {
		Connection con1=Query.GetConnection(Constants.DB_URLD1);
		Connection con2=Query.GetConnection(Constants.DB_URLD2);
		        try {
		            DatabaseMetaData dbmd = con1.getMetaData();
		            String[] types = {"TABLE"};
		            ResultSet rs = dbmd.getTables(null, null, "%", types);
		            while (rs.next()) {
		                System.out.println(rs.getString("TABLE_NAME"));
		            }
		            
		            DatabaseMetaData dbm = con2.getMetaData();
		            String[] type = {"TABLE"};
		            ResultSet r = dbmd.getTables(null, null, "%", types);
		            while (rs.next()) {
		                System.out.println(r.getString("TABLE_NAME"));
		            }
		            
		        } 
		            catch (SQLException e) {
		            e.printStackTrace();
		        }   
		
	}

		public void Query11() {
			  Statement stmt1=null;
			  Connection con1=Query.GetConnection(Constants.DB_URL);
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
			      
				DbTable1 db1 = new DbTable1();
				DbTable2 db2 = new DbTable2();
				DbTable3 db3 = new DbTable3();
				Db1Table db4 = new Db1Table();
				try {
					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					System.out.println("insert in Db2 citizen ");
				     db4.connect();	
				     db4.createTable();

					Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					System.out.println("insert in Db1 president ");
				     db1.connect();
				     db1.createTable();

				    Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				    System.out.println("insert in Db1 state ");
				     db2.connect();
				     db2.createTable();

				    Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				    System.out.println("insert in Db1 district ");
				     db3.connect();
				     db3.createTable();

			    	} catch (Exception e) {
					e.printStackTrace();
				}
				
			   
			   
			   
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }finally{
			   if (stmt1 != null) {
			    try {
			     stmt1.close();
			     Query.CloseConnection(con1);
			     
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
		int i = 1;
		Query Q = new Query();
		//Q.setup();

		DbTable1 db1 = new DbTable1();
		DbTable2 db2 = new DbTable2();
		DbTable3 db3 = new DbTable3();
		Db1Table db4 = new Db1Table();
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			System.out.println("insert in Db2 citizen ");
		     db4.connect();	
		     db4.insertDb1();
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			System.out.println("insert in Db1 president ");
		     db1.createTable();
		     db1.insertDb1();
		    Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		    System.out.println("insert in Db1 state ");
		     db2.connect();
		     db2.createTable();
		     db2.insertDb1();
		    Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		    System.out.println("insert in Db1 district ");
		     db3.connect();
		     db3.createTable();
		     db3.insertDb1();
			
	    	} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		while (i == 1) {
			System.out.println("Enter your choice\n");
			System.out.println("1.List all the states\n2.List all the districts");
			System.out.println("3.Display the citizen count for all the states\n4.Remove a district");
			System.out.println("5.Remove a state\n6.List of citizens under state");
			System.out.println("7.List of citizens under district\n8.Show head of a district");
			System.out.println("9.Change Head of a district\n10.List technical details");
			System.out.println("11.Create or restore data and tables\n12.Exit");
			int choice = S.nextInt();
			String str;
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
				str=S.next();
				Q.Query4(str);
				break;
			case 5:
				str=S.next();
				Q.Query5(str);
				break;
			case 6:
				str=S.next();
				Q.Query6(str);
				break;
			case 7:
				Q.Query7();
				break;
			case 8:
				int id=S.nextInt();;
				Q.Query8(id);
				break;
			case 9:
				int did=S.nextInt(),cid=S.nextInt();
				Q.Query9(did,cid);
				break;
			case 10:
				Q.Query10();
				break;
			case 11:
				Q.Query11();
				break;
			case 12:
				i = 0;
				break;
			}
		}
	}
}






