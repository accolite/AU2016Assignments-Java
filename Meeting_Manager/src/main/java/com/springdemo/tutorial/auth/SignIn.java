package com.springdemo.tutorial.auth;


import java.io.IOException;

import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
/**
 * Servlet implementation class SignIn
 */
@WebServlet("/rest/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpTransport transport=new NetHttpTransport();
		JsonFactory jsonFactory=new JacksonFactory();

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
				
		GoogleIdTokenVerifier verifier=new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
				.setAudience(Arrays.asList("470545844187-r537672q0jbi3sioe2t28qpiflid6cmb.apps.googleusercontent.com"))
				.setIssuer("accounts.google.com")
			    .build();
		String idTokenString=request.getParameter("idtoken");
		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(idTokenString);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (idToken != null) {
		  Payload payload = idToken.getPayload();

		  // Print user identifier
		  String userId = payload.getSubject();
		  System.out.println("User ID: " + userId);

		  // Get profile information from payload
		  String email = payload.getEmail();
		  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		  String name = (String) payload.get("name");
		  String pictureUrl = (String) payload.get("picture");
		  String locale = (String) payload.get("locale");
		  String familyName = (String) payload.get("family_name");
		  String givenName = (String) payload.get("given_name");
		  
		  System.out.println(email+" ,"+name+","+emailVerified);
		  out.println("Welcome: "+name);
		  Connection conn = null;
		  Statement stmt = null;

		  try {
		  
		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		   
		   conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=Meeting_Manager","sa","accolite");
		  
		   stmt = conn.createStatement();
		  
		   String sql;
		   sql = "select * from userdata where UserEmail='"+email+"'";
		   ResultSet rSet=stmt.executeQuery(sql);
		   
		   if(rSet.next()){
			   
			   if(rSet.getString("Role").equals("Admin")){
				  System.out.println("Admin");
				  
				  //response.sendRedirect("user.html");
				 // request.getRequestDispatcher("user.html").include(request, response);
				  request.getSession().setAttribute("role", "admin");
				  request.getSession().setAttribute("username", name);
				  request.getSession().setAttribute("email", email);
				  request.getSession().setAttribute( "SessionID", rSet.getInt("UserID"));
			   }else {
				  System.out.println("User");
				 // response.sendRedirect("user.html");
				  //request.getRequestDispatcher("user.html").include(request, response);
				  request.getSession().setAttribute("role", "user");
				  request.getSession().setAttribute("username", name);
				  request.getSession().setAttribute("email", email);
				  request.getSession().setAttribute( "SessionID", rSet.getInt("UserID"));
			}
			   
		   }else {
			 System.out.println("Invalid User");
			 // response.sendRedirect("user.html");
			// request.getRequestDispatcher("user.html").include(request, response);
		}
		   
		  }catch(SQLException e){
			  
			  e.printStackTrace();
		  } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  // Use or store profile information
		  // ...

		  
		} else {
		  System.out.println("Invalid ID token.");
		}
		
	}

}
