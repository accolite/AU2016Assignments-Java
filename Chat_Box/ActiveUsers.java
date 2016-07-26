package com.accolite.au.assignment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActiveUsers
 */
@WebServlet("/ActiveUsers")
public class ActiveUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<String> activeusers=(ArrayList<String>) getServletConfig().getServletContext().getAttribute("activeusers");
		String currentuser=(String) request.getSession(false).getAttribute("username");
		//int id=activeusers.indexOf(currentuser);
		//currentuser="<b>"+currentuser+"</b>";
		//activeusers.set(id, currentuser);
		String responseToSend="";
		for(int i=0;i<activeusers.size();i++)
		{
			if(activeusers.get(i).equals(currentuser))
			{
				responseToSend+="<b>"+currentuser+"</b>";
			}
			else
			{
			responseToSend+=activeusers.get(i);
			}
		}
		response.getWriter().println(responseToSend);
		//response.getWriter().println(currentuser);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
