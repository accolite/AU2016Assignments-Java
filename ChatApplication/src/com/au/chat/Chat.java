package com.au.chat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chat
 */

public class Chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int messageIndex = 0;static String[] messages = new String[100]; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public String toString()
	{
		System.out.println("hohihi");
		String s = null;
		for(int i=0;i<messageIndex;i++)
			{
			System.out.println("message["+i+"]="+messages[i]);
			s=s+messages[i]+" ";
			}
		return s;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter pw=response.getWriter();
		String chat_message=request.getParameter("target");
		messages[messageIndex] = chat_message;
		messageIndex++;
		for(int i=0;i<messageIndex;i++)
			pw.println(messages[i]);
		
		RequestDispatcher rd = request.getRequestDispatcher("ChatJSP.jsp");
		request.setAttribute("msg",messages.toString());
		pw.println("message is"+request.getAttribute("msg"));
		rd.forward(request, response);
		
		
	}

}
