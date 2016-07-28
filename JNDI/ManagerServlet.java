package com.au.tomcat.assignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
	@SuppressWarnings("unchecked")
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Hashtable env= new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context context;
		Context envContext;
		List<Employee> employees = null;
		try
		{
			context = (Context) new InitialContext(env);
			envContext = (Context) context.lookup("java:/comp/env");
			DataSource  dataSource =(DataSource) envContext.lookup("jdbc/MyDataBase");
			Connection connection=dataSource.getConnection();
			Statement statement=connection.createStatement();
			String sql="select * from Employee";
			ResultSet result=statement.executeQuery(sql);
			employees = new ArrayList<Employee>();
			while(result.next())
			{
//				Employee emp = (Employee) envContext.lookup("bean/Employee");
				Employee emp=new Employee();
				emp.setEmployeeID(result.getString(1));
				emp.setEmployeeName(result.getString(2));
				emp.setEmployeeMail(result.getString(3));
				employees.add(emp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//response.getWriter().println(employees);
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("Manager.jsp");
		request.setAttribute("employees", employees);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Hashtable env= new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context context;
		Context envContext;
		List<Employee> employees = null;
		try
		{
			context = (Context) new InitialContext(env);
			envContext = (Context) context.lookup("java:/comp/env");
			DataSource  dataSource =(DataSource) envContext.lookup("jdbc/MyDataBase");
			Connection connection=dataSource.getConnection();
			Statement statement=connection.createStatement();
			String sql="insert into Employee values('"+request.getParameter("employeeName")+"','"+request.getParameter("employeeMail")+"')";
			int result1=statement.executeUpdate(sql);
		    sql="select * from Employee";
			ResultSet result=statement.executeQuery(sql);
			employees = new ArrayList<Employee>();
			while(result.next())
			{
				//Employee emp = (Employee) envContext.lookup("bean/Employee");
				Employee emp=new Employee();
				emp.setEmployeeID(result.getString(1));
				emp.setEmployeeName(result.getString(2));
				emp.setEmployeeMail(result.getString(3));
				employees.add(emp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			Session session = (Session) envCtx.lookup("mail/Session");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vlowkya11@gmail.com"));
			InternetAddress to[] = new InternetAddress[1];
			to[0] = new InternetAddress(request.getParameter("employeeMail"));
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("From Manager");
			message.setContent("Your are added to employee list by manager", "text/plain");
			
				Transport.send(message);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	//response.getWriter().println(employees);
		RequestDispatcher rd=request.getRequestDispatcher("Manager.jsp");
		request.setAttribute("employees", employees);
		rd.forward(request, response);
	}

}
