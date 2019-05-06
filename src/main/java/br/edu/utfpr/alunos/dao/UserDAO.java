package br.edu.utfpr.alunos.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.service.Manager;

public class UserDAO {

	protected EntityManager entityManager;

	public UserDAO() {
		entityManager = Manager.getInstance().getEm();
	}

	public User getById(final int id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
	}

	public void persist(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(User user) {
		try {
			entityManager.getTransaction().begin();
			user = entityManager.find(User.class, user.getId());
			entityManager.remove(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			User user = getById(id);
			remove(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}