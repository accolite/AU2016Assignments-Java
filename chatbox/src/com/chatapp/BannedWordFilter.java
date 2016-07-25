package com.chatapp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class BannedWordFilter
 */
@WebFilter("/ChatString")
public class BannedWordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BannedWordFilter() {
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

		// pass the request along the filter chain
		//System.out.println("Here with " + request.getParameter("message") );
		if( request.getParameter("message") != null )
		{
			String message = (String) request.getParameter("message");
			ServletContext context = request.getServletContext();
			String words = (String) context.getAttribute("BannedWords");
			//System.out.println("WORDS " + words);
			String[] wordsArray = words.split(",");
			//System.out.println("Filtering before " + message);
			for (int b = 0; b < wordsArray.length; b++) {
				message = message.replaceAll( wordsArray[b], "");
			}
			//System.out.println("Filtering after " + message);
			request.setAttribute("Fmsg", message);
			chain.doFilter( request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
