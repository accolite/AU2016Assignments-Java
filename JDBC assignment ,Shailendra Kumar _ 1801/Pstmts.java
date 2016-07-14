package AU_JDBC.jdbc;
import java.sql.*;

import org.au.workshop.util.Constants;

public class Pstmts {
	PreparedStatement pstmt = null;
	static Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	public void insertStates(int id,String name, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			pstmt = conn.prepareStatement("INSERT INTO DB1.dbo.states values(?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	public void insertDistrict(int id,String name,int headId,int stateId, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			pstmt = conn.prepareStatement("INSERT INTO DB1.dbo.district values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, headId);
			pstmt.setInt(4, stateId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	public void insertPresident(int id,String name, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			pstmt = conn.prepareStatement("INSERT INTO DB1.dbo.president values(?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	public void stateList(String name, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			pstmt = conn.prepareStatement("select c.name from Db1.dbo.states as s, Db1.dbo.district as d , Db2.dbo.citizen as c"
							+ "	where s.State_id = d.State_id "
						     + "and d.district_id = c.district_id and s.name = ?");
			pstmt.setString(1, name);
			rs= pstmt.executeQuery();
			while (rs.next()) {
			System.out.println(rs.getString(1));}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	public void districtList(String name, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			pstmt = conn.prepareStatement("select c.name,d.name from Db1.dbo.district as d , Db2.dbo.citizen as c  where "
				     + " d.district_id = c.district_id and d.name = ?");
			pstmt.setString(1, name);
			rs= pstmt.executeQuery();
			while (rs.next()) {
			System.out.println(rs.getString(1));}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	public void showHead(String name, Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			pstmt = conn.prepareStatement("select c.name from Db1.dbo.district as d , Db2.dbo.citizen as c  where "
				     + " d.Head_id = c.citizen_id and d.name = ?");
			pstmt.setString(1, name);
			rs= pstmt.executeQuery();
			while (rs.next()) {
			System.out.println(rs.getString(1));}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	
	 public void changeHead(String DistrictName , int citizen_id,Connection conn){
		 int disId = -1;
		  try {
			  conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
				 pstmt = conn.prepareStatement("select c.district_id from  Db2.dbo.citizen as c"
						    + " where c.citizen_id = ? and c.age < 60");
				 pstmt.setInt(1,citizen_id);
		   ResultSet rs = pstmt.executeQuery();
		   if(rs.next())
		    disId = rs.getInt(0);
		     } catch (SQLException e) {
		   e.printStackTrace();
		     }
		  if(disId != -1){
		   String updateHead = "update Db1.dbo.district as d set d.Head_id = "
		     + citizen_id + " where d.District_id = "+disId;
		   try {
		    stmt.execute(updateHead);
		   } catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		 }
	
	
	public void insertCitizen(int id,String name,int age,int distId,int spouseId,int childId,Connection conn) {
		try {
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			pstmt = conn.prepareStatement("INSERT INTO DB2.dbo.citizen values(?,?,?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setInt(4, distId);
			pstmt.setInt(5, spouseId);
			pstmt.setInt(6, childId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}
	public Statement connec(){
		try{
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			stmt = conn.createStatement();
			closeResources();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stmt;
	}
	
	public void removeState(String statename,Connection conn) {
			   try { 
				   conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
					pstmt = conn.prepareStatement("delete from Db1.dbo.states  where Db1.dbo.states.name = ?");
							pstmt.setString(1, statename);
			   pstmt.execute();
			   closeResources();
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
	}
public void removeDistrict(String districtname, Connection conn2) {
	try { 
		   conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME);
			pstmt = conn.prepareStatement("delete from Db1.dbo.district  where Db1.dbo.district.name = ?");
					pstmt.setString(1, districtname);
	   pstmt.execute();
		closeResources();
	
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	
	}
	public void closeResources() {
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
