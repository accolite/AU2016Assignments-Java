package com.accolite.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accolite.java.Message;
import com.accolite.java.MessageList;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
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
		
		Message msg=new Message();
		msg.setMessage(request.getAttribute("txtMessage").toString());
		msg.setUsername(request.getParameter("hUsername"));
		MessageList msgLst=(MessageList) getServletConfig().getServletContext().getAttribute("MESSAGES");
		
		msgLst.getMessageLst().add(msg);
		getServletConfig().getServletContext().setAttribute("MESSAGES",msgLst);
		
		response.sendRedirect("ChatInterface.jsp?username="+request.getParameter("hUsername"));
	}

}
