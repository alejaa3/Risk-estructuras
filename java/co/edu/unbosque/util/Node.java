package co.edu.unbosque.util;

import java.io.Serializable;
import java.util.Objects;

public class Node<E> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1695511568813925001L;
	private E info;
	private Node<E> next;

	public Node(E info, Node<E> next) {
		this.info = info;
		this.next = next;
	}

	public Node(E info) {
		this(info, null);
	}

	public Node() {
		this(null, null);
	}

	public E getInfo() {
		return this.info;
	}

	public Node<E> getNext() {
		return this.next;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public String toString() {
		if (info != null) {
			return info.toString();
		} else {
			return null;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(info, next);
	}

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