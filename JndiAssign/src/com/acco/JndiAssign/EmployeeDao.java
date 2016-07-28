package com.acco.JndiAssign;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


public class EmployeeDao {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public ResultSet employeeDetails(int empId, String password)
	{
		try{
		String query = "use[Spring] Select * from employee where empId = "+empId+" and password = "+
						"'"+password+"'";
		Statement stmt =  dataSource.getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		return resultSet;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isValidRegister(int empId) throws SQLException
	{
		
		String queryForAlreadyPresentUser = "use[Spring] Select count(1) from employee where empId = ?";

		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(queryForAlreadyPresentUser);

		pstmt.setInt(1, empId);

		ResultSet resultSet = pstmt.executeQuery();

		boolean isalreadyPresent = false;
		if (resultSet.next())

			isalreadyPresent = true;

		return isalreadyPresent;
		
	}
	
	public boolean register(int empId, String empName,String email,String password){
		boolean isalreadyPresent;
		try {
			isalreadyPresent = isValidRegister(empId);
			//if(isalreadyPresent) return false;
			String query = "use[Spring] insert into employee(empId,empName,password,email) values(?,?,?,?)";

			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);

			pstmt.setInt(1, empId);
			pstmt.setString(2, empName);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			boolean result = pstmt.execute();

			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
