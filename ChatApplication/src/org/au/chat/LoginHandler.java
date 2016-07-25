package org.au.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet("/doLogin")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
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

		ServletContext sc= request.getServletContext();
		String username = request.getParameter("username");
		List<String> allUsers = (List<String>) sc.getAttribute("usersList");
		if(allUsers == null){
			response.getWriter().append("No registered users!");
			return;
		}
		if(!allUsers.contains(username)){
			response.getWriter().append("Not a registered user!");
			return;
		}
		
		;
		
		
		
		if(this.getServletContext().getAttribute("usersLoggedin") == null){
			List<String> l = new ArrayList<>();
			l.add(request.getParameter("username"));
			this.getServletContext().setAttribute("usersLoggedin", l);
		} else {
			List<String> l = (List<String>) sc.getAttribute("usersLoggedin");
			if(l.contains(username))
				return;
			l.add(username);
			sc.setAttribute("usersloggedin", l);
		}
		request.getSession().setAttribute("user", request.getParameter("username"));
		if(this.getServletContext().getAttribute("chatString")==null){
			this.getServletContext().setAttribute("chatString",username + " has joined");
		} else {
			this.getServletContext().setAttribute("chatString",this.getServletContext().getAttribute("chatString") + "<br>" + username + " has joined");
		}
		response.sendRedirect("chatbox.jsp");
	}

}
