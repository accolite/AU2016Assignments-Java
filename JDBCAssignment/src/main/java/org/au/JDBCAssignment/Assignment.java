package org.au.JDBCAssignment;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.au.database.CreateDatabase;
import org.au.database.InsertData;
import org.au.util.Constants;

public class Assignment {
	
	public static void main(String args[]){
		
		int input;
		String sql, sql2;
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs=null;
			
		
		CreateDatabase cd=new CreateDatabase();
		InsertData id=new InsertData();
		int i=0;
		
		while(i==0)
		{
			System.out.println("1. List all the states \n"
					+ "2. List all the districts \n"
					+ "3. Display the citizen count for all the states \n"
					+ "4. Remove a district \n"
					+ "5. Remove a state \n"
					+ "6. List of citizens under state \n"
					+ "7. List of citizens under district \n"
					+ "8. Show head of all district \n"
					+ "9. Change Head of a district \n"
					+ "10. List technical details \n"
					+ "11. Create or restore data and tables \n"
					+ "12. Exit");
			Scanner in = new Scanner(System.in);
			
			input=in.nextInt();
			try {
				conn = DriverManager.getConnection(Constants.DB_URL,"sa","accolite");
				stmt = conn.createStatement();
			
				switch(input){
				
				case 1:
					sql="SELECT name from dbo.state where status=1";
					rs = stmt.executeQuery(sql);
					while (rs.next()){
						System.out.println(rs.getString("name")+"\n");
					}
					break;
					
				case 2:
					sql="SELECT name from dbo.district where status=1";
					rs = stmt.executeQuery(sql);
					while (rs.next()){
						System.out.println(rs.getString("name")+"\n");
					}
					break;
					
				case 3:
					sql="select count(state.stateID) AS count from dbo.citizen inner join dbo.district "
							+ "on citizen.districtID = district.districtId inner join dbo.state "
							+ "on state.stateID = district.stateID AND state.status=1 group by state.stateID;";
					rs = stmt.executeQuery(sql);
					while (rs.next()){
						System.out.println(rs.getInt("count")+"\n");
					}
					break;
					
				case 4:
					System.out.println("Enter district id to delete");
					int district=in.nextInt();
					sql="update district set status=0 where districtId=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, district);
					pstmt.executeUpdate();
					
					sql="update citizen set status=0 where districtID=? ";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, district);
					pstmt.executeUpdate();
					
					
					break;
					
				case 5:
					System.out.println("Enter state to delete");
					sql="update state set status=0 where name like ?";
					String space=in.nextLine();
					String state=in.nextLine();
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, state);
					pstmt.executeUpdate();
					
					sql="update district set status=0 where stateID IN (select stateID from dbo.state where name like ?)";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, state);
					pstmt.executeUpdate();
					
					sql="update citizen set citizen.status=0 where citizen.status IN (select citizen.status from citizen inner join district "
							+ "on citizen.districtId = district.districtId where district.status=0)";
					pstmt=conn.prepareStatement(sql);
					pstmt.executeUpdate();
					break;
					
				case 6:
					System.out.println("Enter state id");
					int stateIdToList=in.nextInt();
					sql="select citizen.name AS name from dbo.citizen inner join dbo.district "
							+ "on citizen.districtID = district.districtId inner join dbo.state "
							+ "on state.stateID = district.stateID where state.stateID=? AND citizen.status=1;";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, stateIdToList);
					rs=pstmt.executeQuery();
					
					while (rs.next()){
						System.out.println(rs.getString("name")+"\n");
						
					}
					break;
					
				case 7:
					System.out.println("Enter district id");
					int districtIdToList=in.nextInt();
					sql="select citizen.name AS name from dbo.citizen inner join dbo.district "
							+ "on citizen.districtID = district.districtId inner join dbo.state "
							+ "on state.stateID = district.stateID where district.districtId=? AND citizen.status=1;";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, districtIdToList);
					rs=pstmt.executeQuery();
					
					while (rs.next()){
						System.out.println(rs.getString("name")+"\n");
					}
					break;
					
				case 8:
					sql="select citizen.name AS name, district.name AS district from citizen inner join district on "
							+ "citizen.citizenId = district.districtHeadID where district.status=1";
					rs = stmt.executeQuery(sql);
					while (rs.next()){
						System.out.println(rs.getString("name")+"\t");
						System.out.println(rs.getString("district")+"\n");
					}
					break;
				
				case 9:
					System.out.println("Enter the district whose head you want to change");
					space=in.nextLine();
					String District=in.nextLine();
					System.out.println("Enter the id of new head");
					int newId=in.nextInt();
					sql="update district set districtHeadID=? where district.name like ?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, newId);
					pstmt.setString(2, District);
					pstmt.executeUpdate();
					
					break;
					
				case 10:
					ResultSetMetaData rsmd = null;
					DatabaseMetaData dbmd = null;
					
					dbmd = conn.getMetaData();
					System.out.println("Driver Name: "+dbmd.getDriverName());  
					System.out.println("Driver Version: "+dbmd.getDriverVersion());  
					System.out.println("UserName: "+dbmd.getUserName());  
					System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
					System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion()); 
					
					System.out.println("President:\n");
					pstmt = conn.prepareStatement("SELECT * FROM dbo.president");
					rs = pstmt.executeQuery();
					rsmd=rs.getMetaData();
					System.out.println("Total columns: "+rsmd.getColumnCount());  
					System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
					System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
					
					System.out.println("State:\n");
					pstmt = conn.prepareStatement("SELECT * FROM dbo.state");
					rs = pstmt.executeQuery();
					rsmd=rs.getMetaData();
					System.out.println("Total columns: "+rsmd.getColumnCount());  
					System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
					System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
					
					System.out.println("District:\n");
					pstmt = conn.prepareStatement("SELECT * FROM dbo.district");
					rs = pstmt.executeQuery();
					rsmd=rs.getMetaData();
					System.out.println("Total columns: "+rsmd.getColumnCount());  
					System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
					System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
					
					System.out.println("Citizen:\n");
					pstmt = conn.prepareStatement("SELECT * FROM dbo.citizen");
					rs = pstmt.executeQuery();
					rsmd=rs.getMetaData();
					System.out.println("Total columns: "+rsmd.getColumnCount());  
					System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
					System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
					
					System.out.println("Relation:\n");
					pstmt = conn.prepareStatement("SELECT * FROM dbo.relation");
					rs = pstmt.executeQuery();
					rsmd=rs.getMetaData();
					System.out.println("Total columns: "+rsmd.getColumnCount());  
					System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
					System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
					break;
					
				case 11:
					CreateDatabase cd1=new CreateDatabase();
					InsertData id1=new InsertData();
					break;
					
				case 12:
					i=1;
					break;
					
				default:
					System.out.println("Invalid option");
					System.exit(0);
					
				}
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}


}
