/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 25, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class UpdateMessageServlet.
 */
@WebServlet("/UpdateMessageServlet")
public class UpdateMessageServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/** The mainclass. */
	mainClass mainclass=new mainClass();
    
    /**
     * Instantiates a new update message servlet.
     *
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<String> Messages=mainclass.getMessages();
		//String json = new Gson().toJson(Messages);
		//String json=(JSONArray)JSONSerializer.toJSON(Messages);
		String msg="";
		for(int i=0;i<Messages.size();i++){
			msg=msg+"<br/>"+Messages.get(i);
		}
		System.out.println("Messages:"+msg);
	    response.setContentType("text/plains");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(msg);
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
