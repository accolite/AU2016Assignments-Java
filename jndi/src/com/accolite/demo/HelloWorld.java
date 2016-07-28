package com.accolite.demo;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Hashtable env=new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;
		try {
			initialContext = new InitialContext(env);
//			Context envcontext=(Context) initialContext.lookup("java:/comp/env");
//			Integer counter=(Integer) envcontext.lookup("counter");
			Context envcontext=(Context) initialContext.lookup("java:/comp/env");
				//DataSource dataSource=(DataSource) envcontext.lookup("jdbc/MyDatabase");
//				Connection connection=dataSource.getConnection();
//				Statement stmt=connection.createStatement();
//				String sql="use ChatRoomSpring select * from users";
//				ResultSet rs=stmt.executeQuery(sql);
//				
//				while(rs.next()){
//					PrintWriter pw=response.getWriter();
//					pw.print("<br/>"+rs.getString("name"));
//					System.out.println("Name:"+rs.getString("name"));
//				
//				}
				
				Student student=(Student) envcontext.lookup("bean/MyStudentBeanFactory");
				student.setId(1);
				student.setName("JeganMuthaiah");
				System.out.println(student.getId()+" "+student.getName()+" "+student.getSchoolname());
				
			//PrintWriter pw=response.getWriter();
			//pw.print(counter);
			//System.out.println("Counter:"+counter);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//PrintWriter pw=response.getWriter();
		//pw.print("<br/>HelloWorld");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
