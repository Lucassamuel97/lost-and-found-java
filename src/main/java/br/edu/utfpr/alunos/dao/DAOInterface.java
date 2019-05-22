package br.edu.utfpr.alunos.dao;

import java.util.List;

public interface DAOInterface<T> {
	
	T create(T p);
	
	List<T> findAll();
	
	void update(T p);
	
	void delete(T p);
	
	T find(Integer integer);
}
