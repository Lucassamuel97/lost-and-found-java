package br.edu.utfpr.alunos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.alunos.model.Item;
import br.edu.utfpr.alunos.service.Manager;

public class ItemDAO extends AbstractDAO<String, Item>{
	protected EntityManager entityManager;

	public ItemDAO() {
		entityManager = Manager.getInstance().getEm();
	}

	public Item getById(final int id) {
		return entityManager.find(Item.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Item> findAll() {
		return entityManager.createQuery("FROM " + Item.class.getName()).getResultList();
	}
	
	public void persist(Item item) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(item);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Item item) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(item);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Item item) {
		try {
			entityManager.getTransaction().begin();
			item = entityManager.find(Item.class, item.getId());
			entityManager.remove(item);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Item item = getById(id);
			remove(item);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
