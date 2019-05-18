package br.edu.utfpr.alunos.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.utfpr.alunos.util.JPAUtil;

@SuppressWarnings("unchecked")
public class AbstractDAO<PK, T> {
	
	protected EntityManager entityManager;

	public AbstractDAO() {
		this.entityManager = JPAUtil.getEntityManager();		
	}
	
	/**
	 * Retorna uma entidade pelo seu ID
	 * 
	 * @param pk id da entidade
	 * @return
	 */
	public T getById(PK pk) {
		this.entityManager = JPAUtil.getEntityManager();
		return (T) entityManager.find(getTypeClass(), pk);
	}
	
	/**
	 * Retorna a entidade pelo atributo único, ou seja, assumirá que há apenas uma entidade com este atributo, 
	 * retornando apenas um elemento. 
	 * 
	 * @param propertyName nome do atributo
	 * @param propertyValue valor do atributo
	 * @return
	 */
	public T getByProperty(String propertyName, String propertyValue){
		this.entityManager = JPAUtil.getEntityManager();
		
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";		
		
		Query query = entityManager.createQuery(queryString);		
		query.setParameter("param", propertyValue);
		
	    List<T> queryResult = query.getResultList();
	    
	    T returnObject = null;

	    if (!queryResult.isEmpty()){
	        returnObject = queryResult.get(0);
	    }

	    return returnObject;
	}

	public T getByForeignOrObjectProperty(String propertyName, Object propertyValue) {
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param", propertyValue);

		T queryResult = (T) query.getSingleResult();

		return queryResult;
	}

	public Long count() {
		String queryString = "SELECT COUNT(o) FROM " + getTypeClass().getName() + " o";

		Query query = entityManager.createQuery(queryString);

		Long queryResult = (Long) query.getSingleResult();

		return queryResult;
	}

	public Long countByProperty(String propertyName, Object propertyValue) {
		String queryString = "SELECT COUNT(o) FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param", propertyValue);

		Long queryResult = (Long) query.getSingleResult();

		return queryResult;
	}

	public Long countByTwoProperties(String firstPropertyName, Object firstPropertyValue, String secondPropertyName, Object secondPropertyValue) {
		String queryString = "SELECT COUNT(o) FROM " + getTypeClass().getName() + " o where o." + firstPropertyName + " = :param1 AND o." + secondPropertyName + " = :param2";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param1", firstPropertyValue);
		query.setParameter("param2", secondPropertyValue);

		Long queryResult = (Long) query.getSingleResult();

		return queryResult;
	}

	public T getByPropertyIgnoreCase(String propertyName, String propertyValue) {
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where lower(o." + propertyName + ") = lower(:param)";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param", propertyValue);

		List<T> queryResult = query.getResultList();

		T returnObject = null;

		if (!queryResult.isEmpty()) {
			returnObject = queryResult.get(0);
		}

		return returnObject;
	}

	public T getByTwoProperties(String firstPropertyName, String firstPropertyValue, String secondPropertyName, String secondPropertyValue) {
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + firstPropertyName + " = :param AND o." + secondPropertyName + " = :param2";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param", firstPropertyValue);
		query.setParameter("param2", secondPropertyValue);

		List<T> queryResult = query.getResultList();

		T returnObject = null;

		if (!queryResult.isEmpty()) {
			returnObject = queryResult.get(0);
		}

		return returnObject;
	}

	public List<T> listByProperty(String propertyName, String propertyValue) {
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param", propertyValue);

		List<T> queryResult = query.getResultList();

		return queryResult;
	}

	public List<T> listByTwoProperties(String firstPropertyName, String firstPropertyValue, String secondPropertyName, String secondPropertyValue) {
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + firstPropertyName + " = :param AND o." + secondPropertyName + " = :param2";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param", firstPropertyValue);
		query.setParameter("param2", secondPropertyValue);

		List<T> queryResult = query.getResultList();

		return queryResult;
	}

	public List<T> listByForeignOrObjectProperty(String propertyName, Object propertyValue) {
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param", propertyValue);

		List<T> queryResult = query.getResultList();

		return queryResult;
	}

	public List<T> listByTwoForeignOrObjectProperty(String firstPropertyName, Object firstPropertyValue, String secondPropertyName, Object secondPropertyValue) {
		String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + firstPropertyName + " = :param AND o." + secondPropertyName + " = :param2";

		Query query = entityManager.createQuery(queryString);
		query.setParameter("param", firstPropertyValue);
		query.setParameter("param2", secondPropertyValue);

		List<T> queryResult = query.getResultList();

		return queryResult;
	}
	
	public void save(T entity) {
		this.entityManager = JPAUtil.getEntityManager();
		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		this.entityManager = JPAUtil.getEntityManager();
		entityManager.merge(entity);
	}
	
	public void delete(T entity) {
		this.entityManager = JPAUtil.getEntityManager();
		entityManager.remove(entity);
	}
	
	public List<T> findAll() {
		this.entityManager = JPAUtil.getEntityManager();
		return entityManager.createQuery(("FROM " + getTypeClass().getName()))
				.getResultList();
	}
	
	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().
				getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}
}

