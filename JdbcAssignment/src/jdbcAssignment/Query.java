package jdbcAssignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;





public class Query {
	public static void main(String args[]) {
	Connection conn = null;
	Statement stmt = null;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("to list all the states press 1");
	System.out.println("to list all the Districts press 2");
	System.out.println("to Display the citizen count for all the states press 3");
	System.out.println("to Remove a district press 4");
	System.out.println("to Remove a state press 5");
	System.out.println("to List of citizens under state 6");
	System.out.println("to List of citizens under district 7");
	System.out.println("to Show head of a district 8");
	System.out.println("to Change Head of a district 9");
	System.out.println("to List technical details 10");
	System.out.println("to Create or restore data and tables press 11");
	int choice=0;
	try {
		String s2 = br.readLine();
		choice=Integer.parseInt(s2);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	switch(choice)
	{ case 1: try {

		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		conn.setAutoCommit(false);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String sql;
		sql = "select Name from [Database1].[dbo].[States]";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("states name");
		
		while (rs.next()) {
			String name = rs.getString("Name");
			System.out.println(name);
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
		break;
	case 2: try {

		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		conn.setAutoCommit(false);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String sql;
		sql = "select Name from Districts";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("Districts name");
		
		while (rs.next()) {
			String name = rs.getString("Name");
			System.out.println(name);
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
		break;
	case 3: try {

		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		conn.setAutoCommit(false);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String sql;
		sql = "select count(CitizenId) as count,s.Name from [Database2].[dbo].[Citizen] c inner join [Database1].[dbo].[Districts] d on d.DistrictId=c.DistrictId inner join [Database1].[dbo].[States] s on s.StateID= d.StateID group by s.StateID,s.Name";
		ResultSet rs = stmt.executeQuery(sql);
		//System.out.println("Countname");
		
		while (rs.next()) {
			String name = rs.getString("Name");
			int count = rs.getInt("count");
			System.out.println(count+"   "+name);
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
		break;
	case 4: break;
	case 5: break;
	case 6: try {

		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		conn.setAutoCommit(false);
		//stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		PreparedStatement pstmt = null;
		//String sql;
		System.out.println("Enter the any state  name Bihar,UttarPrades,Madhya pradesh,Maharashtra,Punjab");
		String s2 = br.readLine();
		pstmt = conn.prepareStatement("select c.Name from [Database2].[dbo].[Citizen] c inner join [Database1].[dbo].[Districts] d on d.DistrictId=c.DistrictId inner join [Database1].[dbo].[States] s on s.StateID= d.StateID where s.name=?");
		
		pstmt.setString(1, s2);
		ResultSet rs =pstmt.executeQuery();
		System.out.println("name");
		
		while (rs.next()) {
			String name = rs.getString("Name");
			System.out.println(name);
		}
		rs.close();
		pstmt.close();
		conn.close();
		}
	
	catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		break;
	case 7: try {

		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		conn.setAutoCommit(false);
		
		PreparedStatement pstmt = null;
		
		System.out.println("Enter the any district from Bihar,UttarPrades,Madhya pradesh,Maharashtra,Punjab");
		String s2 = br.readLine();
		pstmt = conn.prepareStatement("select c.Name from [Database2].[dbo].[Citizen] c inner join [Database1].[dbo].[Districts] d on d.DistrictId=c.DistrictId where d.Name=?");
		
		pstmt.setString(1, s2);
		ResultSet rs =pstmt.executeQuery();
		System.out.println("name");
		
		while (rs.next()) {
			String name = rs.getString("Name");
			System.out.println(name);
		}
		rs.close();
		pstmt.close();
		conn.close();
		}
	
	catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		break;
	case 8:  try {

		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		conn.setAutoCommit(false);
		
		PreparedStatement pstmt = null;
		
		System.out.println("Enter the any district from Bihar,UttarPrades,Madhya pradesh,Maharashtra,Punjab");
		String s2 = br.readLine();
		pstmt = conn.prepareStatement("select c.Name from [Database2].[dbo].[Citizen] c inner join [Database1].[dbo].[Districts] d on d.DistHeadID=c.CitizenId where d.Name=?");
		
		pstmt.setString(1, s2);
		ResultSet rs =pstmt.executeQuery();
		System.out.println("name");
		
		while (rs.next()) {
			String name = rs.getString("Name");
			System.out.println(name);
		}
		rs.close();
		pstmt.close();
		conn.close();
		}
	
	catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		break;
	case 9:  try {

		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		conn.setAutoCommit(false);
		
		PreparedStatement pstmt = null;
		
		System.out.println("Enter district name and the head name to change");
		String s2 = br.readLine();
		String s3 = br.readLine();
		
		pstmt = conn.prepareStatement("update [Database1].[dbo].[Districts] set DistHeadID=(select c.CitizenId from [Database2].[dbo].[Citizen] c inner join (select d.DistrictId from [Database1].[dbo].[Districts] d where d.Name=? ) t on t.DistrictId =c.DistrictId where c.Name=? and c.Age<60) where [Database1].[dbo].[Districts].Name=?");
		
		pstmt.setString(1, s2);
		pstmt.setString(2, s3);
		pstmt.setString(3, s2);
		int i=pstmt.executeUpdate();
		System.out.println("no of rows updated are: "+i);
		
		pstmt.close();
		conn.close();
		}
	
	catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		break;
	case 10:  try {

		Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL,Constants.username,Constants.password);
		conn.setAutoCommit(false);
		DatabaseMetaData dbmd = conn.getMetaData();
		   System.out.println("Driver Name: "+dbmd.getDriverName());  
		   System.out.println("Driver Version: "+dbmd.getDriverVersion());  
		   System.out.println("UserName: "+dbmd.getUserName());  
		   System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
		   System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
	}
	catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			
			
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		break;
	case 11: break;
	
	
	}
	
	}
}
