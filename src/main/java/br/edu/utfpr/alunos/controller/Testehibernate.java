package br.edu.utfpr.alunos.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.alunos.model.User;

@WebServlet("/Testehibernate")
public class Testehibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Testehibernate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		criarBD();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		criarBD();
	}

	private void criarBD() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lostAndFoundPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		User user1 = new User("Teste", "Bill Gates", "Computação","Mail");
		em.persist(user1);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
