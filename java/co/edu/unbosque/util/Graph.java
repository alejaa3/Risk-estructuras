package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;

public class Graph implements Serializable{
	
	
	private static final long serialVersionUID = -1400202688928669462L;
	private MyLinkedList<Vertex<?>> listOfNodes;
	
	public Graph() {
		listOfNodes= new MyLinkedList<Vertex<?>>();
	}
	
	public void addVertex(Vertex<?> v) {
		listOfNodes.addLast(v);
	}

	public MyLinkedList<Vertex<?>> getListOfNodes() {
		return listOfNodes;
	}

	public void setListOfNodes(MyLinkedList<Vertex<?>> listOfNodes) {
		this.listOfNodes = listOfNodes;
	}
	
	@Override
	public String toString() {
		return "lista de nodos en el grafo: "+listOfNodes+" \n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(listOfNodes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		return Objects.equals(listOfNodes, other.listOfNodes);
	}
	
	
	
}
