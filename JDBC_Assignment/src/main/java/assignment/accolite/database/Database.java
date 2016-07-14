package assignment.accolite.database;

import constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static constants.Constants.USER;
import static constants.Constants.PASS;
/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class Database {

    Connection conn = null;
    Statement stmt = null;

    public Database() throws SQLException {
        CreateDatabase();
        CreateCitizenTable();
        CreatePresidentTable();
        CreateStateTable();
        CreateDistrictsTable();
        CreateVIPTable();
    }

    public void CreateDatabase() throws SQLException {
        try {
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,USER,PASS);
            stmt = conn.createStatement();
            String createDbIfNotExists = "IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'JDBCdatabase') CREATE DATABASE JDBCdatabase";
            stmt.executeUpdate(createDbIfNotExists);
            System.out.println("Database created, if does not exist");

        } catch (SQLException se) {
            System.out.println(se.getErrorCode());
            if (se.getErrorCode() == 1801) {
                // Database already exists error
                System.out.println(se.getMessage());
            } else {
                // Some other problems, e.g. Server down, no permission, etc
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

    public void CreateCitizenTable(){
        try {
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,USER,PASS);
            stmt = conn.createStatement();
            //
            String sqlCreate = "USE JDBCdatabase IF NOT EXISTS(SELECT name FROM sys.tables WHERE name = N'Citizen')" +
                    " CREATE TABLE Citizen(" +
                    "personID INT, " +
                    "name VARCHAR(50), " +
                    "districtID INT, " +
                    "age INT, " +
                    "status VARCHAR(50) )";
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
            //
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("error : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("error : " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void CreatePresidentTable(){
        try {
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,USER,PASS);
            stmt = conn.createStatement();
            //
            String sqlCreate = "USE JDBCdatabase IF NOT EXISTS(SELECT name FROM sys.tables WHERE name = N'President')" +
                    "CREATE TABLE President(" +
                    "personID INT,\n" +
                    "status VARCHAR(50) );";
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
            //
        } catch (ClassNotFoundException e) {
            System.out.println("error : " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("error : " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void CreateStateTable(){
        try {
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,USER,PASS);
            stmt = conn.createStatement();
            //
            String sqlCreate ="USE JDBCdatabase IF NOT EXISTS(SELECT name FROM sys.tables WHERE name = N'States') " +
                    "CREATE TABLE States(" +
                    "stateID INT," +
                    "stateName VARCHAR(50)," +
                    "status VARCHAR(50) )";
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
            //
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void CreateDistrictsTable(){
        try {
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,USER,PASS);
            stmt = conn.createStatement();
            //
            String sqlCreate = "USE JDBCdatabase IF NOT EXISTS(SELECT name FROM sys.tables WHERE name = N'Districts') " +
                    "CREATE TABLE Districts(" +
                    "districtID INT," +
                    "districtName VARCHAR(50)," +
                    "stateID int," +
                    "personID int," +
                    "status VARCHAR(50));";
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
            //
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void CreateVIPTable(){
        try {
            Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
            conn = DriverManager.getConnection(Constants.DB_URL_WITHOUT_DB_NAME,USER,PASS);
            stmt = conn.createStatement();
            //
            String sqlCreate = "USE JDBCdatabase IF NOT EXISTS(SELECT * FROM sys.tables WHERE name = N'dbo.VIP' AND type = 'U') " +
                    "BEGIN " +
                    "CREATE TABLE VIP(" +
                    " personID INT ," +
                    " relativeID int," +
                    " relative VARCHAR(50) );"
                    + " END";
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreate);
            //
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
