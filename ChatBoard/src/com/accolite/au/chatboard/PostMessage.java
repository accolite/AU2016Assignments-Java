package com.accolite.au.chatboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostMessage
 */
@WebServlet("/post")
public class PostMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String)request.getSession().getAttribute("user");
		if(user!=null){
			String msg = request.getAttribute("msg").toString();
			if(msg.trim()!=null){
				List<String> messages = (ArrayList<String>)getServletConfig().getServletContext().getAttribute("chatboard");
				if(messages==null){
					messages = new ArrayList<>();
				}
				messages.add(user+" : "+msg);
				getServletConfig().getServletContext().setAttribute("chatboard", messages);
			}
		}
		else{
			response.setStatus(500);
		}
	}

}
