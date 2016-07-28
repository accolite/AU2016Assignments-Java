package com.au.jndi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class employeeDetail
 */
@WebServlet("/employeeDetail")
public class employeeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Hashtable env =new Hashtable();
		List<employee> list=new ArrayList();
	
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		try {
			
			Context initialContext =new InitialContext(env);
			Context envContext =(Context)initialContext.lookup("java:/comp/env");
			DataSource datasource =(DataSource)envContext.lookup("jdbc/MyDatabase");
			Connection connection=datasource.getConnection();
			Statement stmt=connection.createStatement();
			String sql="use Servlet ; Select * from dbo.Information";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
			employee emp=new employee();
			emp.setEmail(rs.getString("email"));
			emp.setName(rs.getString("name"));
			emp.setEmpid(rs.getInt("empid"));
			emp.setSalary(rs.getInt("salary"));
			list.add(emp);	
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("profile"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getInt("empid"));
			//response.getWriter().append(" employee ids are"+rs.getInt("empid") + "\n");
			System.out.println(rs.getInt("salary"));
			}
			request.setAttribute("employee", list);
			   RequestDispatcher rd=request.getRequestDispatcher("manager.jsp");  
			     rd.forward(request,response);
			} catch (SQLException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
			}
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
