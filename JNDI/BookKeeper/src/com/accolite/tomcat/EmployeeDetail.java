package com.accolite.tomcat;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.mail.internet.InternetAddress;
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
 * Servlet implementation class EmployeeDetail
 * 
 * Servlet which responds when user logged in and displays the details
 * 
 */
@WebServlet(description = "gives employee details based", urlPatterns = { "/employeedetails" })
public class EmployeeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hashtable env= new Hashtable();
		//needed to create to the environment
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initContext;
		//the response
		PrintWriter out=response.getWriter();
		out.append("<!DOCTYPE html>"+
					"<html>"+
					"<head>"+
					"<meta charset='ISO-8859-1'>"+
					"<title>BookKeeper Index</title>"+
					"<script type='text/javascript'>"
					+ "function employ(){"
					+ "	document.getElementsByName('id')[0].value=prompt('enter the id');"
					+ "	document.getElementsByName('name')[0].value=prompt('enter the name');"
					+ "	document.getElementsByName('email')[0].value=prompt('enter the email');"
					+ "	document.getElementById('employForm').submit();"
					+ "}"
					+ "</script>"+
					"</head>"+
					"<body>");
		try {
		    //need to give the env map for creating the environment for the first time
			initContext = new InitialContext(env);
			//getting the environment context
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			//getting the datasource through JNDI
			DataSource dataSource=(DataSource)envContext.lookup("jdbc/MyDatabase");
			Connection con=dataSource.getConnection();
			Statement stmt=con.createStatement();
			//get which user logged in whether manager or employee
			String user = request.getUserPrincipal().getName();
			if(user.equals("manager")){
				//select all the employee's details for manager
				ResultSet rs=stmt.executeQuery("use BookKeeper select * from employee");
				//for employee add a form to add new employees
				out.append("<h1>Manager</h1><form id='employForm' action='employ' method='POST'>"
						+ "<input type='hidden' name='name'>"
						+ "<input type='hidden' name='id'>"
						+ "<input type='hidden' name='email'>"
						+ "<input type='button' value='employ' onclick='employ();'>"
						+ "</form>");
				out.append("<table>");
				while(rs.next()){
					out.append("<tr><td><p>"+rs.getString(1)+"</p></td><td><p>"+rs.getString(2)+"</p></td><td><p>"+rs.getString(3)+"</p></td></tr>");
				}
				out.append("</table>");
			}else{
				//don't select all the employee details if employee loggedin
				ResultSet rs=stmt.executeQuery("use BookKeeper select * from employee where name='lokesh'");
				out.append("<h1>Employee</h1><table>");
				while(rs.next()){
					out.append("<tr><td><p>"+rs.getString(1)+"</p></td><td><p>"+rs.getString(2)+"</p></td><td><p>"+rs.getString(3)+"</p></td></tr>");
				}
				out.append("</table>");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
