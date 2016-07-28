package com.accolite.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.accolite.employee.Employee;
import com.accolite.employee.Manager;

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
		
		Hashtable env=new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.naming.java.javaURLContextFactory");
		try{
			
			Context initialContext=new InitialContext(env);
			Context envContext=(Context)initialContext.lookup("java:/comp/env");
			DataSource dataSource=(DataSource)envContext.lookup("jdbcBlue");
			Connection connection=dataSource.getConnection();
			Statement statement=connection.createStatement();
			String sql="Use Employee; select * from dbo.employee";
			ResultSet rs=statement.executeQuery(sql);
			Manager manager=new Manager();
			List<Employee> lstEmp=new ArrayList<>();
			Employee emp=new Employee();
			while(rs.next())
			{
				emp.setEmployeeId(rs.getInt("employeeId"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setAddress(rs.getString("address"));
				lstEmp.add(emp);
			}
			
			manager.setEmployeeList(lstEmp);
			request.getSession().setAttribute("EMPLOYEE_LIST", null);
			request.getSession().setAttribute("EMPLOYEE_LIST", manager);
			response.sendRedirect("ManagerPage.jsp");
		}catch(Exception e){
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
