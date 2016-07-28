package com.au.tomcat.assignment;

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
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Hashtable env= new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context context;
		Context envContext;
		Employee emp=new Employee();
		try
		{
			context = (Context) new InitialContext(env);
			envContext = (Context) context.lookup("java:/comp/env");
			DataSource  dataSource =(DataSource) envContext.lookup("jdbc/MyDataBase");
			Connection connection=dataSource.getConnection();
			Statement statement=connection.createStatement();
			String sql="select * from Employee where empName='"+request.getAttribute("user")+"'";
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				//Employee emp = (Employee) envContext.lookup("bean/Employee");
				emp.setEmployeeID(result.getString(1));
				emp.setEmployeeName(result.getString(2));
				emp.setEmployeeMail(result.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	//response.getWriter().println(employees);
		RequestDispatcher rd=request.getRequestDispatcher("Employee.jsp");
		request.setAttribute("employees", emp);
		rd.forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
