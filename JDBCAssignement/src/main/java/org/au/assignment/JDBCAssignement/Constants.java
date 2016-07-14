package org.au.assignment.JDBCAssignement;

public class Constants {
	public static final String SQL_SERVER_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String JTDS_DRIVER="net.sourceforge.jtds.jdbc.Driver";
	public static final String DB_URL = "jdbc:sqlserver://localhost:1433;"+"DataBaseName=AdventureWorks2014;"+"integratedSecurity=true";
	public static final String DB_URL_WITHOUT_DB_NAME="jdbc:sqlserver://localhost:1433;"+"integratedSecurity=true";
}
