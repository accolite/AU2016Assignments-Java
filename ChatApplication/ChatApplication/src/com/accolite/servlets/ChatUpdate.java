package com.accolite.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accolite.java.MessageList;

/**
 * Servlet implementation class ChatUpdate
 */
@WebServlet("/ChatUpdate")
public class ChatUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MessageList msgs=(MessageList) getServletConfig().getServletContext().getAttribute("MESSAGES");
		String data="";
		for(int i=0;i<msgs.getMessageLst().size();i++){
			data+="<b>"+msgs.getMessageLst().get(i).getUsername()+"</b>: "+msgs.getMessageLst().get(i).getMessage()+"<br/><br/>";
		}
		response.getWriter().write(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
