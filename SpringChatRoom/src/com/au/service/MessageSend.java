package com.au.service;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import sun.util.locale.StringTokenIterator;

/**
 * Servlet Filter implementation class MessageSend
 */
@WebFilter("/SendMessage")
public class MessageSend implements Filter {

    /**
     * Default constructor. 
     */
    public MessageSend() {
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
		//System.out.println("in filter");
		String words = (String)request.getParameter("message");
		StringTokenizer str = new StringTokenizer(SaveWords.PROHIBITEDWORDS , ",");
		while(str.hasMoreTokens()){
			String str1 = (String) str.nextElement();
			words = words.replace(str1, "");
		}
		
		request.setAttribute("message", words);
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
