package com.au.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Hello World");
		 Hashtable env=new Hashtable();
		 env.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.naming.java.javaURLContextFactory");
			try
			{
				 Context initialContext=new InitialContext();
				 Context envContext=(Context)initialContext.lookup("java:/comp/env");
				 DataSource dataSource=(DataSource) envContext.lookup("jdbc/JNDIAssignment");
				 Connection connection=(dataSource).getConnection();
				 Statement stmt=connection.createStatement();
				 
				
				 
				 String sql="Use JNDIAssignment ; SELECT username,password,email,address from Employee";
				 ResultSet rs=stmt.executeQuery(sql);
				 PrintWriter out = response.getWriter();
				 
				 List<EmployeeDetails> emp=new ArrayList<EmployeeDetails>();
				 while(rs.next())
				 {
					 EmployeeDetails e=new EmployeeDetails();
				     e.setUsername(rs.getString("username"));
				     e.setEmail(rs.getString("email"));
				     e.setPassword(rs.getString("password"));
				     e.setAddress(rs.getString("address"));
				     emp.add(e);
//					 out.println(rs.getString("username"));
//					 out.println(rs.getString("email"));
//					 out.println(rs.getString("password"));
//					 out.println(rs.getString("address"));					
//					 
				 }
				 
				 request.setAttribute("EmpList", emp);
				 RequestDispatcher req=request.getRequestDispatcher("/button.jsp"); 
				 req.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			// RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/button.jsp");\
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
