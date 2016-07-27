package com.acco.chatAppSpring;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class RegisterDao {
	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean isValidRegister(String username) throws SQLException
	{

		String queryForAlreadyPresentUser = "Select count(1) from user where username = ?";

		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(queryForAlreadyPresentUser);

		pstmt.setString(1, username);

		ResultSet resultSet = pstmt.executeQuery();

		boolean isalreadyPresent = false;
		if (resultSet.next())

			isalreadyPresent = true;

		return isalreadyPresent;
	}
	
	public boolean register(String username, String password)throws SQLException{
		boolean isalreadyPresent = isValidRegister(username);
		if(isalreadyPresent) return false;
		String query = "insert into user(username,password) values(?,?)";

		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);

		pstmt.setString(1, username);
		pstmt.setString(2, password);
		boolean result = pstmt.execute(query);

		return result;
	}
}
