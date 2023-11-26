package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa una arista o la conexion entre dos vertices.
 * @see Vertex
 */
public class Edge implements Serializable{
	
	/**
	 * Numero de version para la serializacion.
	 */
	private static final long serialVersionUID = 5181512055656412406L;
	/**
	 * Vertice donde inicia el camino.
	 */
	private Vertex<?> source;
	/**
	 * Vertice donde termina el camino.
	 */
	private Vertex<?> destination;
	/**
	 * Peso que tiene el camino.
	 */
	private double value;
	
	/**
	 * Construye un Edge incializando todos sus atributos en null;
	 */
	public Edge() {
		
	}

	/**
	 * Construye un Edge con la informacion del vertice del origen, vertice de destino y el peso del camino.
	 * 
	 * @param source Referencia del vertice de origen.
	 * @param destination Referencia del vertice de destino.
	 * @param value Valor del camino.
	 */
	public Edge(Vertex<?> source, Vertex<?> destination, double value) {
		super();
		this.source = source;
		this.destination = destination;
		this.value = value;
	}
	
	/**
	 * Obtiene la informacion del vertice de origen.
	 * 
	 * @return El vertice de origen del camino.
	 */
	public Vertex<?> getSource() {
		return source;
	}

	/**
	 * Establece el vertice de origen del camino.
	 * 
	 * @param source El nuevo vertice de origen del camino.
	 */
	public void setSource(Vertex<?> source) {
		this.source = source;
	}
	
	/**
	 * Obtiene el vertice de destino del camino.
	 * 
	 * @return El vertice de destino del camino.
	 */
	public Vertex<?> getDestination() {
		return destination;
	}

	/**
	 * Establece el vertice de destino del camino.
	 * 
	 * @param destination El nuevo vertice de destino del camino.
	 */
	public void setDestination(Vertex<?> destination) {
		this.destination = destination;
	}

	/**
	 * Obtiene el valor del peso que tiene el camino.
	 * 
	 * @return El valor del peso que tiene el camino.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Establece el valor del peso del camino.
	 * 
	 * @param value El nuevo valor del peso del camino.
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Convierte el camino en una representacion de cadena.
	 * 
	 * @return Representacion en cadena del camino.
	 */
	@Override
	public String toString() {
		return "\n\tEdge [source=" + source.getInfo() + 
				", destination=" + destination.getInfo() + 
				", value=" + value + "]";
	}

	/**
	 * Calcula y devuelve el codigo hash del edge basado en el vertice destino, vertice origen y el peso del camino.
	 * 
	 * @return El codigo hash del nodo.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(destination, source, value);
	}

	 /**
     * Compara este edge con otro objeto para determinar la igualdad. Dos edges son iguales si tienen la misma
     * información.
     *
     * @param obj El objeto con el que se va a comparar.
     * @return true si los edges son iguales, false en caso contrario.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		return Objects.equals(destination, other.destination) && Objects.equals(source, other.source)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}
	
	
	
	
	

}
