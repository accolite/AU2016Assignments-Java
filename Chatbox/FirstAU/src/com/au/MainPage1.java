package com.au;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage1")
public class MainPage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage1() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("done");
		for(String s1:tempstuffs.getUsers().keySet()){
			System.out.println(s1+"  "+tempstuffs.getUsers().get(s1));
		}
		String choice = request.getParameter("choice");
		System.out.println(choice);
		HashMap<String,String> users=tempstuffs.getUsers();
		String uname = request.getParameter("uname");
		String pw = request.getParameter("pw");
		if(choice==null||choice.equals("")){
			response.getWriter().append("no choice");
		}
		else if(choice.equals("register")){
			if(users.containsKey(uname)){
				System.out.println("there");
			}
			else{
				users.put(uname,pw);
				System.out.println("added");
			}
		}
		else if(choice.equals("ulogin")||choice.equals("login")){
			
			HttpSession session = request.getSession(false);
			//System.out.println(session.getAttributeNames().nextElement());
			//System.out.println(session.getServletContext().getAttributeNames());
			//System.out.println(session.getSessionContext().getAttributeNames().nextElement());
			String s="";
			try{
			s=s+(String) session.getAttribute("name");
			
			}
			catch(Exception e){
				
			}
			if (s.equals("null")||s.equals("")) {
			    // Session is not created.
				//System.out.println("not logged in"+s);
				if(users.containsKey(uname)){
					if(users.get(uname).equals(pw)){
						session=request.getSession();
						session.setAttribute("name",uname);
						tempstuffs.getActiveusers().add(uname);
						System.out.println(tempstuffs.getActiveusers());
						System.out.println("logging in");
						response.getWriter().append("Success");
						System.out.println(response.getWriter().toString());
						//request.set
					}
					else{
						System.out.println("invalid pw");
						response.getWriter().append("Failure");
						System.out.println(response.getWriter().toString());
					}
				}
				else{
					System.out.println("Invalid uname");
					response.getWriter().append("Failure");
					System.out.println(response.getWriter().toString());
				}
				
				
			} 
			else {
			    // Session is already created.
				//if(uname.equals(s)&&user.get(s).equals())
				
				System.out.println("logged in already "+s);
				
				response.getWriter().append("Success");
				/*
				System.out.println(response.getWriter().toString());
				*/
			}
		}
		else if(choice.equals("alogin")){
			HttpSession session = request.getSession(false);
			if (session == null) {
			    // Session is not created.
				System.out.println("not logged in");
			} else {
			    // Session is already created.
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
