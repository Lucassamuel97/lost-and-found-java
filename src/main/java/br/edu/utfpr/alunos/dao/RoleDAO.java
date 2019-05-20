package br.edu.utfpr.alunos.dao;

import javax.persistence.EntityManager;

import br.edu.utfpr.alunos.model.Role;
import br.edu.utfpr.alunos.service.Manager;

public class RoleDAO {

	protected EntityManager entityManager;

	public RoleDAO() {
		entityManager = Manager.getInstance().getEm();
	}

	public Role getById(final String id) {
		return entityManager.find(Role.class, id);
	}
	
	public void merge(Role role) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(role);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}