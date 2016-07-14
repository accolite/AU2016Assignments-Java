/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 14, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */
package com.accolite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.accolite.*;
import com.accolite.util.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: Auto-generated Javadoc
/**
 * The Class Query7.
 */
public class Query7 {
	
	/** The conn. */
	static Connection conn = null;
	
	/** The stmt. */
	static Statement stmt = null;

	/**
	 * List.
	 *
	 * @throws SQLException the SQL exception
	 */
	void list() throws SQLException {
		String sql = "select db2.dbo.Citizen.CitizenName from db2.dbo.Citizen.CitizenName"
				+ " inner join db1.dbo.Districts "
				+ " on db2.dbo.Citizen.DistrictID = db1.dbo.Districts.DistrictID inner join db1.dbo.States"
				+ " on db1.dbo.Districts.StateID = db1.dbo.States.StateID where db1.dbo.Districts.DistrictName = 'Madurai'";
		conn = DriverManager.getConnection(Constants.DB_URL, "sa", "accolite");
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = stmt.executeQuery(sql);
		rs.beforeFirst();
		//
		while (rs.next()) {
			// Retrieve by column name
			String name = rs.getString("first");
			String name1 = rs.getString("last");

			// Display values
			System.out.println(name + name1);
		}

	}
}