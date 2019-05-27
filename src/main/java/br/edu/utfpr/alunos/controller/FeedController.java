package br.edu.utfpr.alunos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.alunos.dao.ItemDAO;
import br.edu.utfpr.alunos.model.Item;


@WebServlet(urlPatterns = {"/feed"})
public class FeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDAO itemDAO;
	
	public void init() {
		itemDAO = new ItemDAO(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			showFeed(request, response);
	}
	
	private void showFeed(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		int userid = 200;		
		String busca = request.getParameter("busca");
		if (busca == null || busca.isEmpty()) {
        	busca = "";
		}
		
		List<Item> listItems = null;
        listItems = itemDAO.searchFilter(userid, busca);
       
		request.setAttribute("listItems", listItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/feed/feed.jsp");
		dispatcher.forward(request, response);
	}	
}