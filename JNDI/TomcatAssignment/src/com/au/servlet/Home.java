package com.au.servlet;

import java.io.IOException;
import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.au.servlet.bean.Employee;

/**
 * Servlet implementation class Home
 */
@WebServlet("/login")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Home() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Principal p = request.getUserPrincipal();
		if (request.isUserInRole("manager")){
			request.setAttribute("emps", getAllEmployees());
			request.getRequestDispatcher("/manager.jsp").forward(request, response);
		}
		else if(request.isUserInRole("user")){
			String username = p.getName();
			Employee emp = getEmployee(username);
			if(emp!=null){
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("/user.jsp").forward(request, response);
			}
			response.getWriter().append("Your details not exist.");
		}
//		System.out.println();
	}

	
	public List<Employee> getAllEmployees(){
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;
		List<Employee> emps = new ArrayList<>();
		
		try {
			initialContext = new InitialContext(env);
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			String sql = "select * from employee";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Employee e = new Employee(rs.getString(2), rs.getInt(1), rs.getString(3), rs.getString(4));
				emps.add(e);
			}
		}
		catch(SQLException | NamingException exc){
			exc.printStackTrace();
		}
		finally{
			return emps;
		}
	}
	
	public Employee getEmployee(String name){
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;
		Employee emp = null;
		try {
			initialContext = new InitialContext(env);
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			String sql = "select * from employee where name='"+name+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				emp = new Employee(rs.getString(2), rs.getInt(1), rs.getString(3), rs.getString(4));
			}
		}
		catch(SQLException | NamingException exc){
			exc.printStackTrace();
		}
		finally{
			return emp;
		}
	}
	
}
