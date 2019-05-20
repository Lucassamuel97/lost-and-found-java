package br.edu.utfpr.alunos.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.alunos.dao.UserDAO;
import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.util.Constants;
import br.edu.utfpr.alunos.util.Routes;


/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private Boolean isLoggedIn;
       
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
				
		session = request.getSession();
		isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
		
		remember(response);
		
		try {
			request.login(username, password);
			
			remember(response);
			
			HttpSession session = request.getSession();
			session.setAttribute("username", request.getUserPrincipal().getName());
			
			UserDAO userdao = new UserDAO();
			User usuario = userdao.getByName(username);
			session.setAttribute("userid", usuario.getId());
			
			if(request.isUserInRole(Constants.ADMIN)) {
				session.setAttribute("typeuser", "a");
				String address = "a/home";
				response.sendRedirect(address);
			}
			else {
				session.setAttribute("typeuser", "u");
				String address = "u/home";
				response.sendRedirect(address);
			}
		}
		catch (Exception e) {
			response.sendRedirect("login?error"+e);
		}
	}
	
	private void remember(HttpServletResponse response) {
		if(isLoggedIn == null) {
			session.setAttribute("isLoggedIn", true);
			
			String f = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			Cookie cookie = new Cookie("login-date", f);
			response.addCookie(cookie);
		}
	}
}