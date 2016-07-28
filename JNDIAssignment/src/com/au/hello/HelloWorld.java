package com.au.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Hashtable;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
        //System.out.println("Hello World");
    }
    
    public void dbConnectionDemo()
    {
//    	try{
//    		Context initialContext = new InitialContext();
//        	Context envContext = (Context) initialContext.lookup("java:/comp/env");
//        	DataSource dataSource = (DataSource) envContext.lookup ("jdbc/AdventureWorks2014");
//        	Connection connection = dataSource.getConnection();
//        	Statement stmt = connection.createStatement();
//        	String sql = "SELECT Firstname FROM CustomerA ";
//        	ResultSet rs = stmt.executeQuery(sql);
//        	if(rs.next())
//        	{
//        		System.out.println(rs.getString("name"));
//        	}
//    	} catch(Exception e)
//    	{
//    		e.printStackTrace();
//    	}
//    	
    }

    public void getEmployeeBean()
    {
//    	Context initialContext;
//		try {
//			initialContext = new InitialContext();
//			Context envContext = (Context) initialContext.lookup("java:/comp/env");
//			Student student = (Student) envContext.lookup("bean/EmployeeBeanFactory");
//			student.setId(200);
//			student.setName("Anshika");
//			System.out.println("Student Name= " + student.getName());
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Hashtable env = new Hashtable();
		//env.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.naming.java.javaURLContextFactory");
		
//		try{
//			Context initialContext = null;
//			
//			initialContext = new InitialContext(env);
//			
//			Context envContext = (Context)initialContext.lookup("java:/comp/env");
//			Integer count = (Integer) envContext.lookup("count");
//			System.out.println("Count:" + count);
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.println("<html><body>");
//			out.println("<h2>Constant value: " + count + "</h2>");
//			out.println("</body></html>");
//		}
//		catch (Exception e)
//		{
//			
//		}
	
//	
//		try{
//    		Context initialContext = new InitialContext();
//        	Context envContext = (Context) initialContext.lookup("java:/comp/env");
//        	DataSource dataSource = (DataSource) envContext.lookup ("jdbc/AdventureWorks2014");
//        	Connection connection = dataSource.getConnection();
//        	Statement stmt = connection.createStatement();
//        	String sql = "Use AdventureWorks2014; SELECT MiddleName FROM CustomerA ";
//        	ResultSet rs = stmt.executeQuery(sql);
//        	if(rs.next())
//        	{
//        		System.out.println(rs.getString("MiddleName"));
//        	}
//    	} 
//		catch(Exception e)
//    	{
//    		e.printStackTrace();
//    	}
//		
//
//    	Context initialContext;
//		try {
//			initialContext = new InitialContext();
//			Context envContext = (Context) initialContext.lookup("java:/comp/env");
//			Student student = (Student) envContext.lookup("bean/EmployeeBeanFactory");
//			student.setId(200);
//			student.setName("Anshika");
//			System.out.println("Student Name= " + student.getName());
//			System.out.println("Student Id=" + student.getId());
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
