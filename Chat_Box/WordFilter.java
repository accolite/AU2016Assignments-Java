package com.accolite.au.assignment;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class WordFilter
 */
@WebFilter("/Message")
public class WordFilter implements Filter {

    /**
     * Default constructor. 
     */
	FilterConfig config=null;
    public WordFilter() {
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
	@SuppressWarnings("null")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		@SuppressWarnings("unchecked")
		List<String> wordsToRemove = (List<String>) config.getServletContext().getAttribute("words");
		String messageRecieved=request.getParameter("message");
		
		if(wordsToRemove != null && wordsToRemove.size() != 0 && messageRecieved != null && messageRecieved != ""){
		List<String> messageIntoWords = new LinkedList<String>(Arrays.asList(messageRecieved.split(" ")));
		messageIntoWords.removeAll(wordsToRemove);
		messageRecieved=messageIntoWords.toString();
		messageRecieved = messageRecieved.replaceAll("\\[", "").replaceAll("\\]","");
		}
		// pass the request along the filter chain
		request.setAttribute("messageFilter", messageRecieved);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		config=fConfig;
	}

}
