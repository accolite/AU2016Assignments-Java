package org.su.jdbcassignment;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Application {
	Statement stmt = null;
	Connection conn=null;
	ResultSet rs;
	public static void main(String[] args) {
		Application app = new Application();
		CreateDatabase d=new CreateDatabase();
		InsertintoDatabase i=new InsertintoDatabase();
		
		System.out.println("1. List all the states\n2. List all the districts\n3. Display the citizen count for all the states\n4. Remove a district5. Remove a state\n6. List of citizens under state\n7. List of citizens under district\n8. Show head of a district\n9. Change Head of a district\n10. List technical details\n11. Create or restore data and tables");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:
			app.liststates();
			break;
		case 2:
			app.listdistrict();
			break;
		case 3:
			app.citizencount();
			break;
		case 4:
			app.removed();
			break;
		case 5:
			app.removes();
			break;
		}
		
	}
	public void liststates()
	{
		try{
			conn= DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			stmt=conn.createStatement();
			String sql;
			sql= "select * from ARNIKA.dbo.State";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 String StateName = rs.getString("Name");    
				 System.out.println(StateName);
			}
			rs.close();
			stmt.close();
			conn.close();
		}
			 catch (SQLException se) {
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
	
	public void listdistrict()
	{
		try{
			conn= DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			stmt=conn.createStatement();
			String sql;
			sql= "select * from ARNIKA.dbo.District";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 String StateName = rs.getString("Name");    
				 System.out.println(StateName);
			}
			rs.close();
			stmt.close();
			conn.close();
		}
			 catch (SQLException se) {
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
	public void citizencount()
	{
		try{
			conn= DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			stmt=conn.createStatement();
			String sql;
			sql= "select s.Name,count(c.CitizenID) "
					+ "Citizens from ARNIKA.dbo.Citizen c inner join ARNIKA.dbo.District d "
					+"on c.DistrictID= d.DistrictID"+" inner join ARNIKA.dbo.State s"+" on s.StateID=d.StateID group "+"by s.Name";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 String StateName = rs.getString("Name");   
				 System.out.println(StateName);
				 int c = rs.getInt("Citizens");  
				 System.out.println(c);
			}
			rs.close();
			stmt.close();
			conn.close();
		}
			 catch (SQLException se) {
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
	public void removed()
	{
		try{
			conn= DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			stmt=conn.createStatement();
			String sql;
			System.out.println("Enter ID of district to be delered");
			Scanner scan=new Scanner(System.in);
			int c=scan.nextInt();
			PreparedStatement pstat;
			sql= "update ARNIKA.dbo.District set ARNIKA.dbo.District.Status=0"+
					"where ARNIKA.dbo.District.DistrictID=?";
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, c);
			pstat.executeUpdate();
			sql="update ct set ct.Status=0"+"from ARNIKA.dbo.Citizen ct inner join ARNIKA.dbo.District d "+
						"on ct.DistrictID=d.DistrictID "+
						"where d.Status=0;" ;
			stmt.executeUpdate(sql);
			sql="select * from ARNIKA.dbo.District" +" where ARNIKA.dbo.District.Status=1;";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 String d = rs.getString("Name");    
				 System.out.println(d);
			}
			
			sql="select * from ARNIKA.dbo.Citizen" +" where ARNIKA.dbo.Citizen.Status=1;";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 String p = rs.getString("Name");    
				 System.out.println(p);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
			 catch (SQLException se) {
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
	
	public void removes()
	{
		try{
			conn= DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
			stmt=conn.createStatement();
			String sql;
			System.out.println("Enter ID of state to be deleted");
			Scanner scan=new Scanner(System.in);
			int c=scan.nextInt();
			PreparedStatement pstat;
			sql= "update ARNIKA.dbo.State set ARNIKA.dbo.State.Status=0"+
					"where ARNIKA.dbo.State.StateID=?";
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, c);
			pstat.executeUpdate();
			sql="update d set d.Status=0"+"from ARNIKA.dbo.State s inner join ARNIKA.dbo.District d "+
						"on d.StateID=s.StateID "+
						"where s.Status=0;" ;
			stmt.executeUpdate(sql);
			sql="update ct set ct.Status=0"+"from ARNIKA.dbo.Citizen ct inner join ARNIKA.dbo.District d "+
					"on ct.DistrictID=d.DistrictID "+
					"where d.Status=0;" ;
		stmt.executeUpdate(sql);
		sql="select * from ARNIKA.dbo.State" +" where ARNIKA.dbo.State.Status=1;";
		rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			 String d = rs.getString("Name");    
			 System.out.println(d);
		}
		
			sql="select * from ARNIKA.dbo.District" +" where ARNIKA.dbo.District.Status=1;";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 String d = rs.getString("Name");    
				 System.out.println(d);
			}
			
			sql="select * from ARNIKA.dbo.Citizen" +" where ARNIKA.dbo.Citizen.Status=1;";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 String p = rs.getString("Name");    
				 System.out.println(p);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
			 catch (SQLException se) {
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

}
