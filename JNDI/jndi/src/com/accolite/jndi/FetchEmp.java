package com.accolite.jndi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class FetchEmp
 */
@WebServlet("/FetchEmp")
public class FetchEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("emp_id");
			int id1 = Integer.parseInt(id);
			String func;
			 Hashtable env = new Hashtable();
			 env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			try{
					Context initialContext = new InitialContext(env);
					Context envContext = (Context) initialContext.lookup("java:/comp/env");
					DataSource dataSource =  (DataSource)envContext.lookup("jdbc/MyDatabase");
					Connection connection = dataSource.getConnection();
					Statement stmt =   connection.createStatement();
					String sql = "SELECT * FROM dbo.Employees WHERE emp_id = " + id1;
					ResultSet rs =  stmt.executeQuery(sql);
					PrintWriter out = response.getWriter();
					if(rs.next())
					{
						
						int role = rs.getInt("role");
						if(role == 1)
						{
							func = "manager";
						}
						else
							func = "employee";
						out.println("EmpID: " + " " + id1 + "\n" + "Name:" + " " + rs.getString("emp_name") + "\n" + "EmailID:" + " " + rs.getString("email_id") + "\n" + "Role:" + " " + func);
					}
					else
					{
						System.out.println("Employee record doesnt exist");
					}
					
				}
				catch(Exception e){
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
