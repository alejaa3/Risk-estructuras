package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;

public class Vertex<T> implements Serializable{
	
	
	
	private static final long serialVersionUID = 6548595866935186725L;
	private T info;
	private MyLinkedList<Edge> adyacentEdges;

	public Vertex(T info) {
		this.info = info;
		adyacentEdges = new MyLinkedList<Edge>();
	}
	
	public void addEdge(Edge e) {
		adyacentEdges.addLast(e);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public MyLinkedList<Edge> getAdyacentEdges() {
		return adyacentEdges;
	}

	public void setAdyacentEdges(MyLinkedList<Edge> adyacentEdges) {
		this.adyacentEdges = adyacentEdges;
	}

	@Override
	public String toString() {
		return "\nVertex [info=" + info + ", adyacentEdges=" + adyacentEdges + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adyacentEdges, info);
	}

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
