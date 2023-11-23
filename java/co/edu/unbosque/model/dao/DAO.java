package co.edu.unbosque.model.dao;

import java.io.Serializable;
import java.util.List;

import co.edu.unbosque.util.MyLinkedList;

public interface DAO<T, ID extends Serializable> {

	void saveOrUpdate(T entity);

	T get(ID id);

	void delete(T entity);

	MyLinkedList<T> findAll();

}
