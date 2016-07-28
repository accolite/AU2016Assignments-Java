package com.acco.JndiAssign;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class EmployeeLogin extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		DataSource dataSource;
		Connection conn =null;;
		try {
			InitialContext ctx = new InitialContext();
			//response.sendRedirect(arg0);
			dataSource = (DataSource)ctx.lookup("java:comp/env/TestDB");
			PrintWriter out = response.getWriter();
			conn = dataSource.getConnection();
			String role = (String)getServletContext().getAttribute("role");
			int empId = Integer.valueOf((String) request.getParameter("empId"));
			String password = (String)request.getParameter("password");
			EmployeeDao employeeDao = new EmployeeDao();
			employeeDao.setDataSource(dataSource);
			ResultSet resultSet = employeeDao.employeeDetails(empId, password);
			if(resultSet.next())
			{
				String empName = resultSet.getString("empName");
				String email = resultSet.getString("email");
				request.setAttribute("empName", empName);
				request.setAttribute("email", email);
				if(role.equals("employee"))
					response.sendRedirect("http://localhost:8080/JndiAssign/mail.jsp");
				else if(role.equals("manager"))
					response.sendRedirect("http://localhost:8080/JndiAssign/registerEmployee.jsp");
				else
					out.println("invalid role");
					
			}
			else{
				out.println("invalid credentials");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{		
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
