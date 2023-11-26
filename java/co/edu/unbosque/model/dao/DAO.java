package co.edu.unbosque.model.dao;

import java.io.Serializable;
import java.util.List;

import co.edu.unbosque.util.MyLinkedList;

/**
 * Interfaz generica con las operaciones basicas de acceso a datos (CRUD).
 * 
 * @param <T> El tipo de entidad unico que manejara el DAO.
 * @param <ID> El tipo de identificador unico que tendra la entidad.
 * @author Sebastian Cardenas Garcia.
 */
public interface DAO<T, ID extends Serializable> {

	/**
	 * Guarda o Actualiza la entidad proporcionada.
	 * 
	 * @param entity La entidad a guardar o actualizar.
	 */
	void saveOrUpdate(T entity);

	/**
	 * Obtienen la identidad asociada al identificador unico proporcionado.
	 * 
	 * @param id El indentificador unico de la entidad.
	 * @return La entidad asociada al identificador unico, o null si se encuentra.
	 */
	T get(ID id);

	/**
	 * Elimina la entidad proporcionada.
	 * 
	 * @param entity La entidad a eliminar.
	 */
	void delete(T entity);

	/**
	 * Obtiene una lista enlazada de todas las entidades almacenadas.
	 * 
	 * @return Una {@link MyLinkedList} de todas las entidades.
	 */
	MyLinkedList<T> findAll();

}
