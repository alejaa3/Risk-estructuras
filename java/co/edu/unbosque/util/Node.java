package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;


/**
 * Esta clase representa un nodo generico que puede almacenar informacion de cualquier tipo
 * 
 * @param <E> El tipo de informacion que se almacenara en el nodo
 */
public class Node<E> implements Serializable{

	/**
	 * Numero de version para la serializacion
	 */
	private static final long serialVersionUID = 1695511568813925001L;
	/**
	 * La informacion almacenada en el nodo.
	 */
	private E info;
	/**
	 * Es un puntero hacia un nodo siguiente en la secuencia.
	 */
	private Node<E> next;

	/**
	 * Construye un nodo con la informacion que se almacenara y la referencia 
	 * al nodo siguiente en la secuencia.
	 * 
	 * @param info La informacion a almacenar en el nodo.
	 * @param next La referencia al nodo siguiente en la secuencia.
	 */
	public Node(E info, Node<E> next) {
		this.info = info;
		this.next = next;
	}
	
	/**
	 * Contruye un nodo con la informacion que va a tener pero sin una referencia 
	 * a un nodo siguiente en la secuencia.
	 * 
	 * @param info La informacion a almacenar en el nodo.
	 */
	public Node(E info) {
		this(info, null);
	}

	/**
	 * Contruye un nodo sin informacion y sin nodo siguiente.
	 */
	public Node() {
		this(null, null);
	}

	/**
	 * Obtiene la informacion almacenada en el nodo.
	 * 
	 * @return La informacion almacenada en el nodo.
	 */
	public E getInfo() {
		return this.info;
	}

	/**
	 * Obtiene la referencia al nodo siguiente en la secuencia.
	 * 
	 * @return El siguiente nodo en la secuencia
	 */
	public Node<E> getNext() {
		return this.next;
	}

	/**
	 * Estable la informacion almacenada en el nodo.
	 * 
	 * @param info La nueva informacion a almacenar en el nodo.
	 */
	public void setInfo(E info) {
		this.info = info;
	}

	/**
	 * Establece la nueva referencia al nodo siguiente en la secuencia.
	 * 
	 * @param next El nuevo nodo siguiente en la secuencia.
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}

	/**
	 * Convierte el nodo en una representacion de cadena. Si el nodo es null devuelve nulo.
	 * 
	 * @return Una representacion en cadena del nodo.
	 */
	public String toString() {
		if (info != null) {
			return info.toString();
		} else {
			return null;
		}
	}

	/**
	 * Calcula y devuelve el codigo hash del nodo basado en la informacion y la referencia al nodo siguiente.
	 * 
	 * @return El codigo hash del nodo.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(info, next);
	}

	 /**
     * Compara este nodo con otro objeto para determinar la igualdad. Dos nodos son iguales si tienen la misma
     * información y el mismo siguiente nodo.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si los nodos son iguales, false en caso contrario.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node<E> other = (Node<E>) obj;
		return Objects.equals(info, other.info) && Objects.equals(next, other.next);
	}
	
	
}