package br.edu.utfpr.alunos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.alunos.util.Constants;
import br.edu.utfpr.alunos.util.Routes;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	if(request.getServletPath().contains(Routes.LOGOUT)){
			HttpSession session = request.getSession(false);
			if(session != null){
				session.invalidate();
			}
			String address = request.getContextPath() + "/";
			response.sendRedirect(address);
			return;
		}

		String address = "/WEB-INF/view/login/login.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		try {
			request.login(username, password);

			HttpSession session = request.getSession();
			session.setAttribute("username", request.getUserPrincipal().getName());
			
			if(request.isUserInRole(Constants.ADMIN)) {
				String address = "a/home";
				response.sendRedirect(address);
			}
			else {
				String address = "u/home";
				response.sendRedirect(address);
			}
		}
		catch (Exception e) {
			response.sendRedirect("login?error"+e);
		}
	}
}