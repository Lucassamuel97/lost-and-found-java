package br.edu.utfpr.alunos.filter;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST}, urlPatterns = {
		"/u/*",
		"/a/*"
})
public class CookieFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		HttpServletResponse servletResponse = (HttpServletResponse)response;

		Principal principal = servletRequest.getUserPrincipal();
		
		if(principal != null) {
			
			boolean createNewCookie = true;
			Cookie[] cookies = servletRequest.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					createNewCookie = false;					
				}
			}
			
			if(createNewCookie) {		
				
				Cookie cookie = new Cookie("username", principal.getName());
				servletResponse.addCookie(cookie);
			}
			
			HttpSession session = servletRequest.getSession(false);
			
			if(session != null) {
				session.setAttribute("username", principal.getName());
			}
		}
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {}
}
