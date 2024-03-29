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
 

@WebServlet(urlPatterns = {"/a/meusposts","/u/meusposts"})
public class MyPostsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDAO itemDAO;
	
	public void init() {
		itemDAO = new ItemDAO(); 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		showList(request, response);
	}
	
	private void showList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String busca = request.getParameter("busca");
		int userid = (int) request.getSession().getAttribute("userid");	
		
		//Para resovle o bug do null conta na query
		if (busca == null || busca.isEmpty()) {
        	busca = "";
		}
		
		List<Item> listItems = itemDAO.searchMyposts(userid , busca);
				
		request.setAttribute("listItems", listItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/mypost/list.jsp");
		dispatcher.forward(request, response);
	}
		
}