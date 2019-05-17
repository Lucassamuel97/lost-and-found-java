package br.edu.utfpr.alunos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class JPAUtil {

	private static ThreadLocal<EntityManager> threadEntityManager =
			new ThreadLocal<EntityManager>();
	
	private static EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager;	
	private JPAUtil() {}	
	public JPAUtil(String persistenceUnit) {
		getEntityManager();
	}    
	
	//uso do padrão double-checked locking
    public static EntityManagerFactory getEntityManagerFactory() {
    	if (entityManagerFactory == null) {
    		synchronized(JPAUtil.class) {
    			if (entityManagerFactory == null){
    				entityManagerFactory = 
    						Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
    			}
			}			
		}
    	
    	return entityManagerFactory;
    }
	public static EntityManager getEntityManager() {		
				
		entityManagerFactory = getEntityManagerFactory();
		EntityManager entityManager = threadEntityManager.get();
		
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			JPAUtil.threadEntityManager.set(entityManager);
		}
		
		return entityManager;
	}
	
 
    public static void beginTransaction(){
    	EntityManager entityManager = threadEntityManager.get();    	
    	
    	if (entityManager == null) {
    		entityManager = getEntityManager();
    	}
    	
        entityManager.getTransaction().begin();
    }
     
    public static void commit(){
    	EntityManager entityManager = threadEntityManager.get();    	
    	
    	if (entityManager == null) {
    		entityManager = getEntityManager();
    	}
    	
    	EntityTransaction transaction = entityManager.getTransaction();
    	
    	if(transaction != null && transaction.isActive()){
    		entityManager.getTransaction().commit();
    	}        
    }
         
    public static void rollBack(){
    	EntityManager entityManager = threadEntityManager.get();    	
    	
    	if (entityManager == null) {
    		entityManager = getEntityManager();
    	}
    	
    	EntityTransaction transaction = entityManager.getTransaction();
    	
    	if(transaction != null && transaction.isActive()){
    		entityManager.getTransaction().rollback();
    	}
    }    
	
    
	public static void closeEntityManager() {
		EntityManager em = threadEntityManager.get();
		
		if (em != null) {		
			em.close();			
			threadEntityManager.set(null);
		}
	}
	
	public static void closeEntityManagerFactory() {		
		closeEntityManager();
		entityManagerFactory.close();		
	}	
}


