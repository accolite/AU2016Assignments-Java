package jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class createdatabase {
	
	
		public static void main(String[] args) {
			createdatabase demo=new createdatabase();
			Connection conn = null;
			Statement stmt = null;
			try {
				//register driver
				Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
				
				conn = DriverManager.getConnection(Constants.DB_URL,Constants.user_name,Constants.password);
				
				//stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				stmt = conn.createStatement();
				String sql = "if not exists(select * from sys.databases where name = 'jdbc1')create database jdbc1";
			      stmt.executeUpdate(sql);
			      System.out.println("Database1 created successfully...");
			      
			     String table = "if not exists (select * from sysobjects where name='state1' and xtype='U')  CREATE TABLE state1 " +
		                   "(id INTEGER not NULL, " +
		                   " name VARCHAR(255), " + 
		                  
		                   " PRIMARY KEY ( id ))"; 
			      stmt.executeUpdate(table);
			      System.out.println("table  created");
                       
			     sql=" use jdbc1 IF NOT EXISTS(SELECT * FROM state1 where id=1)   "
			     		+ "INSERT INTO state1 " + "VALUES (1, 'haryana')";
			      stmt.executeUpdate(sql);
			      
			      
			      
			      sql=" IF NOT EXISTS(SELECT * FROM state1 where id=2)   "
				     		+ "INSERT INTO state1 " + "VALUES (2, 'punjab')";
				      stmt.executeUpdate(sql);
			      
				      sql=" IF NOT EXISTS(SELECT * FROM state1 where id=3)   "
					     		+ "INSERT INTO state1 " + "VALUES (3, 'rajasthan')";
					      stmt.executeUpdate(sql);
					      
					      sql=" IF NOT EXISTS(SELECT * FROM state1 where id=4)   "
						     		+ "INSERT INTO state1 " + "VALUES (4, 'gujrat')";
						      stmt.executeUpdate(sql);
						      
						      sql=" IF NOT EXISTS(SELECT * FROM state1 where id=1)   "
							     		+ "INSERT INTO state1 " + "VALUES (5, 'karnataka')";
							      stmt.executeUpdate(sql);
					            
			 
			     
		table = "use jdbc1 if not exists (select * from sysobjects where name='district2' and xtype='U')  CREATE TABLE district2 " +
						     " (districtid INTEGER not NULL, " +
						         "id INTEGER ," +
						          " name VARCHAR(255), " + 
						         
						                 " PRIMARY KEY (districtid) )" ; 
							      stmt.executeUpdate(table);
							      
							      
							     sql="use jdbc1 IF NOT EXISTS(SELECT * FROM district2 where districtid=1)   "
								     		+ "INSERT INTO district2 " + "VALUES (1, 1,'jhajjar')";
								      stmt.executeUpdate(sql);
								      
								      
								      sql="use jdbc1 IF NOT EXISTS(SELECT * FROM district2 where districtid=2)   "
									     		+ "INSERT INTO district2 " + "VALUES (2, 1,'sonipat')";
								   
									      stmt.executeUpdate(sql);
									      
									      
									      sql="use jdbc1 IF NOT EXISTS(SELECT * FROM district2 where districtid=3)   "
										     		+ "INSERT INTO district2 " + "VALUES (3, 1,'bhiwani')";
									      
									   
										      stmt.executeUpdate(sql);
										      
     sql="use jdbc1 IF NOT EXISTS(SELECT * FROM district2 where districtid=4)   "
         + "INSERT INTO district2 " + "VALUES (4, 2,'ludhiana')";
             stmt.executeUpdate(sql);

             sql="use jdbc1 IF NOT EXISTS(SELECT * FROM district2 where districtid=5)   "
                     + "INSERT INTO district2 " + "VALUES (5, 2,'jalandhar')";
                         stmt.executeUpdate(sql);
                         
                         
  sql="use jdbc1 IF NOT EXISTS(SELECT * FROM district2 where districtid=6)   "
     + "INSERT INTO district2 " + "VALUES (6, 3,'jhodpur')";
       stmt.executeUpdate(sql);
 
       sql="use jdbc1 IF NOT EXISTS(SELECT * FROM district2 where districtid=7)   "
    		     + "INSERT INTO district2 " + "VALUES (7, 3,'jaipur')";
    		       stmt.executeUpdate(sql);
  
    		      
    		    		       
    		    		     sql="use jdbc1 IF NOT EXISTS(SELECT * FROM district2 where districtid=8)   "
    		    		    		     + "INSERT INTO district2 " + "VALUES (8, 4,'karnataka')";
      stmt.executeUpdate(sql);
 
			      System.out.println("table2  created");
			      
			      table = "use jdbc1 if not exists (select * from sysobjects where name='president' and xtype='U')  CREATE TABLE president " +
						     " (cid INTEGER not NULL, " +
						          " name VARCHAR(255), " + 	   
						                 " PRIMARY KEY (cid) )" ; 
							      stmt.executeUpdate(table);
							            
							     sql="use jdbc1 IF NOT EXISTS(SELECT * FROM president where cid=1)   "
								     		+ "INSERT INTO president " + "VALUES (1, 'momin')";
								      stmt.executeUpdate(sql);
			      
			       sql = "if not exists(select * from sys.databases where name = 'jdbc2')create database jdbc2";
			      stmt.executeUpdate(sql);
			      System.out.println("Database2 created successfully...");
			      
			      table = "use jdbc2 if not exists (select * from sysobjects where name='citizen' and xtype='U')  CREATE TABLE citizen " +
						     " (cid INTEGER not NULL, " +
						          " name VARCHAR(255), " + 
						     "id INTEGER ,"+
						          "districtid INTEGER ,"+
						     "age INTEGER ,"+
						          "flag INTEGER ,"+
						                 " PRIMARY KEY (cid) )" ; 
							      stmt.executeUpdate(table);

sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=1)   "
								     		+ "INSERT INTO citizen " + "VALUES (1,'momin',1,1,40,1)";
								      stmt.executeUpdate(sql);

  sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=2)   "
+ "INSERT INTO citizen " + "VALUES (2,'sachin',1,2,45,1)";
  stmt.executeUpdate(sql);

  
  sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=3)   "
		  + "INSERT INTO citizen " + "VALUES (3,'mohit',1,3,35,1)";
  stmt.executeUpdate(sql);

  sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=4)   "
		  + "INSERT INTO citizen " + "VALUES (4,'vikas',2,4,40,1)";
  stmt.executeUpdate(sql);

  sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=5)   "
		  + "INSERT INTO citizen " + "VALUES (5,'arvinder',2,5,25,1)";
  stmt.executeUpdate(sql);

  sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=6)   "
		  + "INSERT INTO citizen " + "VALUES (6,'ashish',2,5,65,0)";
  stmt.executeUpdate(sql);

  sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=7)   "
		  + "INSERT INTO citizen " + "VALUES (7,'amit',3,6,24,1)";
  stmt.executeUpdate(sql);

  sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=8)   "
		  + "INSERT INTO citizen " + "VALUES (8, 'ashish',3,7,45,1)";
  stmt.executeUpdate(sql);

  sql="use jdbc2 IF NOT EXISTS(SELECT * FROM citizen where cid=9)   "
		  + "INSERT INTO citizen " + "VALUES (9,'ashish',4,8,45,1)";
  
   stmt.executeUpdate(sql);	 
   
   
			      int choice;
			      System.out.println("enter your choice ");
			      Scanner sc=new Scanner(System.in);
			      choice=sc.nextInt();
			      ResultSet rs;
			      String ans;
			      while(true){
			      switch(choice)
			      {
			      //query 1
			      case 1:
			    	  ans="use jdbc1 select s.name from state1 as s";
			    	  rs = stmt.executeQuery(ans);
			    	  while(rs.next())
			    	  {
			    		  String first = rs.getString("name");
			    		  System.out.println(first);
			    	  }
			    	  break;
			    	  //query 2
			      case 2:
			    	  ans="use jdbc1 select d.name from .district2  as d";
			    	  rs = stmt.executeQuery(ans);
			    	  while(rs.next())
			    	  {
			    		  String first = rs.getString("name");
			    		  System.out.println(first);
			    	  }
			    	  break;
			    	  //query 3
			      case 3:
			    	  ans=" select count(c.cid) as cnt from [jdbc2].dbo.citizen as c inner join [jdbc1].dbo.state1 as s on s.id=c.id group by s.name ";
			    	  rs = stmt.executeQuery(ans);
			    	  while(rs.next())
			    	  {
			    		 int first = rs.getInt("cnt");
			    		  System.out.println(first);
			    	  }
			    	  break;
			    	  //query 4
			    	  
			      case 4:
			    	  ans=" update [jdbc2].dbo.citizen  set [jdbc2].dbo.citizen .flag=0,[jdbc2].dbo.citizen .districtid=0 from [jdbc2].dbo.citizen  inner join [jdbc1].dbo.district2 as d on d.districtid=[jdbc2].dbo.citizen.districtid where d.name='bhiwani' ";
			     stmt.executeUpdate(ans);
			     ans="delete from  [jdbc1].dbo.district2  where [jdbc1].dbo.district2.name='bhiwani' "; 
			     stmt.executeUpdate(ans);
		     ans= "select [jdbc1].dbo.district2.name as dname from [jdbc1].dbo.district2 ";
			     rs = stmt.executeQuery(ans);
			    	  while(rs.next())
			    	  {
			    		 String first = rs.getString("dname");
			    		  System.out.println(first);
			    	  }
			    	  break;
			    	  
			    	  //query 5
			      case 5:
			    	  ans=" update [jdbc2].dbo.citizen  set [jdbc2].dbo.citizen .flag=0,[jdbc2].dbo.citizen .districtid=0 from [jdbc2].dbo.citizen  inner join [jdbc1].dbo.state1 as s on s.id=[jdbc2].dbo.citizen.districtid where s.name='gujrat' ";
					     stmt.executeUpdate(ans);
					     ans="delete from  [jdbc1].dbo.state1  where [jdbc1].dbo.state1.name='gujrat' "; 
					     stmt.executeUpdate(ans);
				     ans= "select [jdbc1].dbo.state1.name as dname from [jdbc1].dbo.state1 ";
					     rs = stmt.executeQuery(ans);
					    	  while(rs.next())
					    	  {
					    		 String first = rs.getString("dname");
					    		  System.out.println(first);
					    	  }
					    	  break;
			    	  //query 6
			      case 6:
			    	  ans=" select c.name as cnt from [jdbc2].dbo.citizen as c inner join [jdbc1].dbo.state1 as s on s.id=c.id where s.name='haryana' group by s.name,c.name ";
			    	  rs = stmt.executeQuery(ans);
			    	  while(rs.next())
			    	  {
			    		 String first = rs.getString("cnt");
			    		  System.out.println(first);
			    	  }
			    	  break;
			    	  
			    	  //query 7
			      case 7:
			    	  ans=" select c.name as cnt from [jdbc2].dbo.citizen as c inner join [jdbc1].dbo.district2 as s on s.districtid=c.districtid where s.name='jalandhar' group by s.name,c.name ";
			    	  rs = stmt.executeQuery(ans);
			    	  while(rs.next())
			    	  {
			    		 String first = rs.getString("cnt");
			    		  System.out.println(first);
			    	  }
			    	  break;
			    	  //query 8
			      case 8:
			    	  ans=" select c.name as cnt from [jdbc2].dbo.citizen as c inner join [jdbc1].dbo.district2 as d on d.districtid=c.districtid where d.name='jaipur'and c.flag=1";
			    	  rs = stmt.executeQuery(ans);
			    	  while(rs.next())
			    	  {
			    		 String first = rs.getString("cnt");
			    		  System.out.println(first);
			    	  }
			    	  break;
			    	  
			    	  //query 9
			    	  case 9:
			    		  String str="arvinder";
			    		  String str2="ashish";
			    		  ans="update [jdbc2].dbo.citizen set [jdbc2].dbo.citizen.flag=1 from [jdbc2].dbo.citizen where ([jdbc2].dbo.citizen.name='ashish' and [jdbc2].dbo.citizen.age<60) ";
			    		  stmt.executeUpdate(ans);
			    		  ans="update [jdbc2].dbo.citizen set [jdbc2].dbo.citizen.flag=0 from [jdbc2].dbo.citizen where [jdbc2].dbo.citizen.name='arvinder' ";
			    		  stmt.executeUpdate(ans);
			    		  
			    		 
			    		  ans=" select  c.name as cnt ,c.flag as fg from [jdbc2].dbo.citizen as c ";
				    	  rs = stmt.executeQuery(ans);
				    	  while(rs.next())
				    	  {
				    		 String first = rs.getString("cnt");
				    		 int second=rs.getInt("fg");
				    		  System.out.println(first+ " "+ second);
				    	  }
				    	  break;
			    		  
			      }
			     // System.out.println("want to enter more y\n");
			      choice=sc.nextInt();

			}
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

