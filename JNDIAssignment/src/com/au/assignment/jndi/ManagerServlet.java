package com.au.assignment.jndi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 System.out.println("Hello World");
		 Hashtable env=new Hashtable();
		 env.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.naming.java.javaURLContextFactory");
			try
			{
				Context initialContext=new InitialContext();
				 Context envContext=(Context)initialContext.lookup("java:/comp/env");
				 DataSource dataSource=(DataSource) envContext.lookup("jUserDB");
				 Connection connection=dataSource.getConnection();
				 Statement stmt=connection.createStatement();
				 
				 String sql="Use Company ; SELECT username,emailid,password,address from Employee";
				 ResultSet rs=stmt.executeQuery(sql);
				 List<Employee> emp=new ArrayList<Employee>();
				 
				 while(rs.next())
				 {
					 Employee e=new Employee();
					 e.setUsername(rs.getString("username"));
					 e.setEmailid(rs.getString("emailid"));
					 e.setPassword(rs.getString("password"));
					 e.setAddress(rs.getString("address"));
					 emp.add(e);
					 System.out.print(rs.getString("username")+" ");
					 System.out.print(rs.getString("emailid")+" ");
					 System.out.print(rs.getString("password")+" ");
					 System.out.print(rs.getString("address")+" ");
					 System.out.println();
					 
				 }
			        request.setAttribute("employeeList", emp);

			        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/displyEmployee.jsp");
			        reqDispatcher.forward(request,response);

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
