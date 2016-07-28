package com.au.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Employee
 */
@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 Hashtable env=new Hashtable();
		 env.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.naming.java.javaURLContextFactory");
			try
			{
				Context initialContext=new InitialContext();
				 Context envContext=(Context)initialContext.lookup("java:/comp/env");
				 DataSource dataSource=(DataSource) envContext.lookup("jdbc/JNDIAssignment");
				 Connection connection=dataSource.getConnection();
				 Statement stmt=connection.createStatement();
				 String name=" 'anshika' ";
				 System.out.println("Employee Class");
				 String sql="Use JNDIAssignment ; SELECT username,email,password,address from Employee where username="+name;
				 ResultSet rs=stmt.executeQuery(sql);
				 response.setContentType("text/html");
		         PrintWriter out = response.getWriter();
				 if(rs.next())
				 {
					 out.println(rs.getString("username"));
					 out.println(rs.getString("email"));
					 out.println(rs.getString("password"));
					 out.println(rs.getString("address"));
					 out.println("\n");
//					 System.out.println(rs.getString("username"));
//					 System.out.println(rs.getString("email"));
//					 System.out.println(rs.getString("password"));
//					 System.out.println(rs.getString("address"));
				 }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
