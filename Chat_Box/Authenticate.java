package com.accolite.au.assignment;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet(description = "Authenticating the request", urlPatterns = { "/Authenticate" })
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getParameter("option").equals("register"))
		{
			if(getServletConfig().getServletContext().getAttribute("userdata") == null)
			{
				HashMap<String, String> users= new HashMap<String,String>();
				users.put(request.getParameter("username"), request.getParameter("password"));
				getServletConfig().getServletContext().setAttribute("userdata", users);
			}
			else
			{
				HashMap<String, String> users=(HashMap<String, String>) getServletConfig().getServletContext().getAttribute("userdata");
				users.put(request.getParameter("username"), request.getParameter("password"));
				getServletConfig().getServletContext().setAttribute("userdata", users);
			}
			System.out.println("registered");
			response.sendRedirect("index.html");
		}
		else
			if(request.getParameter("option").equals("login"))
			{
				if(getServletConfig().getServletContext().getAttribute("userdata").equals(null))
				{
				}
				else
				{
					HashMap<String, String> users=(HashMap<String, String>) getServletConfig().getServletContext().getAttribute("userdata");
					String password=request.getParameter("password");
					String expectedPassword=users.get(request.getParameter("username"));
					if(password != null && expectedPassword != null && password.equals(expectedPassword))
					{
						HttpSession session = request.getSession(false);
						if( session == null)
						{
						 session = request.getSession();
						 session.setAttribute("username", request.getParameter("username"));
							response.sendRedirect("chat.jsp");
							ArrayList<String> activeusers=(ArrayList<String>) getServletConfig().getServletContext().getAttribute("activeusers");
							if(activeusers != null)
							{
							String activeusers1= request.getParameter("username");
							ArrayList<String> activeUsers= (ArrayList<String>) getServletConfig().getServletContext().getAttribute("activeusers");
							activeUsers.add(activeusers1);
							getServletConfig().getServletContext().setAttribute("activeusers",activeUsers );
							String messages=(String) getServletConfig().getServletContext().getAttribute("messages");
							if(messages != null)
							{
							messages=	messages.concat(activeusers1+":logged in"+"\n");
							}
							else
							{
								messages=activeusers1+"logged in"+"\n";
							}
						getServletConfig().getServletContext().setAttribute("messages", messages);
							System.out.println("logged in");
							}
							else
							{
								String activeusers1=request.getParameter("username");
								ArrayList<String> activeUsers= new ArrayList<String>();
								activeUsers.add(activeusers1);
								getServletConfig().getServletContext().setAttribute("activeusers",activeUsers );
//									String messages=(String) getServletConfig().getServletContext().getAttribute("messages");
//									if(messages == null)
//									{
//									}
//									else
//									{
//									messages=	messages.concat(activeusers1+":logged in"+"\n");
//									getServletConfig().getServletContext().setAttribute("messages", messages);
//									}
								
							}
						}
						else
						{
							response.sendRedirect("chat.jsp");
						}
						
					}
					else
					{
						System.out.println("failed");
					}
				}
			}
			else
			{
				System.out.println("admin");
				response.sendRedirect("admin.jsp");
			}
		
		//System.out.println(getServletConfig().getServletContext().getAttribute("userdata").toString());
	}

}
