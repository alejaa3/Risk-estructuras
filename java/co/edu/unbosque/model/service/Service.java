package co.edu.unbosque.model.service;

import java.util.List;

import co.edu.unbosque.util.MyLinkedList;

/**
 * Interfaz generica que proporciona las operaciones CRUD para acceso a la base de datos.
 * 
 * @param <T> El objeto que se va a guardar en la base de datos.
 * @param <ID> El identificador unico del objeto a guardar.
 * @author Sebastian Cardenas Garcia.
 */
public interface Service<T, ID> {

	/**
	 * Crea un nuevo objeto en la base de datos.
	 * 
	 * @param objeto El objeto a guardar.
	 */
	void create(T objeto);

	/**
	 * Aztualiza un objeto en la base de datos.
	 * 
	 * @param objeto El objeto a actualizar.
	 */
	void update(T objeto);

	/**
	 * Eliminar un objeto en la base de datos.
	 * 
	 * @param objeto El objeto a eliminar.
	 * @return El objeto que fue eliminado de la base de datos.
	 */
	T delete(T objeto);

	/**
	 * Obtiene un objeto de la base de datos segun su identificador unico.
	 * 
	 * @param id El indentificador unico.
	 * @return El objeto que teiene el identificardor unico, Si no existe retorna null.
	 */
	T findById(ID id);

	/**
	 * Obtiene la lista enlazada de todos los objetos de la base de datos.
	 * 
	 * @return Una {@link MyLinkedList} de los objetos de la base de datos.
	 */
	MyLinkedList<T> findAll();

}
