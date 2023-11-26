package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import co.edu.unbosque.model.entity.Card;

/**
 * Implementacion de una lista enlazada simple.
 * 
 * @param <E> El tipo de elementso que se almacenaran en la lista.
 */
public class MyLinkedList<E> implements Iterable<E>, Serializable {

	/**
	 * Numero de version para la serializacion
	 */
	private static final long serialVersionUID = 791641166183999984L;
	
	/**
	 * El primer nodo en la lista enlazada.
	 */
	protected Node<E> first;

	/**
	 * Construye una lista enlazada vacia.
	 */
	public MyLinkedList() {
		this.first = null;
	}

	/**
	 * Obtiene el primer nodo de la lista enlazada.
	 * 
	 * @return el primer {@link Node} de la lista enlazada.
	 * @see Node
	 */
	public Node<E> getFirst() {
		return this.first;
	}

	/**
	 * Establece el primer nodo de la lista enlazada.
	 * 
	 * @param first El nuevo primer nodo en la lista enlazada.
	 */
	public void setFirst(Node<E> first) {
		this.first = first;
	}
	
	/**
	 *Verifica si la lista enlazada esta vacia
	 * 
	 * @return true si la lista esta vacia, false en caso contrario.
	 */
	public boolean isEmpty() {
		return (this.first == null);
	}

	/**
	 * Agrega un nuevo elemento a la cabeza de la lista.
	 * 
	 * @param info El elemento a agregar.
	 */
	public void add(E info) {
		Node<E> newNode = new Node<E>(info);
		newNode.setNext(this.first);
		first = newNode;
	}
	
	/**
	 * Inserta un nuevo elemento encualquier posiscion de la lista enlazada.
	 * 
	 * @param info El elemento a agregar.
	 * @param previous Referencia al anterior nodo de doden se va a insertar el nuevo elemento.
	 */
	public void insert(E info, Node<E> previous) {
		if (previous != null) {
			Node<E> newNode = new Node<E>(info);
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
		}
	}
	
	/**
	 * Agrega un nuevo nodo al final de la lista enlazada.
	 * 
	 * @param info El elemento a agregar.
	 */
	public void addLast(E info) {
		Node<E> lastNode = getLastNode();

		if (lastNode != null) {
			insert(info, lastNode);
		} else {
			this.first = new Node<E>(info);
			;
		}
	}
	
	/**
	 * Agrega todos los elementos de una clase List en la lista enlazada.
	 * 
	 * @param lista Elementos que se agregaran.
	 */
	public void addAll(List<E> lista) {
		for (E i : lista) {
			add(i);
		}
	}
	
	/**
	 * Extrae el primer elemento de la lista enlazada.
	 * 
	 * @return La informacion del elemento que se extrajo de la lista.
	 */
	public E extract() {
		E data = null;
		if (this.first != null) {
			data = this.first.getInfo();
			this.first = this.first.getNext();
		}
		return data;
	}
	
	/**
	 * Extrae un elemento de cualquier parte de la lista enlazada.
	 * 
	 * @param previous Un {@link Node} anterior al dato que se va a extraer.
	 * @return La iformacion del elemento que se extrajo.
	 */
	public E extract(Node<E> previous) {
		E data = null;
		if (previous != null && previous.getNext() != null) {
			data = previous.getNext().getInfo();
			previous.setNext(previous.getNext().getNext());
		}
		return data;
	}

