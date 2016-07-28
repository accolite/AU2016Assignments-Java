package com.au.ass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "login by user", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		Hashtable env = new Hashtable();
		ArrayList<Employee> list = new ArrayList();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;

		try {
			initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource) envContext.lookup("jdbc");
			Connection connection = (Connection) datasource.getConnection();
			Statement stmt = ((java.sql.Connection) connection).createStatement();
			String sql = "SELECT Id,Name,EmailId FROM dbo.Employees";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmailId(rs.getString(3));
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(2));
				list.add(emp);
			}
			return list;
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LoginServlet ls = new LoginServlet();
		ArrayList<Employee> list = new ArrayList();
		
		list=ls.getAllEmployee();
		System.out.println(list.size());
        for(int i=0;i<list.size();i++){
        Employee emp = new Employee();
        emp=list.get(i);
		out.println("Name of Employee: " +emp.getName());
		out.println("Email of Employee: "+emp.getEmailId());
		out.println("Id of Employee: "+emp.getId()+"\n");
		out.println("\n");
        }
	out.close();

	}



}
