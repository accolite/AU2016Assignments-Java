package com.accolite.servletassignment;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class BlockerFilter
 */
@WebFilter("/NewPost")
public class BlockerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BlockerFilter() {
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
		if(request.getServletContext().getAttribute("filtered")==null){
			request.getServletContext().setAttribute("filtered", new String());
		}
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		String prev = (String) request.getServletContext().getAttribute("filtered");
		request.getServletContext().setAttribute("filtered", prev );
		
		List<String> blocked = (List<String>) request.getServletContext().getAttribute("blocked");
		String post_content = (String) request.getParameter("post_content");
		System.out.println("What is here "+post_content+ " Blocked : "+blocked);
		if(blocked!=null){
			if(post_content!=null){
				for(String word:blocked){
					if((post_content).contains(word)){
						String filtered = (String) request.getServletContext().getAttribute("filtered");
						filtered = post_content.replaceAll(word, "----");
						request.getServletContext().setAttribute("filtered",filtered);
						System.out.println("Replaced here");
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
