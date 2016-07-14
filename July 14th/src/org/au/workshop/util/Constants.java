/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 14, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package org.au.workshop.util;

// TODO: Auto-generated Javadoc
/**
 * The Class Constants.
 */
public class Constants {
	
	/** The Constant SQL_SERVER_JDBC_DRIVER. */
	public static final String SQL_SERVER_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	/** The Constant JTDS_DRIVER. */
	public static final String JTDS_DRIVER="net.sourceforge.jtds.jdbc.Driver";
	
	/** The Constant DB_URL1. */
	public static final String DB_URL1 = "jdbc:sqlserver://localhost:1433;"+"DataBaseName=TEST1;";
	
	/** The Constant DB_URL2. */
	public static final String DB_URL2 = "jdbc:sqlserver://localhost:1433;"+"DataBaseName=TEST2;";
	
	/** The Constant USER. */
	public static final String USER= "sa";
	
	/** The Constant PASSWORD. */
	public static final String PASSWORD= "accolite";		
	
	/** The Constant DB_URL_WITHOUT_DB_NAME. */
	public static final String DB_URL_WITHOUT_DB_NAME="jdbc:sqlserver://localhost:1433;";
}
