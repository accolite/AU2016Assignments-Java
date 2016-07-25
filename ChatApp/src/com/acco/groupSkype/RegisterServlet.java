package com.acco.groupSkype;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInformation userDataBase;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		userDataBase = new UserInformation();
		int responseType = userDataBase.addNewUser(username, password);
		
		if(responseType == Constants.DUPLICATE_USER_NAME)
		{
			request.setAttribute("error", "duplicate user name, please try again");
			response.sendRedirect(request.getContextPath() + "/register.jsp");
		}
		else{
			System.out.println("new user");
			HttpSession session = request.getSession();
			session.setAttribute("currUser",username);
			response.sendRedirect(request.getContextPath()+"/chat.jsp");
		}
	}
}
