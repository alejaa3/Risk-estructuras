package co.edu.unbosque.model.service;

import java.util.List;

import co.edu.unbosque.util.MyLinkedList;

public interface Service<T, ID> {

	void create(T objeto);

	void update(T objeto);

	T delete(T objeto);

	T findById(ID id);

	MyLinkedList<T> findAll();

}
