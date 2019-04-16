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
import br.edu.utfpr.alunos.model.Users;

@WebServlet("/users")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDao;
	
	public void init() {
		usersDao = new UsersDAO();

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
//				showNewForm(request, response);
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
		List<Users> listUsers = usersDao.findAll();
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/UserList.jsp");
		dispatcher.forward(request, response);
	}
}
