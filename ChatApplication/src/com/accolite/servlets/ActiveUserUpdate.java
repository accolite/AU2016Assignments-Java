package com.accolite.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accolite.java.ActiveUsers;

/**
 * Servlet implementation class ActiveUserUpdate
 */
@WebServlet("/ActiveUserUpdate")
public class ActiveUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveUserUpdate() {
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
		ActiveUsers users=(ActiveUsers) getServletConfig().getServletContext().getAttribute("ACTIVE_USERS");
		String data="";
		for(int i=0;i<users.getActiveUsers().size();i++){
			data+="<b>"+users.getActiveUsers().get(i).getUsername()+"</b><br/><br/>";
		}
		response.getWriter().write(data);
	}

}
