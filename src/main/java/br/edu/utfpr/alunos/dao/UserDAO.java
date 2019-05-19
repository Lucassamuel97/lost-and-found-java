package br.edu.utfpr.alunos.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.utfpr.alunos.model.Role;
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
	
	
	public User getByName(String propertyValue){		
		String queryString = "SELECT o FROM User o where o.login = :param";		
		
		Query query = entityManager.createQuery(queryString);		
		query.setParameter("param", propertyValue);
		
		List<User> queryResult = query.getResultList();
	    
	    User returnObject = null;

	    if (!queryResult.isEmpty()){
	        returnObject = queryResult.get(0);
	    }

	    return returnObject;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll(){
		return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
	}

	public void persist(User user, Role role) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.persist(role);
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