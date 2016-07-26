package com.au.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MessageFilter
 */
@WebFilter(description = "filter message", urlPatterns = { "/ChatServlet" })
public class MessageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MessageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        DatabaseConnect db=new DatabaseConnect();
        String message=request.getParameter("message");
        String updatemessage="";
        String[] words = message.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            words[i] = words[i].replaceAll("[^\\w]", "");
            if(!db.verifyword(words[i])){
            	updatemessage=updatemessage+words[i];
            }
            else
            	System.out.println("filtering "+words[i]);	
        	System.out.println("message after filtering "+updatemessage);
        } 
	    request.setAttribute("message", updatemessage);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
