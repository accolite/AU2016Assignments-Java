package com.accolite.chatterbox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "handles the login process", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChatterData cdata=ChatterData.getChatterDataInstance();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String mode=request.getParameter("mode");
		switch(mode){
		case "login":
			if(cdata.doAuthorize(name, password)){
				HttpSession session=request.getSession(false);
				if(session==null)
					session=request.getSession();
				session.setAttribute("username", name);
				session.setAttribute("status", "loggedin");
			}
			response.sendRedirect("tweeter.jsp");
			break;
		case "admin":
			if(cdata.doAuthorize(name, password)){
				HttpSession session=request.getSession(false);
				if(session==null)
					session=request.getSession();
				session.setAttribute("username", "admin");
				session.setAttribute("status", "loggedin");
			}
			response.sendRedirect("admin.html");
			break;
		case "register":
			cdata.addUser(name, password);
			HttpSession session=request.getSession(false);
			if(session==null)
				session=request.getSession();
			session.setAttribute("username", name);
			session.setAttribute("status", "loggedin");
			response.sendRedirect("tweeter.jsp");
			break;
		default: response.sendRedirect("error.html");
		}
	}

}
