package com.accolite.chat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateChats")
public class UpdateChats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChats() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output="";
		System.out.println("Update chats get");
		for (String temp : MapGlobal.chatsRecord) {
			output+=temp;
			System.out.println(output);
		}
		response.getWriter().append(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Hey I'm here");
		String name=request.getParameter("new_chat").toString();
		System.out.println(name);
		HttpSession session=request.getSession();
		String messageWritten=session.getAttribute("name").toString();
		String output="";
		int j=0,i=0,fl=0;
		String str="";
		while(i<name.length())
		{
			while(i<name.length()&&name.charAt(i)!=' ')
			{
				str=str+name.charAt(i);
				i++;
				
			}
			for(String key : MapGlobal.prohibitedWords)
			{
				if(key.equals(str))
				{
					fl=1;
					break;
				}
			}
			if(fl==0)
				output+=str;
			i++;
			str="";
		}
		
		
		MapGlobal.chatsRecord.add("<br>"+messageWritten+":" +output);
    	
	}

}
