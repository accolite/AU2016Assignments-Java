package com.accolite.au.jdbc.util;

public class Constants {
	public static final String SQL_SERVER_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String JTDS_DRIVER="net.sourceforge.jtds.jdbc.Driver";
	public static final String ORG_DB_URL = "jdbc:sqlserver://localhost:1433;"+"DataBaseName={Org};"+"integratedSecurity=true";
	public static final String PEOPLE_DB_URL = "jdbc:sqlserver://localhost:1433;"+"DataBaseName={People};"+"integratedSecurity=true";
}
