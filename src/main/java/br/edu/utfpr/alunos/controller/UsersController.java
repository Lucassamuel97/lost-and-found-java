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
import br.edu.utfpr.alunos.dao.UsersDAO;
import br.edu.utfpr.alunos.model.User;

@WebServlet(urlPatterns = {"/usuarios/cadastro","/usuarios/insert","/usuarios/editar","/usuarios/update","/usuarios/deletar", "/usuarios/*"})
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDao;
	
	public void init() {
		usersDao = new UsersDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();	
		try {
			switch (action) {
			case "/usuarios/insert":
				insertUser(request, response);
				break;
			case "/usuarios/update":
				updateUser(request, response);
				break;
			default:
				listUsers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();	
		System.out.println(action);
		try {
			switch (action) {
			case "/usuarios/cadastro":
				showNewFormUser(request, response);
				break;
			case "/usuarios/editar":
				showEditFormUser(request, response);
				break;
			case "/usuarios/deletar":
				deleteUser(request, response);
				break;
			default:
				listUsers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUsers = usersDao.findAll();
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/UserList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewFormUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/UserForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
			String login = request.getParameter("login");
			String pwd = request.getParameter("pwd");
			String telefone = request.getParameter("telefone");
			String email = request.getParameter("email");
			
			User user = new User(login, pwd, telefone, email);
			usersDao.create(user);
			
			response.sendRedirect("listar");
	}
	
	private void showEditFormUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User resultUser  = usersDao.find(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/UserForm.jsp");
		request.setAttribute("user", resultUser);
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		User user = new User(id, login, pwd, telefone, email);
		usersDao.update(user);

		response.sendRedirect("list");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		User user = new User(id);
		usersDao.delete(user);
		response.sendRedirect("list");
	}
	
	
}
