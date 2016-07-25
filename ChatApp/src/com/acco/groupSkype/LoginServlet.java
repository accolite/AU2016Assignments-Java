package com.acco.groupSkype;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInformation userDataBase;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		//System.out.println("post called");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		userDataBase = new UserInformation();
		int errorType = userDataBase.checkUser(username, password);
		
		if(errorType == Constants.USER_NOT_FOUND)
		{
			System.out.println("Unknown user");
			request.setAttribute("error", "Unknown user, please try again");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		else if(errorType == Constants.PASSWORD_MISMATCH)
		{
			System.out.println("password does not match");
			request.setAttribute("error", "password does not match, please try again");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		else{
			System.out.println("user is fine");
			HttpSession session = request.getSession();
			ArrayList<String>users = (ArrayList<String>)session.getAttribute("userList");
			if(users == null)
				users = new ArrayList<String>();
			users.add(username);
			session.setAttribute("users", users);
			session.setAttribute("currUser",username);
			response.sendRedirect(request.getContextPath() + "/chat.jsp");
		}
	}
}
