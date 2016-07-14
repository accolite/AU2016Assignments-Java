package com.accolite.util;

public class Constants {
	public static final String SQL_SERVER_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String JTDS_DRIVER="net.sourceforge.jtds.jdbc.Driver";
	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;";
	public static final String DB_URL1 = "jdbc:sqlserver://localhost:1433;"+"DataBaseName=Database_1";
	public static final String DB_URL2 = "jdbc:sqlserver://localhost:1433;"+"DataBaseName=Database_2";
	public static final String DB_URL_WITHOUT_DB_NAME="jdbc:sqlserver://localhost:1433;"+"integratedSecurity=true";
	public static final String username="sa";
	public static final String password="accolite";
}
