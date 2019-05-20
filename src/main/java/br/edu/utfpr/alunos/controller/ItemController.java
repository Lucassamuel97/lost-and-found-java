package br.edu.utfpr.alunos.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.alunos.dao.ItemDAO;
import br.edu.utfpr.alunos.dao.UserDAO;
import br.edu.utfpr.alunos.model.Item;
import br.edu.utfpr.alunos.model.User;

@WebServlet(urlPatterns = {"/item/cadastro","/item/insert","/item/editar","/item/update","/item/deletar","/item/list","/item/devolucao","/item/*"})
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDAO itemdao;
	
	public void init() {
		itemdao = new ItemDAO(); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/item/insert":
				insertItem(request, response);
				break;
			case "/item/update":
				updateItem(request, response);
				break;
			case "/item/devolucao":
				devolucaoItem(request, response);
				break;
			default:
				showNewFormItem(request, response);
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
			case "/item/cadastro":
				showNewFormItem(request, response);
				break;
			case "/item/editar":
				showEditFormItem(request, response);
				break;
			case "/item/deletar":
				deleteItem(request, response);
				break;
			default:
				showNewFormItem(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewFormItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/item/register.jsp");
		dispatcher.forward(request, response);
	}

	private void insertItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String descricao = request.getParameter("descricao");
		String local     = request.getParameter("local");
		String horario   = request.getParameter("horario");
		String date      = request.getParameter("data");
		char status      = 'A';
		
		int userid = (int) request.getSession().getAttribute("userid");	
		
		Item item = new Item(descricao, local, horario, date, status, userid);	
		itemdao.persist(item);
		String address = request.getContextPath() + "/feed";
		response.sendRedirect(address);
	}

	private void showEditFormItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Item resultItem = itemdao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/item/ItemForm.jsp");
		request.setAttribute("item", resultItem);
		dispatcher.forward(request, response);
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String descricao = request.getParameter("descricao");
		String local     = request.getParameter("local");
		String horario   = request.getParameter("horario");
		String date      = request.getParameter("data");
		int id           = Integer.parseInt(request.getParameter("id"));		
		char status      = 'N';

		Item item = new Item(id, descricao, local, horario, date, status);
		itemdao.merge(item);

		response.sendRedirect("list");
	}
	
	private void devolucaoItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id      = Integer.parseInt(request.getParameter("id"));		
		char status = 'D';
		int userid  = (int) request.getSession().getAttribute("userid");
		
		Item item = itemdao.getById(id);
		
		//Verifica se não foi o mesmo usuario que fez a mensagem
		if (item.getUsersrecord() != userid){
			//Seta usuario logado que perdeu o objeto
			item.setUserfound(userid);
			item.setStatus(status);
			itemdao.merge(item);
		}
		
		String address = request.getContextPath() + "/feed";
		response.sendRedirect(address);
	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Item item = new Item(id);
		itemdao.remove(item);
		response.sendRedirect("list");
	}

}
