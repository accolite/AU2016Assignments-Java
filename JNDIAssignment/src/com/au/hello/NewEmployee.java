package com.au.hello;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet("/NewEmployee")
public class NewEmployee extends HttpServlet {
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.getWriter().append("Served at: ").append(request.getContextPath());
   System.out.println("Adding new Employee");
   Hashtable env=new Hashtable();
   env.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.naming.java.javaURLContextFactory");
   try
   {
    Context initialContext=new InitialContext();
     Context envContext=(Context)initialContext.lookup("java:/comp/env");
     DataSource dataSource=(DataSource) envContext.lookup("jdbc/JNDIAssignment");
     Connection connection=dataSource.getConnection();
     PreparedStatement pstmt = connection.prepareStatement("Use JNDIAssignment "+ "INSERT INTO dbo.Employee values(?,?,?,?)");
     String username=request.getParameter("username");
     String email=request.getParameter("email");
     String password=request.getParameter("password");
     String address=request.getParameter("address");
     pstmt.setString(1, username);
     pstmt.setString(2, email);
     pstmt.setString(3, password);
     pstmt.setString(4, address);
     int result=pstmt.executeUpdate();
     if(result==1)
     {
      System.out.println("Succesfully inserted"); 
        Session session = null;
         Context initCtx = new InitialContext();
           Context envCtx = (Context) initCtx.lookup("java:comp/env");
           session = (Session) envCtx.lookup("mail/Session");
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress("shremanishu@gmail.com.com"));
           InternetAddress to[] = new InternetAddress[1];
           to[0] = new InternetAddress(email);
           message.setRecipients(Message.RecipientType.TO, to);
           
           message.setSubject("You are registered By Manager!");  
           message.setText("Hello,You are now an Employee! Congratulations");  
           message.setContent("Your are added to employee list by manager", "text/plain");
          
        //send message  
        Transport.send(message);  
         
        System.out.println("Done"); 
      
     }
     
   }
   catch(Exception e)
   {
    e.printStackTrace();
   }
  
 
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
 }
}