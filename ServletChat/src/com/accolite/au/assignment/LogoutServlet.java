package com.accolite.au.assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(description = "Logout", urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
    	System.out.println("Logout initiated");
    	/*Cookie loginCookie = null;
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("user")){
    			loginCookie = cookie;
    			break;
    		}
    	}
    	}
    	if(loginCookie != null){
    		loginCookie.setMaxAge(0);
        	response.addCookie(loginCookie);
    	}*/
    	response.sendRedirect("index.html");
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
}