	/**
	 * Obtiene el tamaño que tiene la lista.
	 * 
	 * @return El tamaño de la lista.
	 */
	public int size() {
		int size = 0;
		Node<E> current = this.first;

		while (current != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}


	/**
	 * Imprimr la informacion de la lista enlazada en forma de cadena.
	 * 
	 * @return Una representacion en cadena de la lista enlazada.
	 */
	public String print() {
		return this.toString();
	}

	/**
	 * Obtiene un nodo de la lista enlazada dado la informacion que este posee.
	 * 
	 * @param info Informacion del elemento a buscar.
	 * @return El {@link Nodo} con la informacion del parametro.
	 */
	public Node<E> get(E info) {
		Node<E> targetNode = null;
		Node<E> currentNode = this.first;

		while (currentNode != null && !currentNode.getInfo().equals(info)) {
			currentNode = currentNode.getNext();
		}
		if (currentNode != null) {
			targetNode = currentNode;
		}
		return targetNode;
	}

	/**
	 * Obtiene un elemento de la lista dado una posicion en la lista enlazada.
	 * 
	 * @param n Posicion en la lista enlazada.
	 * @return Elemento de la lista enlazada.
	 */
	public E get(int n) {
		Node<E> targetNode = null;
		Node<E> currentNode = this.first;
		int counter = 0;

		while (currentNode != null && counter < n) {
			currentNode = currentNode.getNext();
			counter++;
		}
		if (currentNode != null) {
			targetNode = currentNode;
		}
		return targetNode.getInfo();
	}
	
	/**
	 * Obtiene un nodo de la lista enlazada dada una posicionn en esta.
	 * 
	 * @param n Posicion en la lista enlazada.
	 * @return {@link Node} de la lista enlazada.
	 */
	public Node<E> get3(int n) {
		Node<E> targetNode = null;
		Node<E> currentNode = this.first;
		int counter = 0;
		
		while (currentNode != null && counter < n) {
			currentNode = currentNode.getNext();
			counter++;
		}
		if (currentNode != null) {
			targetNode = currentNode;
		}
		return targetNode;
	}

	/**
	 * El ultimo nodo de la lista enlazada.
	 * 
	 * @return Ultimo {@link Node} de la lista enlazada.
	 */
	public Node<E> getLastNode() {
		Node<E> current = this.first;

		while (current != null && current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}

	/**
	 * posicion de un elemento en la lista enlazada.
	 * 
	 * @param info Informacion del elemento.
	 * @return Posicion en la lista enlazada.
	 */
	public int get2(E info) {
		Node<E> current = this.first;
		int infoPosition = -1;

		if (!isEmpty()) {
			infoPosition = 0;
			while (current != null && !current.getInfo().equals(info)) {
				infoPosition++;
				current = current.getNext();
			}
		}
		return infoPosition;
	}

	/**
	 * Numero de veces que un elemento se repite en la lista.
	 * 
	 * @param info Un elemento a buscar en la lista enlazada.
	 * @return El numero de ocurrencias.
	 */
	public int numberOfOccurrences(E info) {
		int counter = 0;
		Node<E> current = this.first;

		while (current != null) {
			if (current.getInfo().equals(info)) {
				counter++;
			}
			current = current.getNext();
		}
		return counter;
	}

	/**
	 * Extrae el ultimo elemento de la lista enlazada.
	 * 
	 * @return La informacion del elemento extraido.
	 */
	public E extractLast() {
		E info = null;
		Node<E> current = this.first;
		int listSize = size();

		if (!isEmpty()) {
			if (listSize == 1) {
				info = current.getInfo();
				this.first = null;
			} else {
				Node<E> previousLastNode = get3(listSize - 2);
				info = extract(previousLastNode);
			}
		}
		return info;
	}

	/**
	 * Convierte la lista enlazada en una representacion en cadana a partir de una posicion en la lista.
	 * 
	 * @param position Posicion de un elemento en la lista enlazada.
	 * @return Una representacion en cadena de la lista enlazada o de una parte de esta.
	 */
	public String print(int position) {
		StringBuilder sb = new StringBuilder();
		Node<E> current = this.first;
		int counter = 0;

		if (!isEmpty()) {
			while (current != null && counter < position) {
				current = current.getNext();
				counter++;
			}
			while (current != null) {
				sb.append( current.getInfo().toString());
				if (current.getNext() != null) {
					sb = sb.append(" -> ");
				}
				current = current.getNext();
			}
		}
		return sb.toString();
	}
	

	/**
	 * Convierte la lista enlazada en una representacion en cadena.
	 * 
	 * @return Representacion en cadena de la lista enlazada.
	 */
	public String toString() {
		String listText = "";
		Node<E> current = this.first;

		while (current != null) {
			listText = listText + current.getInfo().toString();
			if (current.getNext() != null) {
				listText = listText + " -> ";
			}
			current = current.getNext();
		}
		return listText;
	}

	/**
	 * Aplica una funcion a cada uno de los elemento de la lista.
	 * 
	 * @param func Funcion que realizara cada uno de los elementos de la lista.
	 */
	public void aplicarFuncion(Funciones<E> func){
		Node<E> current = first;
		while(current != null){
			func.accion(current.getInfo());
			current = current.getNext();
		}
	}

	/**
	 * Calcular y devuelve el codigo hash de la lista enlazada a partir de la informacion del primer nodo.
	 * 
	 * @return El codigo hash de la lista enlazada.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(first);
	}

	/**
	 * Compara esta lista enlazada con otro objeto para determinar si son iguales, Dos listas enlazadas
	 * son iguales si tienen la misma informacion.
	 * 
	 * @param obj El objeto que se va a comparar.
	 * @retun true si las lista son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyLinkedList<E> other = (MyLinkedList<E>) obj;
		return Objects.equals(first, other.first);
	}

	/**
     * Devuelve un iterador sobre los elementos de esta lista.
     *
     * @return Un iterador sobre los elementos de esta lista.
     * @see Iterador
     */
	@Override
	public Iterator<E> iterator() {
		return new Iterador();
	}
	
	/**
     * Clase interna que implementa la interfaz {@link Iterator}.
     */
	private class Iterador implements Iterator<E>{
		/**
		 * El primer elemento de la lista enlazada.
		 */
		private Node<E> current = first;

		/**
		 * verifica si hay mas elementos en la lista enlazada.
		 * 
		 * @return true si hay mas elementos en la lista enlazada, false en caso contrario.
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Devuelver el siguiente elemento en la lista.
		 * 
		 * @return El siguiente elemento en la lista.
		 */
		@Override
		public E next() {
			E dato = current.getInfo();
			current = current.getNext();
			return dato;
		}
	}
}