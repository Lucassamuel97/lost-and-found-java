package br.edu.utfpr.alunos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.utfpr.alunos.model.Item;
import br.edu.utfpr.alunos.service.Manager;

public class ItemDAO{
	
	protected EntityManager entityManager;

	public ItemDAO() {
		entityManager = Manager.getInstance().getEm();
	}

	public Item getById(final int id) {
		return entityManager.find(Item.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> searchFilter(String propertyValue){		
		String queryString = "SELECT o FROM Item o where o.descricao like :param and o.status = 'A'";		
		
		Query query = entityManager.createQuery(queryString);		
		query.setParameter("param", '%' +propertyValue + '%');
		
		List<Item> queryResult = query.getResultList();
	   
	    return queryResult;
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> searchAll(){		
		String queryString = "SELECT o FROM Item o where o.status = 'A'";
		
		Query query = entityManager.createQuery(queryString);		
		
		List<Item> queryResult = query.getResultList();
	    
		return queryResult;
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> searchMyposts(int id, String busca){		
		String queryString = "SELECT o FROM Item o where o.idusersrecord = :param and o.descricao like :busca";
		
		Query query = entityManager.createQuery(queryString);		
		query.setParameter("param", id);
		query.setParameter("busca", '%'+busca+'%');
		
		List<Item> queryResult = query.getResultList();
		return queryResult;
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
