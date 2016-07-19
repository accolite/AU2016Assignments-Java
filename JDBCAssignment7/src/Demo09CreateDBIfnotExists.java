

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo09CreateDBIfnotExists {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		DatabaseMetaData dbmd = null;
		String tmp;
		try {
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,Constants.user_name,Constants.password);
			stmt = conn.createStatement();

			int choice=0,id;
			System.out.println("Select choice ");
			System.out.println("1.List all the states\n2.List all the districts\n3.Display the citizen count for all the tables\n"
					+ "4.Remove a district\n5.Remove a state\n6.List of citizens under district\n7.List of citizens under state\n"
					+"8.Show head of district\n9.Change head of district\n10.List technical details\n11.Create or restore data and tables\n12.Exit");
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			String str;
			ResultSet rs;
			while(true)
			{
				if(choice==1)
				{
					str="USE JDBCAssignment Select s.Name from dbo.State as s where  s.statusS=1";
					rs=stmt.executeQuery(str);
					while(rs.next())
					{
						String s=rs.getString("Name");
						System.out.println(s);
					}
				}
				else if(choice==2)
				{
					str="USE JDBCAssignment Select s.Name from dbo.District as s where s.statusD=1";
					rs=stmt.executeQuery(str);
					while(rs.next())
					{
						String s=rs.getString("Name");
						System.out.println(s);
					}
				}
				else if(choice==3)
				{
					str="USe JDBCAssignment Select count(c.CITIZENID) as NumberOfCitizens,c.sTATEID,s.NAME "
							+" from (Select * from dbo.citizen where inactive<>1)c join dbo.State as s "+
							" on c.sTATEID=s.stateid "+" group by c.sTATEID,s.name ";
					rs=stmt.executeQuery(str);
					while(rs.next())
					{
						int num=rs.getInt("NumberOfCitizens");
						
						String s1=rs.getString("Name");
						System.out.println(""+num+" "+s1);
					}

				}
				else if(choice==4)
				{
					System.out.println("Enter Id");
					id=sc.nextInt();
					str="USe JDBCAssignment "+
					"Update dbo.District "+
					"set statusD=0 where DistrictId="+id+
					" Update dbo.CITIZEN set Inactive=1 ,flag=0 where DISTRICTiD="+id+"";
					stmt.executeUpdate(str);
					System.out.println("Success");
				}
				else if(choice==5)
				{
					System.out.println("Enter Id");
					id=sc.nextInt();
					str="USe JDBCAssignment "+
					"Update dbo.State set statusS=0 "
					+"where StateId="+id
					+ " Update dbo.District "+
					"set statusD=0 where StateId="+id+
					" Update dbo.CITIZEN set Inactive=1 ,flag=0 where StateId="+id+"";
					stmt.executeUpdate(str);
					System.out.println("Success");
					
				}else if(choice==6)
				{
					System.out.println("Enter the name of district");
					tmp=sc.next();
					str="USe JDBCAssignment SElect c.Name "+
					"from dbo.Citizen as c where c.districtId = (Select d.districtID from dbo.District as d "+
					"where d.NAME="+"'"+tmp+"'"+")";
					rs=stmt.executeQuery(str);
					System.out.println("List of citizens");
					while(rs.next())
						System.out.println(rs.getString("Name"));
				}
				else if(choice==7)
				{
					
					System.out.println("Enter the name of state");
					tmp=sc.next();
					str="USe JDBCAssignment SElect c.Name "+
					"from dbo.Citizen as c where c.StateId = (Select s.StateId from dbo.State as s "+
					"where s.NAME="+"'"+tmp+"'"+")";
					rs=stmt.executeQuery(str);
					System.out.println("List of citizens");
					while(rs.next())
						System.out.println(rs.getString("Name"));
				
				}else if(choice==8)
				{
					System.out.println("Enter the name of district");
					tmp=sc.next();
					str="USe JDBCAssignment SElect c.Name "+
							"from dbo.Citizen as c where c.flag=1 AND c.districtId = (Select d.districtID from dbo.District as d "+
							"where d.NAME="+"'"+tmp+"'"+")";
							rs=stmt.executeQuery(str);
							//System.out.println("Head of "+tmp);
							if(!rs.isBeforeFirst())
							{
								System.out.println("No head assigned ");
							}
							else {
							while(rs.next())
								System.out.println("Head of "+tmp+" is "+rs.getString("Name"));
							}
					
				}
				else if(choice==9)
				{
					System.out.println("Enter the name of district");
					tmp=sc.next();
					System.out.println("Enter the name of new head");
					int Age=100;
					String tmp1="";
					int tempp1=1,tempp=1;
					do
					{
						tmp1=sc.next();
						String ss="USe JDBCAssignment Select districtid from dbo.district where name="+"'"+tmp+"'"+"";
						rs=stmt.executeQuery(ss);
						while(rs.next())
							tempp1=rs.getInt("districtId");
						str="USe JDBCAssignment Select age,districtid from dbo.Citizen where name="+"'"+tmp1+"'"+"";
						rs=stmt.executeQuery(str);
						
						while(rs.next())
						{
							Age=rs.getInt("age");
							tempp=rs.getInt("districtid");
						}
						//System.out.println(Age+" "+tempp1+" "+tempp);
						if(Age>60&&tempp==tempp1)
							System.out.println("Invalid Name !!Enter name of head again");
						
					}while(Age>60&&tempp==tempp1);
					str="USe JDBCAssignment Update dbo.Citizen "+
					"set  flag=0 where districtId = (Select s.districtId from dbo.District as s "+
					"where s.NAME="+"'"+tmp+"')  Update dbo.Citizen set flag=1 where name="+"'"+tmp1+"'";
					stmt.executeUpdate(str);
				
				}
				else if(choice==10)
				{
					dbmd=conn.getMetaData();
					System.out.println("Driver Name: "+dbmd.getDriverName());  
					System.out.println("Driver Version: "+dbmd.getDriverVersion());  
					System.out.println("UserName: "+dbmd.getUserName());  
					System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
					System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
				}
				else if(choice==11)
				{
						System.out.println("Restore the database");
						RestoreTable obj=new RestoreTable();
						obj.restore();
				}
				else if(choice==12)
					break;
				else 
				{
					System.out.println("Invalid Choice!! Enter again");
				}
				System.out.println("Select choice ");
				System.out.println("1.List all the states\n2.List all the districts\n3.Display the citizen count for all the tables\n"
						+ "4.Remove a district\n5.Remove a state\n6.List of citizens under district\n7.List of citizens under state\n"
						+"8.Show head of district\n9.Change head of district\n10.List technical details\n11.Create or restore data and tables\n12.Exit");
				choice=sc.nextInt();
			}
			
			
			
			
			
			
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
		finally {
			
		}
	}
}
