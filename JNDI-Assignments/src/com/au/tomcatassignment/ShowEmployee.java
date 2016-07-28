package com.au.tomcatassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ShowEmployee
 */
@WebServlet("/ShowEmployee")
public class ShowEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static String dbConnection() {
    	String str = "";
		
    	try {
    		Context initialContext = new InitialContext();
    		Context envContext = (Context) initialContext.lookup("java:/comp/env");
    		DataSource dataSource = (DataSource)envContext.lookup("jdbc/MyDatabase");
    		
    		Connection connection = dataSource.getConnection();
    		//System.out.println(connection);
    		Statement stmt = connection.createStatement();
    		
    		String sql = "use SpringChatBox SELECT * from Employee";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()){
    			int id = rs.getInt(1);
    			String name = rs.getString(2);
    			String email = rs.getString(3);
    		    str += "EmpID = "+id+" Name = "+name+" "+" EmailID = "+email+"\n";
    		    System.out.println(str);
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return str;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String str = dbConnection();
		response.getWriter().append(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String str = dbConnection();
		PrintWriter pw = response.getWriter();
		pw.println(str);
		
		//doGet(request, response);
	}

}
