package com.accolite.jndi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String executeDB(Context envContext, HttpServletResponse response, Map<String,Object> employee){
    	try{
	    	DataSource ds= (DataSource) envContext.lookup("jdbc/soaprest");
			Connection connection = ds.getConnection();
			Statement stmt = connection.createStatement();
			
			
			String query = "INSERT INTO employees(name, age, email, designation) values('"
					+ (String) employee.get("name")+"',"+(Integer)employee.get("age")+",'"
					+(String) employee.get("email")
					+"','"+(String) employee.get("designation")+"');";
			
			
			Integer status=-1;
			
			if(employee.get("name")!=null)
				status = stmt.executeUpdate(query);
			if(status.equals(-1)){
				return "notHappening";
			}else{
				return (String) employee.get("email");
			}
    	}catch(SQLException | NamingException e){
    		System.out.println("Problem "+e.getMessage());
        	return "notHappening";
    	}
    }
    
    private void sendEmail(Context envCtx, String email) throws MessagingException, NamingException{
    	Session session = (Session) envCtx.lookup("mail/Session");

    	Message message = new MimeMessage(session);
    	message.setFrom(new InternetAddress("sharukh2308@gmail.com"));
    	InternetAddress to[] = new InternetAddress[1];
    	to[0] = new InternetAddress(email);
    	message.setRecipients(Message.RecipientType.TO, to);
    	message.setSubject("Welcome "+email+" to Manchester United");
    	message.setContent("Greetings, We are looking forward to your expertise", "text/plain");
    	Transport.send(message);
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> resultMap = null;
		try{
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:comp/env");
			Map<String, Object> map = new HashMap<>();

			map.put("name", (String) request.getParameter("name"));
			map.put("age", Integer.parseInt(request.getParameter("age")));
			map.put("email", (String) request.getParameter("email"));
			map.put("designation", (String) request.getParameter("designation"));
			
			
			String email = executeDB(envContext, response, map);
			if(!email.equals("notHappening")){
				sendEmail(envContext, email);
				resultMap = new HashMap<>();
				resultMap.put("status", "Mail sent");
				
			}
		}catch(NamingException | MessagingException e){
			e.printStackTrace();
			resultMap = new HashMap<>();
			resultMap.put("status", "Mail not sent due to "+e.getMessage());
		}
		String json = new Gson().toJson(resultMap);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
