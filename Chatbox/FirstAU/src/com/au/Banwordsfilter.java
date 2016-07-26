package com.au;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Banwordsfilter
 */
@WebFilter("/sendChat")
public class Banwordsfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Banwordsfilter() {
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
		String txt=request.getParameter("txt");
		System.out.println("inside filter");
		for(int i=0;i<tempstuffs.getBanwords().size();i++){
			if(txt.contains(tempstuffs.getBanwords().get(i))){
				txt=txt.replaceAll(tempstuffs.getBanwords().get(i),"****");
			}
		}
		System.out.println(txt);
		request.setAttribute("msg",request.getParameter("uname")+" -> "+txt);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
