/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 26, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// TODO: Auto-generated Javadoc
/**
 * Servlet Filter implementation class WordFilters.
 */
@WebFilter("/MessageServlet/*")
public class WordFilters implements Filter {

	/** The mainclass. */
	mainClass mainclass=new mainClass();
    /**
     * Default constructor. 
     */
    public WordFilters() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * Destroy.
	 *
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * Do filter.
	 *
	 * @param request the request
	 * @param response the response
	 * @param chain the chain
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//ChatterData cdata=ChatterData.getChatterDataInstance();
		String message=request.getParameter("message");
		List<String> Filters=mainclass.getFilters();
		//System.out.println(Filters);
		System.out.println("Filters:" + Filters);
		System.out.println("Message:" + message);
		for(String words:Filters){
			message=message.replaceAll(words,"*****");
		}
		System.out.println("Message:" + message);
		request.setAttribute("message", message);
		chain.doFilter(request, response);		
	}

	/**
	 * Inits the.
	 *
	 * @param fConfig the f config
	 * @throws ServletException the servlet exception
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
