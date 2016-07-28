/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 28, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.au.app;

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
 * Servlet implementation class Employee
 */
@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.println("<style>body {background-color: purple;color: white;font-family: sans-serif;text-align: center}</style>");
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		try
    	{
    		Context initialContext = new InitialContext(env);
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/MyDatabase");
			Connection conn = dataSource.getConnection();
			Statement s = conn.createStatement();
			String query = "SELECT * FROM tomcatapp WHERE name = '" + uname + "'";
			System.out.println(query);
			ResultSet rs = s.executeQuery(query);
			out.print("<h1> EMPLOYEE VIEW </h1> <br><hr>");
			if( rs.next() )
			{
				out.println("<b> Name </b> : " + rs.getString("name") + "<br>");
				out.println("<b> Email </b> : " + rs.getString("email") + "<br>");
			}
    	}
		catch( Exception e )
		{
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
