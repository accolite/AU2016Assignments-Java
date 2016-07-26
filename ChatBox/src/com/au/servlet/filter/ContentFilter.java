package com.au.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ContentFilter
 */
@WebFilter("/post")
public class ContentFilter implements Filter {

	FilterConfig config;
	
    public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}

	/**
     * Default constructor. 
     */
    public ContentFilter() {
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
		String[] wordslist = (String[])this.getConfig().getServletContext().getAttribute("wordslist");
		String msg = request.getParameter("msg");
		if(wordslist!=null){
			for(String word: wordslist){
				if(!word.trim().equals("")){
					msg = msg.replaceAll(word.trim(), " ");
					System.out.println(word+" is removed");
					System.out.println(msg);
				}
			}
		}
		request.setAttribute("msg", msg);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		setConfig(fConfig);
	}

}
