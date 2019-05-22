package br.edu.utfpr.alunos.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.alunos.dao.RoleDAO;
import br.edu.utfpr.alunos.dao.UserDAO;
import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.util.Sha256Generator;
import br.edu.utfpr.alunos.model.Role;
import br.edu.utfpr.alunos.util.Constants;

@WebServlet(urlPatterns = {"/usuarios/cadastro","/usuarios/insert","/u/usuarios/editar","/u/usuarios/update","/a/usuarios/deletar","/a/usuarios/list"})
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	
	public void init() {
		userDAO = new UserDAO(); 
		roleDAO = new RoleDAO(); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();	
		try {
			switch (action) {
			case "/usuarios/insert":
				insertUser(request, response);
				break;
			case "/u/usuarios/update":
				updateUser(request, response);
				break;
			default:
				String address = request.getContextPath()+"/login";
				response.sendRedirect(address);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();	
		try {
			switch (action) {
			case "/usuarios/cadastro":
				showNewFormUser(request, response);
				break;
			case "/u/usuarios/editar":
				showEditFormUser(request, response);
				break;
			case "/a/usuarios/deletar":
				deleteUser(request, response);
				break;
			case "/a/usuarios/list":
				listUsers(request, response);
				break;
			default:
				String address = request.getContextPath()+"/login";
				response.sendRedirect(address);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUsers = userDAO.findAll();
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/UserList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewFormUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/register.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
			String login = request.getParameter("login");
			String pwd = request.getParameter("pwd");
			String telefone = request.getParameter("telefone");
			String email = request.getParameter("email");
			
//			User user = new User(login, pwd, telefone, email);
//			
//			final String hashed = Sha256Generator.generate(user.getPwd());
//	        user.setPwd(hashed);
	        
			User user = new User(login, Sha256Generator.generate(pwd), telefone, email);
			userDAO.create(user);
			
	        Role role = new Role(user.getLogin(), Constants.USER);
			roleDAO.create(user,role);
						
			String address = request.getContextPath() + "/login";
            response.sendRedirect(address);
	}
	 
	private void showEditFormUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String message = request.getParameter("message");
		int userid = (int) request.getSession().getAttribute("userid");	
		User resultUser  = userDAO.getById(userid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/edit.jsp");
		request.setAttribute("user", resultUser);
		request.setAttribute("message", message);
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		//Reculpera os parametros
		int id = Integer.parseInt(request.getParameter("id"));
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
//		User user = new User(login, pwd, telefone,"");
//		
//		if (pwd != null) {
//			final String hashed = Sha256Generator.generate(pwd);
//	        user.setPwd(hashed);
//		}
		User user = new User(login, Sha256Generator.generate(pwd), telefone, email);
		
		String message = "Usuario atualizado com sucesso";
		try {
			userDAO.update(user, id);
		} catch (Exception e) {
			message = "Erro "+e.getMessage();
		}
	
		String typeuser = (String) request.getSession().getAttribute("typeuser");
		
		String address = request.getContextPath()+ "/"+typeuser+"/usuarios/editar?id="+id+"&message="+message;
		response.sendRedirect(address);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		User user = new User(id);
		userDAO.delete(user);
		response.sendRedirect("list");
	}
	
	
}
