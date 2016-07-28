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

public class EmployeeRegister extends HttpServlet{
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
			int empId = Integer.valueOf((String) request.getParameter("empId"));
			String ename = (String) request.getParameter("empName");
			String email = (String) request.getParameter("email");
			String password = (String)request.getParameter("password");
			EmployeeDao employeeDao = new EmployeeDao();
			employeeDao.setDataSource(dataSource);
			boolean successful = employeeDao.register(empId, ename, password,email);
			if(successful)
			{
				response.sendRedirect("http://localhost:8080/JndiAssign/mail.jsp");					
			}
			else{
				out.println("could not register new employee");
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