package com.accolite.controllerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetEmployees
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/GetEmployees" })
public class GetEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Hashtable  env=new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		
		try{
			
			Context initialContext =new InitialContext(env);
			Context envContext=(Context)initialContext.lookup("java:/comp/env");
			javax.sql.DataSource name1=(javax.sql.DataSource)envContext.lookup("database");
			Connection conn=name1.getConnection();
			java.sql.Statement stmt=conn.createStatement();
			String sql="Select employee_name,employee_email from dbo.employee";
			ResultSet rs=stmt.executeQuery(sql);
			PrintWriter out=response.getWriter();
			while(rs.next())
			{
				String name=(rs.getString("employee_name"));
				String mail=(rs.getString("employee_email"));
				out.print(name+" : " +mail +"<br>");
			}
		
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
