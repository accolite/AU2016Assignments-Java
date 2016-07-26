	package com.accolite.au.chatboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Logout.
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new logout.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false) != null){
			String user = (String) request.getSession().getAttribute("user");
			if(user!=null){
				Set<String> activeList = (HashSet<String>)getServletConfig().getServletContext().getAttribute("activeUsers");
				activeList.remove(user);
				List<String> chatboard = (ArrayList<String>)getServletConfig().getServletContext().getAttribute("chatboard");
				chatboard.add("<b>"+user+"</b> left the chatboard");
			}
			request.getSession().invalidate();
			response.setContentType("text/html");
			response.getWriter().write("Successfully logged out. Click <a href=\"/WebChat/\">here</a> to login" );
		}
		else{
			response.setContentType("text/html");
			response.getWriter().write("Please <a href=\"/WebChat/\">login</a> first" );
		}
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
