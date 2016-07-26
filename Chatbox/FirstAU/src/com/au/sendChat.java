package com.au;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.Context;

/**
 * Servlet implementation class sendChat
 */
@WebServlet("/sendChat")
public class sendChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendChat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in");
		
		String s="</br>";
		s+=request.getAttribute("msg");
		//s+=request.getParameter("uname");
		//s+=" -> "+request.getParameter("txt");
		//System.out.println(request.getAttribute("txt"));
		tempstuffs.setChat(tempstuffs.getChat()+s);
		if(request.getServletContext().getAttribute("chats")==null){
			//request.getServletContext().
		}
		request.getServletContext().setAttribute("chats",tempstuffs.getChat());
		response.getWriter().append(s);
		System.out.println("out");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
