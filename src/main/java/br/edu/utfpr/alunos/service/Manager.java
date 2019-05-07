package br.edu.utfpr.alunos.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
	private EntityManager em;
	private static Manager instance = null;
	
	public static Manager getInstance(){
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	private Manager(){
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("lostAndFoundPU");
		em = emf.createEntityManager();
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
