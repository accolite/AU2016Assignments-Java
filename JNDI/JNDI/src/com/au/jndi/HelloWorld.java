package com.au.jndi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public String dbConnectionDemo(){
    	try {
    		Hashtable env = new Hashtable();
    		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			Context initialContext= new InitialContext(env);
			Context context=(Context)initialContext.lookup("java:/comp/env");
			DataSource dataSource =(DataSource)context.lookup("jdbc");
			Connection connection=dataSource.getConnection();
			Statement stmt=connection.createStatement();
			String sql="select * from Users;";
			String result="";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				result+=rs.getInt(4)+"  Name:  "+rs.getString(1)+"  <br>Email:  "+rs.getString(2)+"    <br> Buisness Unit:   "+rs.getString(3)+" <br><br><br>";
			}
			return result;
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			return "No employee in database";
		}
    }
    
    
    public String dbUser(String name ){
    	try {
    		Hashtable env = new Hashtable();
    		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			Context initialContext= new InitialContext();
			Context context=(Context)initialContext.lookup("java:/comp/env");
			DataSource dataSource =(DataSource)context.lookup("jdbc");
			Connection connection=dataSource.getConnection();
			Statement stmt=connection.createStatement();
			String sql="select * from Users where EmployeeName ='"+name+"';";
			String result="";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				result+=rs.getInt(4)+"  Name:  "+rs.getString(1)+"  <br>Email:  "+rs.getString(2)+"    <br> Buisness Unit:   "+rs.getString(3)+" <br><br><br>";
			}
			return result;
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			return "No employee in database";
		}
    }
    
    
//    public void getStudentBean(){
//    	try{
//    		Context initialContext = new InitialContext();
//    		Context envContext = (Context) initialContext.lookup("java:/comp/env");
//    		Student student = (Student) envContext.lookup("bean/StudentBeanFactory");
//    		student.setId(200);
//    		student.setName("Can be anything");
//    		student.setSchool_name("school");
//    		System.out.println("Student name: "+student.getSchool_name());
//    	}
//    	catch(Exception e){
//    		
//    	}
//    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Hashtable env = new Hashtable();
		String ans="";
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		try {
			Context initialcontext = new InitialContext(env);
			Context envContext = (Context) initialcontext.lookup("java:/comp/env");
			 if (request.isUserInRole("manager")) {
				 	 ans= dbConnectionDemo();
				 	response.getWriter().append(ans);
				 	request.setAttribute("message", ans); // This will be available as ${message}
			        request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
				 	//response.sendRedirect("admin.html");
			    } else if (request.isUserInRole("tomcat")){
			    	
			    	 ans= dbUser(request.getUserPrincipal().getName());
					 	response.getWriter().append(ans);
					 	request.setAttribute("message", ans); // This will be available as ${message}
				        request.getRequestDispatcher("/WEB-INF/userlist.jsp").forward(request, response);
			       // response.sendRedirect("userlist.jsp");
			    }
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append(ans);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
