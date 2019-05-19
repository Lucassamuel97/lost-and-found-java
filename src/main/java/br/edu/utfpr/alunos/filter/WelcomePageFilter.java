package br.edu.utfpr.alunos.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.alunos.util.Constants;

/**
 * Filtro responsável por apresentar a tela de login quando
 * o usuário não está logado ou a tela inicial do perfil quando
 * o usuário está logado.
 * 
 * As telas são apresentadas ao acessar o path raiz.
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" })
public class WelcomePageFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String address = ((HttpServletRequest) request).getServletPath();		
		if (!(address.equals("/") || address.equals(""))) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {

			HttpServletRequest req = (HttpServletRequest) request;

			//caso não esteja logado, vai para a tela de login
			if (req.getUserPrincipal() == null) {
				address = "login";
				((HttpServletResponse) response).sendRedirect(address);
			} else {
				//redireciona de acordo com o perfil do usuário
				if (req.isUserInRole(Constants.ADMIN)) {
					address = "a/home";
					((HttpServletResponse) response).sendRedirect(address);
				} else {
					address = "u/home";
					((HttpServletResponse) response).sendRedirect(address);
				}
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
