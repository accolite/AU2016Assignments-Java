package org.au.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationHandler
 */
@WebServlet("/doRegister")
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationHandler() {
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
		
		String username = request.getParameter("username");
		
		request.getSession().setAttribute("user", request.getParameter("username"));
		
		if(this.getServletContext().getAttribute("usersList") == null){
			List<String> l = new ArrayList<>();
			l.add(username);
			this.getServletContext().setAttribute("usersList", l);
		} else {
			List<String> usersList = (List<String>) this.getServletContext().getAttribute("usersList");
			if(!usersList.contains(username))
				usersList.add(username);
			this.getServletContext().setAttribute("usersList",usersList);
		}
		response.sendRedirect("login.jsp");
	}

}
