package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;

public class Edge implements Serializable{
	
	
	private static final long serialVersionUID = 5181512055656412406L;
	private Vertex<?> source;
	private Vertex<?> destination;
	private double value;
	
	public Edge() {
		
	}

	public Edge(Vertex<?> source, Vertex<?> destination, double value) {
		super();
		this.source = source;
		this.destination = destination;
		this.value = value;
	}



	public Vertex<?> getSource() {
		return source;
	}

	public void setSource(Vertex<?> source) {
		this.source = source;
	}

	public Vertex<?> getDestination() {
		return destination;
	}

	public void setDestination(Vertex<?> destination) {
		this.destination = destination;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "\n\tEdge [source=" + source.getInfo() + 
				", destination=" + destination.getInfo() + 
				", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(destination, source, value);
	}

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
