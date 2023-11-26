package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa un vertice generico que puede alamacenar informacion de cualquier tipo.
 * 
 * @param <T> El tipo de informacion que se almacenara en el vertice.
 */
public class Vertex<T> implements Serializable {

	/**
	 * Numero de version para la serializacion.
	 */
	private static final long serialVersionUID = 6548595866935186725L;
	/**
	 * Informacion que se almacenara en el vertice.
	 */
	private T info;
	/**
	 * Lista enlazada con las adyacencias al vertice.
	 */
	private MyLinkedList<Edge> adyacentEdges;

	/**
	 * Construye un vertice con la informacion que se almacenara y una lista enlazada de adyacencias vacia.
	 * 
	 * @param info La informacion a almacenar en el vertie.
	 */
	public Vertex(T info) {
		this.info = info;
		adyacentEdges = new MyLinkedList<Edge>();
	}

	/**
	 * Agrega un nuevo camino a la lista de adyacencias.
	 * 
	 * @param e {@link Edge} a agregar a la lista de adyacencias.
	 */
	public void addEdge(Edge e) {
		adyacentEdges.addLast(e);
	}

	/**
	 * Obtiene la informacion almacenada en el vertice.
	 * 
	 * @return La informacion almacenada en el vertice.
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Establece la informacion almacenada en el vertice.
	 * 
	 * @param info La nueva informacion a almacenar en el vertice.
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * Obtiene la lista enlazada de adyacencias.
	 * 
	 * @return La lista enlazada de las adyacencias al nodo.
	 */
	public MyLinkedList<Edge> getAdyacentEdges() {
		return adyacentEdges;
	}

	/**
	 * Establece la lista enlazada de adyacencias del vertice.
	 * 
	 * @param adyacentEdges La nueva lista de adyacencias a alamacenar en el vertice.
	 */
	public void setAdyacentEdges(MyLinkedList<Edge> adyacentEdges) {
		this.adyacentEdges = adyacentEdges;
	}

	/**
	 * Covierte la informacion en una representacion de cadena.
	 * 
	 * @return Representacion en cadena del vertice.
	 */
	@Override
	public String toString() {
		return "\nVertex [info=" + info + ", adyacentEdges=" + adyacentEdges + "]";
	}

	/**
	 * Calcula y devuelve el codigo hash del verice basado en la lista de adyacencias y en la informacion del vertice.
	 * 
	 * @return El codigo hash del vertice.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(adyacentEdges, info);
	}
	
	/**
     * Compara este vertice con otro objeto para determinar la igualdad. Dos vertice son iguales si tienen la misma
     * información y la misma lista de adyacencias.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si los vertices son iguales, false en caso contrario.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex<T> other = (Vertex<T>) obj;
		return Objects.equals(adyacentEdges, other.adyacentEdges) && Objects.equals(info, other.info);
	}

}
